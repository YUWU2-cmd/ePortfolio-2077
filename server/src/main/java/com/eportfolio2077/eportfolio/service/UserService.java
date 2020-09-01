package com.eportfolio2077.eportfolio.service;

import com.eportfolio2077.eportfolio.common.Response;
import com.eportfolio2077.eportfolio.dao.UserDao;
import com.eportfolio2077.eportfolio.dto.LoginDto;
import com.eportfolio2077.eportfolio.dto.RegisterDto;
import com.eportfolio2077.eportfolio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    //@Autowired
    UserDao userDao;

    public Response loginCheck(LoginDto loginDto) {
        //TODO success response object
        return userDao.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword()) == null ?
                Response.success("data") : Response.error("incorrect username or password");
    }

    @Transactional
    public Response register(RegisterDto registerDto){
        User newUser = new User(registerDto.getEmail(), registerDto.getRole(), registerDto.getUsername(), registerDto.getPassword());
        userDao.save(newUser);
        //TODO success response object
        return Response.success("data");
    }
}
