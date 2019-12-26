package com.example.loginsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LoginsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginsecurityApplication.class, args);
    }

}
