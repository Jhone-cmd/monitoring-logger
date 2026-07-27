package com.jhonecmd.monitoring.logger.service;

import com.jhonecmd.monitoring.logger.model.IncidentEntity;
import com.jhonecmd.monitoring.logger.repository.IncidentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public void processIncident(IncidentEntity incidentEntity) {
        incidentRepository.save(incidentEntity);
        return;
    }

    public List<IncidentEntity> fetchAll() {
        return incidentRepository.findAll();
    }
}
