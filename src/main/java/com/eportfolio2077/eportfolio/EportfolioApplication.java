package com.eportfolio2077.eportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class EportfolioApplication {

    @RequestMapping("login")
    public String login(){
        return "/html/login.html";
    }


    public static void main(String[] args) {
        SpringApplication.run(EportfolioApplication.class, args);
    }

}
