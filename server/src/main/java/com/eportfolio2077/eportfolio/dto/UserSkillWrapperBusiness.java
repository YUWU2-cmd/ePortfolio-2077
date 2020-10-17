package com.eportfolio2077.eportfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserSkillWrapperBusiness {
    private List<String> skillList;
    private List<Integer> skillScore;
    private List<String> languageList;
    private List<Integer> languageScore;
    private Long siteId;
}
