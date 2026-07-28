package com.jhonecmd.monitoring.logger.controller;

import com.jhonecmd.monitoring.logger.dto.IncidentDTO;
import com.jhonecmd.monitoring.logger.model.IncidentEntity;
import com.jhonecmd.monitoring.logger.service.IncidentService;
import com.jhonecmd.monitoring.logger.utils.AppLogger;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidents")
@AllArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;
    private final Logger logger = AppLogger.logger(IncidentController.class);


    @PostMapping()
    public ResponseEntity<Object> save(@Valid @RequestBody IncidentDTO incidentDTO) {
        try {
            logger.info("Creating an incident via the controller!");
            IncidentEntity incident = IncidentEntity.builder().name(incidentDTO.getName()).description(incidentDTO.getDescription())
                    .category(incidentDTO.getCategory()).build();
            incidentService.processIncident(incident);
            return  ResponseEntity.status(HttpStatus.CREATED).body(incident.getName());
        } catch (RuntimeException e) {
            logger.error("Error creating an incident!");
            throw new RuntimeException(e);
        }
    }

    @GetMapping()
    public ResponseEntity<List<IncidentEntity>> findAll() {
       try {
           logger.info("Performing a search for all tickets handled by the controller!");
           return  ResponseEntity.ok(incidentService.fetchAll());
       } catch (RuntimeException e) {
           logger.error("Error retrieving all incidents!");
           throw new RuntimeException(e);
       }
    }
}
