package com.try_their.try_their_project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.try_their.try_their_project.dao")
@SpringBootApplication
public class TryTheirProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TryTheirProjectApplication.class, args);
    }

}
