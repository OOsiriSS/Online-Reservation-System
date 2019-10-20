package com.example.takeout;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.example.takeout.mapper")
@EnableScheduling
public class TakeoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeoutApplication.class, args);
    }

}