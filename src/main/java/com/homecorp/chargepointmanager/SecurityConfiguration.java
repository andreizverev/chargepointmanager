package com.homecorp.chargepointmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public UserDetailsService users() {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        return new InMemoryUserDetailsManager(
                userBuilder
                        .username("customer")
                        .password("password")
                        .roles("Customer")
                        .build(),
                userBuilder.username("admin")
                        .password("password")
                        .roles("Admin")
                        .build());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/actuator/**").anonymous()
                                .requestMatchers("/restapi/chargingsessions/start", "/restapi/chargingsessions/*/stop").hasRole("Customer")
                                .requestMatchers("/restapi/chargingsessions", "/restapi/chargepoints/*/connectors").hasRole("Admin")
                                .anyRequest().denyAll()
                )
                .httpBasic(withDefaults());
        return http.build();
    }
}
