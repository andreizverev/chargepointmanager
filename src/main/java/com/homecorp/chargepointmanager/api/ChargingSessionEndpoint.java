package com.homecorp.chargepointmanager.api;

import com.homecorp.chargepointmanager.api.model.ChargingSession;
import com.homecorp.chargepointmanager.api.model.StartSessionRequest;
import com.homecorp.chargepointmanager.service.ChargingSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/restapi/chargingsessions")
@RequiredArgsConstructor
public class ChargingSessionEndpoint {

    private final ModelMapper modelMapper;
    private final ChargingSessionService chargingSessionService;

    @PostMapping("/start")
    public Long startSession(@RequestBody @Valid StartSessionRequest request) {
        return chargingSessionService.startSession(request);
    }

    @PostMapping("/{chargeSessionId}/stop")
    public void stopSession(@PathVariable Long chargeSessionId) {
        chargingSessionService.stop(chargeSessionId);
    }

    @GetMapping
    public List<ChargingSession> getChargingSessions(OffsetDateTime from, OffsetDateTime to) {
        return chargingSessionService.getChargingSessions(from, to).stream()
                .map(e -> modelMapper.map(e, ChargingSession.class))
                .collect(toList());
    }
}
