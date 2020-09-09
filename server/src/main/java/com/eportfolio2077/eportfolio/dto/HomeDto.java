package com.eportfolio2077.eportfolio.dto;

import com.eportfolio2077.eportfolio.entity.Blog;
import com.eportfolio2077.eportfolio.entity.Image;
import lombok.Data;

import java.util.List;

@Data
public class HomeDto {
    private List<Image> imageList;
    private List<Blog> blogList;

    public HomeDto(List<Blog> blogList, List<Image> imageList) {
        this.blogList = blogList;
        this.imageList = imageList;
    }
}
