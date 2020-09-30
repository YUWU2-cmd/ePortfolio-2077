package com.eportfolio2077.eportfolio.dto;

import com.eportfolio2077.eportfolio.entity.Experience;
import lombok.Data;

import java.util.List;

@Data
public class ExperienceWrapper {
    private List<Experience> experiences;
    private Long siteId;
}
