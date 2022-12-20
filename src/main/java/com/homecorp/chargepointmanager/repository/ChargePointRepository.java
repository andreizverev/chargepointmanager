package com.homecorp.chargepointmanager.repository;

import com.homecorp.chargepointmanager.repository.entity.ChargePointEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargePointRepository extends CrudRepository<ChargePointEntity, String> {
}
