package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationDao extends JpaRepository<Education, Long> {
    List<Education> getAllBySiteId(Long siteId);
    void deleteAllBySiteId(Long siteId);
}
