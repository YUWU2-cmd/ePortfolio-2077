package com.eportfolio2077.eportfolio.dto;

import com.eportfolio2077.eportfolio.entity.Project;
import lombok.Data;

import java.util.List;

@Data
public class ProjectWrapper {
    private String seriesName;
    private String summary;
    private List<Project> projects;
    private Long siteId;
}
