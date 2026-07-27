package com.jhonecmd.monitoring.logger.dto;

import com.jhonecmd.monitoring.logger.model.Category;
import lombok.Data;

@Data
public class IncidentDTO {
    private Integer id;
    private String name;
    private String description;
    private Category category;
}
