package com.homecorp.chargepointmanager.gateway;

//This abstraction is not defined in the task.
//It represents api to a gauge that controls consumed electricity from a connector.
public interface ConnectorGateway {
    Long getMeterValue(String chargePointUniqueSerialNumber, Integer connectorNumber);
}
