package com.eportfolio2077.eportfolio.controller;


import com.eportfolio2077.eportfolio.common.ResponseBody;
import com.eportfolio2077.eportfolio.dto.LoginDto;
import com.eportfolio2077.eportfolio.dto.RegisterDto;
import com.eportfolio2077.eportfolio.entity.User;
import com.eportfolio2077.eportfolio.service.HomeService;
import com.eportfolio2077.eportfolio.service.MailService;
import com.eportfolio2077.eportfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HomeService homeService;
    @Autowired
    private MailService mailService;
  

    @RequestMapping("/verify")
    public ResponseEntity<ResponseBody> verify(@RequestParam("email") String email) {
        try {
            mailService.sendVerificationMail(email);
            //TODO
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseBody.wrongEmail());
        }
    }

    @RequestMapping("/signup")
    public ResponseEntity<ResponseBody> signup(@RequestBody RegisterDto registerDto) {
        try {
            User newUser = userService.register(registerDto);
            homeService.createHomePage(newUser.getUserId());
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ResponseBody.dupEmail());
        }

    }

    @RequestMapping("/login")
    public ResponseEntity<ResponseBody> login(@RequestBody LoginDto loginDto) {
        try {
            User user = userService.loginCheck(loginDto);
            //if login succeed, return home page directly
            return user!=null
                    ? ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(homeService.fetchHomePage(user)))
                    : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseBody.loginFail());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ResponseBody.serverError());
        }
    }


}