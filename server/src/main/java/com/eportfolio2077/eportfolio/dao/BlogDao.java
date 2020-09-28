package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.Blog;
import com.eportfolio2077.eportfolio.entity.Image;
import com.eportfolio2077.eportfolio.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao extends JpaRepository<Blog,Long> {
    List<Blog> findBlogBySite(Site site);
    void deleteAllBySite(Site site);
}
