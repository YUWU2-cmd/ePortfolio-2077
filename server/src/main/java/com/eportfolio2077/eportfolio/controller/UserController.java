package com.eportfolio2077.eportfolio.controller;

import com.eportfolio2077.eportfolio.common.Response;
import com.eportfolio2077.eportfolio.dto.LoginDto;
import com.eportfolio2077.eportfolio.dto.RegisterDto;
import com.eportfolio2077.eportfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    //Register logic, check for account validity
    //Stay in register page if register fails,otherwise redirect to login page
    @RequestMapping("/signup")
    public Response signup(RegisterDto registerDto) {
        System.out.println("fsfs");
        return userService.register(registerDto);
    }

    //Login logic, check if the account exist and execute login
    @RequestMapping("/login")
    public Response login(@Validated @RequestBody LoginDto loginDto) {
        System.out.println("fmosonfiue");
        return userService.loginCheck(loginDto);
    }
}