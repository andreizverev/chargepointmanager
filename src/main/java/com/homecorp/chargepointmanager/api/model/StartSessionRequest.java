package com.homecorp.chargepointmanager.api.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StartSessionRequest {
    @NotNull
    private Integer rfidTagNumber;
    @NotEmpty
    private String chargePointUniqueSerialNumber;

    @NotNull
    @Min(1)
    private Integer connectorNumber;
}
