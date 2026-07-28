package com.jhonecmd.monitoring.logger.service;

import com.jhonecmd.monitoring.logger.model.IncidentEntity;
import com.jhonecmd.monitoring.logger.repository.IncidentRepository;
import com.jhonecmd.monitoring.logger.startApp.StartApp;
import com.jhonecmd.monitoring.logger.utils.AppLogger;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final Logger logger = AppLogger.logger(IncidentService.class);

    public void processIncident(IncidentEntity incidentEntity) {
        logger.info("Receiving the incident call!");
        logger.info("Forwarding the incident to the responsible department!");
        incidentRepository.save(incidentEntity);
        return;
    }

    public List<IncidentEntity> fetchAll() {
        logger.info("Fetching for all tickets submitted!");
        return incidentRepository.findAll();
    }
}
