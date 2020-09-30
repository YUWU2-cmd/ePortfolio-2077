package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSkillDao extends JpaRepository<UserSkill, Long> {
    List<UserSkill> getAllBySiteIdAndSkillType(Long siteId, String skillType);
    void deleteAllBySiteId(Long siteId);
}
