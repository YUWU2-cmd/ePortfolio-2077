package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDao extends JpaRepository<File, String> {
}
