package com.homecorp.chargepointmanager.api.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateConnectorRequest {
    @NotNull
    @Min(1)
    private Integer number;
}
