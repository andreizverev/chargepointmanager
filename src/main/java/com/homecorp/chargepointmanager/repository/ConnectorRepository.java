package com.homecorp.chargepointmanager.repository;

import com.homecorp.chargepointmanager.repository.entity.ConnectorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectorRepository extends CrudRepository<ConnectorEntity, ConnectorEntity.ConnectorId> {
}
