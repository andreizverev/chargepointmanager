package com.homecorp.chargepointmanager.api.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ChargingSession {
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
