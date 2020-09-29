package com.eportfolio2077.eportfolio.service;

import com.eportfolio2077.eportfolio.dao.BlogDao;
import com.eportfolio2077.eportfolio.dao.ImageDao;
import com.eportfolio2077.eportfolio.dao.SiteDao;
import com.eportfolio2077.eportfolio.dao.UserDao;
import com.eportfolio2077.eportfolio.dto.SiteDto;
import com.eportfolio2077.eportfolio.entity.Blog;
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
    @Autowired
    BlogDao blogDao;

    public Site createSite(Long userId) {
        Site site = new Site();
        site.setUser(userDao.getUserByUserId(userId));
        siteDao.save(site);
        return site;
    }

    public List<Site> fetchAllSitePage(Long userId) {
        return siteDao.getAllByUser(userDao.getUserByUserId(userId));
    }

    public SiteDto fetchSitePage(Long userId, Long siteId) {
        User user = userDao.getUserByUserId(userId);
        Site site = siteDao.getSiteByUserAndSiteId(user, siteId);
        List<Image> images = imageDao.findImagesBySite(site);
        List<Blog> blogs = blogDao.findBlogBySite(site);
        return new SiteDto(images,blogs);
    }

    public void deleteSite(Long userId, Long siteId){
        User user = userDao.getUserByUserId(userId);
        Site site = siteDao.getSiteByUserAndSiteId(user, siteId);
        imageDao.deleteAllBySite(site);
        blogDao.deleteAllBySite(site);
        siteDao.deleteByUserAndSiteId(user, siteId);

    }
}
