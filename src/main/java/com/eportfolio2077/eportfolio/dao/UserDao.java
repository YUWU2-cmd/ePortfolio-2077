package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.User;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eportfolio2077.eportfolio.entity.User;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    @Query("select s from User s where s.email=?")
    public User findByEmail(String email);
}
