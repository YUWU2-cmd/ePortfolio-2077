package com.eportfolio2077.eportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EportfolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(EportfolioApplication.class, args);
    }

}
