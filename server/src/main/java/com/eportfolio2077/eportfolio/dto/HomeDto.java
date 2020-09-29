package com.eportfolio2077.eportfolio.dto;

import com.eportfolio2077.eportfolio.entity.Blog;
import com.eportfolio2077.eportfolio.entity.Image;
import lombok.Data;

import java.util.List;

@Data
public class HomeDto {
    private Long userId;
    private String userName;
    private String bio;
    private String aboutMe;
    private List<Image> imageList;
    private List<Blog> blogList;

    public HomeDto(Long userId, String userName, String bio, String aboutMe, List<Blog> blogList, List<Image> imageList) {
        this.userId = userId;
        this.userName=userName;
        this.bio=bio;
        this.aboutMe=aboutMe;
        this.blogList = blogList;
        this.imageList = imageList;
    }
}
