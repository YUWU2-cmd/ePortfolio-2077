package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDao extends JpaRepository<Project, Long> {
    List<Project> getAllByProjectSeriesId(Long projectSeriesId);
    void deleteAllByProjectSeriesId(Long projectSeriesId);
}
