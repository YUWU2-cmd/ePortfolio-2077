package com.eportfolio2077.eportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EportfolioApplication {

    @RequestMapping("index")
    public String index(){
        return "hello";
    }


    public static void main(String[] args) {
        SpringApplication.run(EportfolioApplication.class, args);
    }

}
