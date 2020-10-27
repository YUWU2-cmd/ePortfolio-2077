package com.eportfolio2077.eportfolio.controller;



import com.eportfolio2077.eportfolio.common.ResponseBody;
import com.eportfolio2077.eportfolio.dto.LoginDto;
import com.eportfolio2077.eportfolio.dto.RegisterDto;
import com.eportfolio2077.eportfolio.dto.UserDetailsDto;
import com.eportfolio2077.eportfolio.dto.UserDto;
import com.eportfolio2077.eportfolio.entity.User;
import com.eportfolio2077.eportfolio.service.*;
import com.eportfolio2077.eportfolio.utils.CookieUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    MailService mailService;
    @Autowired
    CookieUtil cookieUtil;
    @Autowired
    AWSS3Service awss3Service;
    @Autowired
    DashBoardService dashBoardService;



    @RequestMapping("/verify")
    public ResponseEntity<ResponseBody> verify(@RequestParam("email") String email, @RequestParam("code") String code) {
        try{
            if (userService.checkVerifyCode(email, code)){
                userService.enableUser(email);
                return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
            }else{
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ResponseBody.verifyFail());
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ResponseBody.wrongEmail());
        }
    }


    @RequestMapping("/send")
    public ResponseEntity<ResponseBody> send(@RequestParam("email") String email) {
        try {
            String code = UUID.randomUUID().toString().substring(0, 6);
            userService.updateVerifyCode(email, code);
            mailService.sendVerificationMail(email, code);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ResponseBody.wrongEmail());
        }
    }

    @RequestMapping("/signup")
    public ResponseEntity<ResponseBody> signup(@RequestBody RegisterDto registerDto) {
        try {
            User newUser = userService.register(registerDto);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ResponseBody.dupEmail());
        }

    }

    @RequestMapping("/login")
    public ResponseEntity<ResponseBody> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        try {
            User user = userService.loginCheck(loginDto);
            //check if email is verified
            if (!user.isEnable()) {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ResponseBody.verifyRequired());
            }
            if(user!=null){
                //set cookies
                cookieUtil.setCookie(user.getUserId(),response);
                return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(new UserDto(user)));
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseBody.loginFail());
            }
        }catch (NullPointerException nullPointerException){

            User user = userService.loginCheck(loginDto);

            if(user!=null){
                //set cookies
                cookieUtil.setCookie(user.getUserId(),response);
                return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(new UserDto(user)));
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseBody.loginFail());
            }
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ResponseBody.serverError());
        }
    }

    @RequestMapping("/logout")
    public ResponseEntity<ResponseBody> logout(HttpServletResponse response) {
        cookieUtil.deleteCookie(response);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
    }

    @RequestMapping("/logged")
    public ResponseEntity<ResponseBody> logged(@CookieValue(value = "userId") Long userId){
        try{
            User user = userService.getUser(userId);
            if(user!=null){
                return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(new UserDto(user)));
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseBody.loginFail());
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseBody.loginFail());
        }
    }

    @RequestMapping("/change/password")
    public ResponseEntity<ResponseBody> changePassword(@RequestParam("email") String email, String password){
        try{
            userService.changePassword(email, password);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping("/change/profile")
    public ResponseEntity<ResponseBody> changeProfile(@RequestParam("file") MultipartFile image, @CookieValue(value = "userId") Long userId){
        String imagePath;
        try {
            imagePath = awss3Service.uploadFile(image);
            userService.changeProfile(userId, imagePath);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(imagePath));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }

    @RequestMapping("/update/details")
    public ResponseEntity<ResponseBody> updateDetails(@RequestBody UserDetailsDto userDetailsDto){
        try{
            userService.updateDetails(userDetailsDto);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }
}