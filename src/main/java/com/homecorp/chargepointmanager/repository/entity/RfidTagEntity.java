package com.homecorp.chargepointmanager.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rfid_tags")
@NoArgsConstructor
@AllArgsConstructor
public class RfidTagEntity {
    private String name;
    @Id
    private Integer number;
    @OneToOne
    private VehicleEntity vehicle;
}
