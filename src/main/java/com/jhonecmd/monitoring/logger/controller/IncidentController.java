package com.jhonecmd.monitoring.logger.controller;

import com.jhonecmd.monitoring.logger.model.IncidentEntity;
import com.jhonecmd.monitoring.logger.service.IncidentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/incidents")
@AllArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;

    @GetMapping()
    public ResponseEntity<List<IncidentEntity>> findAll() {
       try {
           return  ResponseEntity.ok(incidentService.fetchAll());
       } catch (RuntimeException e) {
           throw new RuntimeException(e);
       }
    }
}
