package com.eportfolio2077.eportfolio.service;

import com.eportfolio2077.eportfolio.dao.UserDao;
import com.eportfolio2077.eportfolio.dto.LoginDto;
import com.eportfolio2077.eportfolio.dto.RegisterDto;
import com.eportfolio2077.eportfolio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;


    public User loginCheck(LoginDto loginDto) {
        User user = userDao.findUserByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        return user;
    }

    @Transactional
    public User register(RegisterDto registerDto) {
        User newUser = new User(registerDto.getEmail(), registerDto.getUsername(), registerDto.getPassword());
        userDao.save(newUser);
        return newUser;
    }

}
