package com.homecorp.chargepointmanager.gateway;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ConnectorGatewayMock implements ConnectorGateway {
    private final Map<String, AtomicLong> meters = new ConcurrentHashMap<>();

    @Override
    public Long getMeterValue(String chargePointUniqueSerialNumber, Integer connectorNumber) {
        return meters.computeIfAbsent(getKey(chargePointUniqueSerialNumber, connectorNumber), k -> new AtomicLong())
                .incrementAndGet();
    }

    private static String getKey(String chargePointUniqueSerialNumber, Integer connectorNumber) {
        return chargePointUniqueSerialNumber + "-" + connectorNumber;
    }
}
