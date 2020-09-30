package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceDao extends JpaRepository<Experience, Long> {
    List<Experience> getAllBySiteId(Long siteId);
    void deleteAllBySiteId(Long siteId);
}
