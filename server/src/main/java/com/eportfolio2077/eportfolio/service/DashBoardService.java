package com.eportfolio2077.eportfolio.service;

import com.eportfolio2077.eportfolio.dao.ImageDao;
import com.eportfolio2077.eportfolio.dao.SiteDao;
import com.eportfolio2077.eportfolio.dao.UserDao;
import com.eportfolio2077.eportfolio.entity.Image;
import com.eportfolio2077.eportfolio.entity.Site;
import com.eportfolio2077.eportfolio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DashBoardService {
    @Autowired
    SiteDao siteDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    SiteService siteService;

    public Site createSite(Long userId, String template) {
        Site site = new Site();
        site.setUser(userDao.getUserByUserId(userId));
        site.setTemplate(template);
        site.setVisit(0);
        siteDao.save(site);
        return site;
    }

    public List<Site> fetchAllSitePage(Long userId) {
        return siteDao.getAllByUser(userDao.getUserByUserId(userId));
    }

    public Site fetchSitePage(Long siteId) {
        Site site = siteDao.getSiteBySiteId(siteId);
        return site;
    }

    @Transactional
    public void deleteSite(Long userId, Long siteId){
        User user = userDao.getUserByUserId(userId);
        siteService.deleteRelated(siteId);
        siteDao.deleteByUserAndSiteId(user, siteId);
    }

    @Transactional
    public void renameSite(String name, Long siteId){
        Site site = siteDao.getSiteBySiteId(siteId);
        site.setSiteName(name);
    }
}
