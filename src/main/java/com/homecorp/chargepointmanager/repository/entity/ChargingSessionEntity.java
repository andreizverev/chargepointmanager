package com.homecorp.chargepointmanager.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "charging_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ChargingSessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rfidTagNumber;
    private String chargePointUniqueSerialNumber;
    private Integer connectorNumber;
    private OffsetDateTime timeStart;
    private Long meterStart;
    private OffsetDateTime timeEnd;
    private Long meterEnd;
    private String errorMessage;
}
