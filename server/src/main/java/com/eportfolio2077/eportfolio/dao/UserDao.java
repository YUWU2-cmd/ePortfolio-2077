package com.eportfolio2077.eportfolio.dao;

import com.eportfolio2077.eportfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findUserByEmailAndPassword(String email, String password);
    User getUserByEmail(String email);
}
