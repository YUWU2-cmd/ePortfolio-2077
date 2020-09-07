package com.eportfolio2077.eportfolio.controller;


import com.eportfolio2077.eportfolio.common.ResponseMessage;
import com.eportfolio2077.eportfolio.dto.LoginDto;
import com.eportfolio2077.eportfolio.dto.RegisterDto;
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


    //Register logic, check for account validity
    //Stay in register page if register fails,otherwise redirect to login page
    @RequestMapping("/signup")
    public ResponseEntity<ResponseMessage> signup(@RequestBody RegisterDto registerDto) {
        userService.register(registerDto);
        //TODO handle register fail
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    //Login logic, check if the account exist and execute login
    @RequestMapping("/login")
    public ResponseEntity<ResponseMessage> login(@RequestBody LoginDto loginDto) {
        return userService.loginCheck(loginDto)
                ? ResponseEntity.status(HttpStatus.OK).body(null)
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseMessage.loginFail());
    }
}