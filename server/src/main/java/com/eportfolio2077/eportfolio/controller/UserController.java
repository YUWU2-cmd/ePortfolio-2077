package com.eportfolio2077.eportfolio.controller;


import com.eportfolio2077.eportfolio.common.ResponseBody;
import com.eportfolio2077.eportfolio.dto.LoginDto;
import com.eportfolio2077.eportfolio.dto.RegisterDto;
import com.eportfolio2077.eportfolio.entity.User;
import com.eportfolio2077.eportfolio.service.HomeService;
import com.eportfolio2077.eportfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HomeService homeService;


    //Register logic, check for account validity
    //Stay in register page if register fails,otherwise redirect to login page
    @RequestMapping("/signup")
    public ResponseEntity<ResponseBody> signup(@RequestBody RegisterDto registerDto) {
        try {
            userService.register(registerDto);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ResponseBody.dupEmail());
        }

    }

    //Login logic, check if the account exist and execute login
    @RequestMapping("/login")
    public ResponseEntity<ResponseBody> login(@RequestBody LoginDto loginDto) {
        try {
            User user = userService.loginCheck(loginDto);
            //if login succeed, return home page directly
            return user!=null
                    ? ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(homeService.fetchHomePage(user.getUserId())))
                    : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseBody.loginFail());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ResponseBody.serverError());
        }
    }
}