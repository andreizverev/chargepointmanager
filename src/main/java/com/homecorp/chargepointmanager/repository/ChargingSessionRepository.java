package com.homecorp.chargepointmanager.repository;

import com.homecorp.chargepointmanager.repository.entity.ChargingSessionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface ChargingSessionRepository extends CrudRepository<ChargingSessionEntity, Long> {
    List<ChargingSessionEntity> findAllByTimeStartBetween(OffsetDateTime from, OffsetDateTime to);
}
