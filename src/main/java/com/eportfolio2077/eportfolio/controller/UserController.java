package com.eportfolio2077.eportfolio.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eportfolio2077.eportfolio.entity.User;
import com.eportfolio2077.eportfolio.dao.UserDao;

@Controller
@RequestMapping("/front/*")
public class UserController {

    @Autowired
    private UserDao userdao;
    private User user = new User();


    //To home page
    @RequestMapping("/index")
    public String index(HttpSession httpSession) {
        httpSession.getAttribute("userLogin");
        return "/html/index.html";
    }

    //To register page
    @RequestMapping("/register")
    public String register() {
        return "/html/register.html";
    }

    //To homepage if already login
    //Otherwise to login page
    @RequestMapping("/login")
    public String login() {
        String str="";
        String username=user.getUsername();
        if(username!=null) {
            str="/html/index.html";
        }else {
            str="/html/login.html";
        }
        return str;
    }

    //Register logic, check for account validity
    //Stay in register page if register fails,otherwise redirect to login page
    @RequestMapping("/uregister")
    public String register(HttpServletRequest request) {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String str="";
        if(password.equals(password2)) {
            user = userdao.findByEmail(email);
            if(user == null) {
                User user=new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setRole("student");
                userdao.save(user);
                str="/html/login.html";
            }else {
                str="/html/register.html";
            }
        }else {
            str="/html/register.html";
        }
        return str;
    }

    //Login logic, check if the account exist and execute login
    @RequestMapping("/ulogin")
    public String login(HttpServletRequest request,HttpSession session) {
        String email=request.getParameter("email");
        user=userdao.findByEmail(email);
        String str="";
        if(user!=null) {
            session.setAttribute("userLogin", user);
            str="/html/index.html";
        }else {
            str="/html/login.html";
        }
        return str;
    }
}
