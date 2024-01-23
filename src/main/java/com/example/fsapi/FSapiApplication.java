package com.example.fsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FSapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FSapiApplication.class, args);
    }

}