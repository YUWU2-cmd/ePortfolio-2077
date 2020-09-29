package com.eportfolio2077.eportfolio.dto;

import com.eportfolio2077.eportfolio.entity.Blog;
import com.eportfolio2077.eportfolio.entity.Image;
import lombok.Data;

import java.util.List;

@Data
public class SiteDto {
    private List<Image> images;
    private List<Blog> blogs;

    public SiteDto(List<Image> images, List<Blog> blogs) {
        this.images = images;
        this.blogs = blogs;
    }
}
