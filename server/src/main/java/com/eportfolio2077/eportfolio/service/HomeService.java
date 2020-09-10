package com.eportfolio2077.eportfolio.service;


import com.eportfolio2077.eportfolio.dao.BlogDao;
import com.eportfolio2077.eportfolio.dao.ImageDao;
import com.eportfolio2077.eportfolio.dto.HomeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    BlogDao blogDao;
    @Autowired
    ImageDao imageDao;

    public HomeDto fetchHomePage(Long userId){
        return new HomeDto(blogDao.findBlogByUserId(userId), imageDao.findImagesByUserId(userId));
    }

}
