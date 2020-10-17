package com.eportfolio2077.eportfolio.dto;

import com.eportfolio2077.eportfolio.entity.UserSkill;
import lombok.Data;

import java.util.List;

@Data
public class UserSkillDtoBusiness {
    private List<UserSkill> skillList;
    private List<UserSkill> languageList;

}
