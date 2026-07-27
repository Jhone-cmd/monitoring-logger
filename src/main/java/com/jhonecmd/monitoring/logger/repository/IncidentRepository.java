package com.jhonecmd.monitoring.logger.repository;

import com.jhonecmd.monitoring.logger.model.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<IncidentEntity, Integer> {
}
