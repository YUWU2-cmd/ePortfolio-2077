package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.Site;
import com.eportfolio2077.eportfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteDao extends JpaRepository<Site, Long> {
    List<Site> getAllByUser(User user);
    Site getSiteByUserAndSiteId(Long userId, Long siteId);
    Site getSiteBySiteId(Long siteId);
}
