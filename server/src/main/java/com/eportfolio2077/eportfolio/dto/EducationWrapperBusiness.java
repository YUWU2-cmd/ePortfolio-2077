package com.eportfolio2077.eportfolio.dto;

import com.eportfolio2077.eportfolio.entity.Education;
import lombok.Data;

@Data
public class EducationWrapperBusiness {
    private Education education;
    private Long siteId;
}
