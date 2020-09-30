package com.eportfolio2077.eportfolio.service;

import com.eportfolio2077.eportfolio.dao.ImageDao;
import com.eportfolio2077.eportfolio.dao.SiteDao;
import com.eportfolio2077.eportfolio.dao.UserDao;
import com.eportfolio2077.eportfolio.entity.Image;
import com.eportfolio2077.eportfolio.entity.Site;
import com.eportfolio2077.eportfolio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashBoardService {
    @Autowired
    SiteDao siteDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ImageDao imageDao;

    public Site createSite(Long userId, String template) {
        Site site = new Site();
        site.setUser(userDao.getUserByUserId(userId));
        site.getUser().setPassword(null);
        site.setTemplate(template);
        siteDao.save(site);
        return site;
    }

    public List<Site> fetchAllSitePage(Long userId) {
        return siteDao.getAllByUser(userDao.getUserByUserId(userId));
    }

    public Site fetchSitePage(Long userId, Long siteId) {
        User user = userDao.getUserByUserId(userId);
        Site site = siteDao.getSiteByUserAndSiteId(user, siteId);
        return site;
    }

    public void deleteSite(Long userId, Long siteId){
        //TODO
        User user = userDao.getUserByUserId(userId);
        Site site = siteDao.getSiteByUserAndSiteId(user, siteId);
        imageDao.deleteAllBySiteId(site.getSiteId());
        siteDao.deleteByUserAndSiteId(user, siteId);

    }
}
