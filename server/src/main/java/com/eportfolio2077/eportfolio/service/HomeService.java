package com.eportfolio2077.eportfolio.service;


import com.eportfolio2077.eportfolio.dao.BlogDao;
import com.eportfolio2077.eportfolio.dao.ImageDao;
import com.eportfolio2077.eportfolio.dao.UserDao;
import com.eportfolio2077.eportfolio.dto.HomeDto;
import com.eportfolio2077.eportfolio.entity.Blog;
import com.eportfolio2077.eportfolio.entity.Image;
import com.eportfolio2077.eportfolio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    BlogDao blogDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    UserDao userDao;

    public void createHomePage(Long userId) {
        Blog blog = new Blog(userId);
        Image image = new Image(userId);
        blogDao.save(blog);
        imageDao.save(image);
    }

    public HomeDto fetchHomePage(User user) {
        Long userId = user.getUserId();
        return new HomeDto(userId, user.getUsername(), user.getBio(), user.getAboutMe(), blogDao.findBlogByUserId(userId), imageDao.findImagesByUserId(userId));
    }

//    public String updateBlog(String blog){
//        blogDao.save()
//    }


}
