package com.eportfolio2077.eportfolio.dto;

import com.eportfolio2077.eportfolio.entity.Education;
import lombok.Data;

import java.util.List;

@Data
public class EducationWrapper {
    private List<Education> educations;
    private Long siteId;
}
