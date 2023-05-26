package com.diplom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@AutoConfiguration
@Configuration
@EnableScheduling
public class DiplomApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiplomApiApplication.class, args);
    }

}
