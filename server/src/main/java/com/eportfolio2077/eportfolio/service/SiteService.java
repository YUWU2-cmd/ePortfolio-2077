package com.eportfolio2077.eportfolio.service;


import com.eportfolio2077.eportfolio.dao.BlogDao;
import com.eportfolio2077.eportfolio.dao.ImageDao;
import com.eportfolio2077.eportfolio.dao.SiteDao;
import com.eportfolio2077.eportfolio.dao.UserDao;
import com.eportfolio2077.eportfolio.dto.BlogDto;
import com.eportfolio2077.eportfolio.entity.Blog;
import com.eportfolio2077.eportfolio.entity.Image;
import com.eportfolio2077.eportfolio.entity.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SiteService {
    @Autowired
    SiteDao siteDao;
    @Autowired
    BlogDao blogDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    UserDao userDao;


    public void updateBlog(BlogDto blogDto){
        Blog blog = new Blog(blogDto);
        Site site = siteDao.getSiteBySiteId(blogDto.getSiteID());
        blog.setSite(site);
        blogDao.save(blog);
    }

    public void updateImg(String imagePath, Long siteId){
        Image image = new Image(imagePath);
        Site site = siteDao.getSiteBySiteId(siteId);
        image.setSite(site);
        imageDao.save(image);
    }


}