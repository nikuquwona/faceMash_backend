package com.example.takeout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Slf4j //日志
@SpringBootApplication
public class TakeoutApplication {

    public static void main(String[] args) {

        SpringApplication.run(TakeoutApplication.class, args);

//        log.info("项目启动成功");
    }

}
