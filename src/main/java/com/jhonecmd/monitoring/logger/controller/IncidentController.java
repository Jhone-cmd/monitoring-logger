package com.jhonecmd.monitoring.logger.controller;

import com.jhonecmd.monitoring.logger.dto.IncidentDTO;
import com.jhonecmd.monitoring.logger.model.IncidentEntity;
import com.jhonecmd.monitoring.logger.service.IncidentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidents")
@AllArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;

    @PostMapping()
    public ResponseEntity<Object> save(@Valid @RequestBody IncidentDTO incidentDTO) {
        try {
            IncidentEntity incident = IncidentEntity.builder().name(incidentDTO.getName()).description(incidentDTO.getDescription())
                    .category(incidentDTO.getCategory()).build();
            incidentService.processIncident(incident);
            return  ResponseEntity.status(HttpStatus.CREATED).body(incident.getName());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping()
    public ResponseEntity<List<IncidentEntity>> findAll() {
       try {
           return  ResponseEntity.ok(incidentService.fetchAll());
       } catch (RuntimeException e) {
           throw new RuntimeException(e);
       }
    }
}
