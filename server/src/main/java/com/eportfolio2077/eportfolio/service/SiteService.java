package com.eportfolio2077.eportfolio.service;


import com.eportfolio2077.eportfolio.dao.BlogDao;
import com.eportfolio2077.eportfolio.dao.ImageDao;
import com.eportfolio2077.eportfolio.dao.SiteDao;
import com.eportfolio2077.eportfolio.dao.UserDao;
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

    //TODO all update stuff
//    public String updateBlog(String blog){
//        blogDao.save()
//    }


}