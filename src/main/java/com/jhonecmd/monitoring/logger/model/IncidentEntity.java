package com.jhonecmd.monitoring.logger.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "incidents")
@Data
public class IncidentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Category category;
}
