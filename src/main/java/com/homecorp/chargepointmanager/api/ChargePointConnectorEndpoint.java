package com.homecorp.chargepointmanager.api;

import com.homecorp.chargepointmanager.api.model.Connector;
import com.homecorp.chargepointmanager.api.model.CreateConnectorRequest;
import com.homecorp.chargepointmanager.repository.entity.ConnectorEntity;
import com.homecorp.chargepointmanager.service.ConnectorManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restapi/chargepoints")
@RequiredArgsConstructor
public class ChargePointConnectorEndpoint {

    private final ModelMapper modelMapper;
    private final ConnectorManager connectorManager;

    @PostMapping("/{chargePointUniqueSerialNumber}/connectors")
    public Connector createConnector(@PathVariable String chargePointUniqueSerialNumber, @RequestBody @Valid CreateConnectorRequest createConnectorRequest) {
        ConnectorEntity entity = new ConnectorEntity(new ConnectorEntity.ConnectorId(chargePointUniqueSerialNumber, createConnectorRequest.getNumber()));
        return modelMapper.map(connectorManager.createConnector(entity), Connector.class);
    }
}
