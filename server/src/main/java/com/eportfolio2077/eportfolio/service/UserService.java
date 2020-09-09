package com.eportfolio2077.eportfolio.service;

import com.eportfolio2077.eportfolio.dao.UserDao;
import com.eportfolio2077.eportfolio.dto.LoginDto;
import com.eportfolio2077.eportfolio.dto.RegisterDto;
import com.eportfolio2077.eportfolio.dto.UserDto;
import com.eportfolio2077.eportfolio.entity.User;
import com.eportfolio2077.eportfolio.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class UserService {

    @Autowired
    UserDao userDao;


    public User loginCheck(LoginDto loginDto) {
        User user = userDao.findUserByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        return user;
    }

    @Transactional
    public void register(RegisterDto registerDto) {
        User newUser = new User(registerDto.getEmail(), registerDto.getUsername(), registerDto.getPassword());
        userDao.save(newUser);
    }

    public void editBio(UserDto userDto) {
        UserDto.getUser().setBio(userDto.getChange());
    }

    public void editAboutMe(UserDto userDto) throws IOException {
        UserDto.getUser().setAboutMe(userDto.getChange());
    }

    public void uploadProfilePicture(UserDto userDto) throws IOException {
        UserDto.getUser().setProfilePicture(userDto.getChange());
    }


}
