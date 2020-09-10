package com.eportfolio2077.eportfolio.service;


import com.eportfolio2077.eportfolio.dao.BlogDao;
import com.eportfolio2077.eportfolio.dao.ImageDao;
import com.eportfolio2077.eportfolio.dto.HomeDto;
import com.eportfolio2077.eportfolio.entity.Blog;
import com.eportfolio2077.eportfolio.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    BlogDao blogDao;
    @Autowired
    ImageDao imageDao;

    public void createHomePage(Long userId){
        Blog blog = new Blog(userId);
        Image image = new Image(userId);
        blogDao.save(blog);
        imageDao.save(image);
    }

    public HomeDto fetchHomePage(Long userId){
        return new HomeDto(userId, blogDao.findBlogByUserId(userId), imageDao.findImagesByUserId(userId));
    }

}
