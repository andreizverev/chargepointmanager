package com.homecorp.chargepointmanager.service;

import com.homecorp.chargepointmanager.repository.ChargePointRepository;
import com.homecorp.chargepointmanager.repository.ConnectorRepository;
import com.homecorp.chargepointmanager.repository.entity.ConnectorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConnectorManager {

    private final ConnectorRepository connectorRepository;
    private final ChargePointRepository chargePointRepository;

    @Transactional
    public ConnectorEntity createConnector(ConnectorEntity connector) {
        if (!chargePointRepository.existsById(connector.getId().getChargePointUniqueSerialNumber())) {
            throw new IllegalArgumentException(String.format("Change point %s does not exist", connector.getId().getChargePointUniqueSerialNumber()));
        }
        if (connectorRepository.existsById(connector.getId())) {
            throw new IllegalArgumentException(String.format("Connector %s for '%s' charge point already exists", connector.getId().getNumber(), connector.getId().getChargePointUniqueSerialNumber()));
        }
        return connectorRepository.save(connector);
    }
}
