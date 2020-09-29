package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao extends JpaRepository<Blog,Long> {
    List<Blog> findBlogByUserId(Long userId);
}
