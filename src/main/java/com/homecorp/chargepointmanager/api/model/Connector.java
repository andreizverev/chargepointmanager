package com.homecorp.chargepointmanager.api.model;

import lombok.Data;

@Data
public class Connector {
    private ConnectorId id;

    @Data
    public static class ConnectorId {
        private String chargePointUniqueSerialNumber;
        private Integer number;
    }
}
