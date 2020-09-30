package com.eportfolio2077.eportfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserSkillWrapper {
    private List<String> proList;
    private List<String> addList;
    private Long siteId;
}
