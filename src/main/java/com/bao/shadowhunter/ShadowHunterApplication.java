package com.bao.shadowhunter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShadowHunterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShadowHunterApplication.class, args);
    }

}
