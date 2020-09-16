package com.eportfolio2077.eportfolio.service;

import com.eportfolio2077.eportfolio.dao.SiteDao;
import com.eportfolio2077.eportfolio.dao.UserDao;
import com.eportfolio2077.eportfolio.entity.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashBoardService {
    @Autowired
    SiteDao siteDao;
    @Autowired
    UserDao userDao;

    public void createSite(Long userId) {
        Site site = new Site();
        site.setUser(userDao.getUserByUserId(userId));
        siteDao.save(site);
    }

    public List<Site> fetchAllSitePage(Long userId) {
        return siteDao.getAllByUser(userDao.getUserByUserId(userId));
    }

    public Site fetchSitePage(Long siteId) {
        return siteDao.getSiteBySiteId(siteId);
    }
}
