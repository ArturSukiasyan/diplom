package com.jobick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class JobickApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobickApiApplication.class, args);
    }

}
