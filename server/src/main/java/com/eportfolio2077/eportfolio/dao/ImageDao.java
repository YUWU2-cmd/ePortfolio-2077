package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDao extends JpaRepository<Image, Long> {
    List<Image> getAllBySiteId(Long siteId);
    void deleteAllBySiteId(Long siteId);
    void deleteBySiteIdAndImageId(Long siteId, Long imageId);
}
