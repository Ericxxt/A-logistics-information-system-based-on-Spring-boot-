package com.ericxxt.logistics_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.ericxxt.logistics_system.dao")
public class LogisticsSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticsSystemApplication.class, args);
    }

}
