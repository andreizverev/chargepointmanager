package com.homecorp.chargepointmanager.service;


import com.homecorp.chargepointmanager.api.model.StartSessionRequest;
import com.homecorp.chargepointmanager.gateway.ConnectorGateway;
import com.homecorp.chargepointmanager.repository.ChargingSessionRepository;
import com.homecorp.chargepointmanager.repository.entity.ChargingSessionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChargingSessionService {
    private final ChargingSessionRepository chargingSessionRepository;
    private final ConnectorGateway connectorGateway;

    public Long startSession(StartSessionRequest request) {
        return chargingSessionRepository
                .save(ChargingSessionEntity.builder()
                        .rfidTagNumber(request.getRfidTagNumber())
                        .timeStart(OffsetDateTime.now())
                        .chargePointUniqueSerialNumber(request.getChargePointUniqueSerialNumber())
                        .connectorNumber(request.getConnectorNumber())
                        .meterStart(connectorGateway.getMeterValue(request.getChargePointUniqueSerialNumber(), request.getConnectorNumber()))
                        .build())
                .getId();
    }

    public void stop(Long chargeSessionId) {
        ChargingSessionEntity chargingSession = chargingSessionRepository.findById(chargeSessionId)
                .orElseThrow(() -> new IllegalStateException("Unknown charging sessionId: " + chargeSessionId));
        chargingSessionRepository
                .save(chargingSession.toBuilder()
                        .rfidTagNumber(chargingSession.getRfidTagNumber())
                        .timeEnd(OffsetDateTime.now())
                        .meterEnd(connectorGateway.getMeterValue(chargingSession.getChargePointUniqueSerialNumber(), chargingSession.getConnectorNumber()))
                        .build());
    }

    public List<ChargingSessionEntity> getChargingSessions(OffsetDateTime from, OffsetDateTime to) {
        return chargingSessionRepository.findAllByTimeStartBetween(from, to);
    }
}
