package com.homecorp.chargepointmanager.repository.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "connectors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectorEntity {
    @EmbeddedId
    private ConnectorId id;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ConnectorId implements Serializable {
        private String chargePointUniqueSerialNumber;
        private Integer number;
    }
}
