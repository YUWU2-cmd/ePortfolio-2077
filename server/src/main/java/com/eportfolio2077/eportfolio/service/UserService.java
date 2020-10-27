package com.eportfolio2077.eportfolio.service;

import com.eportfolio2077.eportfolio.dao.UserDao;
import com.eportfolio2077.eportfolio.dto.LoginDto;
import com.eportfolio2077.eportfolio.dto.RegisterDto;
import com.eportfolio2077.eportfolio.dto.UserDetailsDto;
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

    @Transactional
    public void updateVerifyCode(String email, String code){
        User user = userDao.getUserByEmail(email);
        user.setVerifyCode(code);
        userDao.save(user);
    }

    @Transactional
    public boolean checkVerifyCode(String email, String code)throws Exception{
        return code.equals(userDao.getUserByEmail(email).getVerifyCode());
    }

    @Transactional
    public void enableUser(String email){
        User user = userDao.getUserByEmail(email);
        user.setEnable(true);
        userDao.save(user);
    }

    @Transactional
    public void changePassword(String email, String password)throws Exception{
        User user = userDao.getUserByEmail(email);
        user.setPassword(password);
        userDao.save(user);
    }

    public User getUser(Long id){
        return userDao.getUserByUserId(id);
    }

    @Transactional
    public void changeProfile(Long userId, String profilePath){
        User user = userDao.getUserByUserId(userId);
        user.setProfilePicture(profilePath);
        userDao.save(user);
    }

    public void updateDetails(UserDetailsDto userDetailsDto){
        User user = userDao.getUserByUserId(userDetailsDto.getUserId());
        user.setFirstName(userDetailsDto.getFirstName());
        user.setLastName(userDetailsDto.getLastName());
        user.setPhoneNumber(userDetailsDto.getPhoneNumber());
        user.setLinkedinLink(userDetailsDto.getLinkedinLink());
        user.setFacebookLink(userDetailsDto.getFacebookLink());
        user.setTwitterLink(userDetailsDto.getTwitterLink());
        user.setInstagramLink(userDetailsDto.getInstagramLink());
        userDao.save(user);
    }

}
