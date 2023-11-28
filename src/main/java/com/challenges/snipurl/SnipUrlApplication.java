package com.challenges.snipurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.challenges"})
public class SnipUrlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnipUrlApplication.class, args);
    }

}
