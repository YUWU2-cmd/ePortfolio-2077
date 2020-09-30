package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.ProjectSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectSeriesDao extends JpaRepository<ProjectSeries, Long> {
    ProjectSeries getBySiteId(Long siteId);
}
