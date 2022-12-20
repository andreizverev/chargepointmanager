package com.homecorp.chargepointmanager.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "charge_points")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargePointEntity {
    @Id
    private String uniqueSerialNumber;
    private String name;
    @OneToMany
    private Set<ConnectorEntity> connectors;
}
