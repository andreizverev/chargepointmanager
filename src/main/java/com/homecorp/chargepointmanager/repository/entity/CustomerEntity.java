package com.homecorp.chargepointmanager.repository.entity;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    private String name;
    @OneToMany
    private Set<ChargePointEntity> chargePoints;
    @OneToMany
    private Set<RfidTagEntity> rfidTags;
}
