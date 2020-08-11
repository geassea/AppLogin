package com.learn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.learn.demo.mapper")
public class AppLoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppLoginApplication.class,args);
    }
}
