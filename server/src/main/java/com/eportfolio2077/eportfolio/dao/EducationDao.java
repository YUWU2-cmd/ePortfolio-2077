package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationDao extends JpaRepository<Education, Long> {
    Education getEducationBySiteIdAndBusiness(Long siteId, String business);
    List<Education> getAllBySiteIdAndBusiness(Long siteId, String business);
    void deleteAllBySiteIdAndBusiness(Long siteId, String business);
    void deleteEducationBySiteIdAndBusiness(Long siteId, String business);
    void deleteAllBySiteId(Long siteId);
}
