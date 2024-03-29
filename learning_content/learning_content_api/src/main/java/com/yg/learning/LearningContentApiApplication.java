package com.yg.learning;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class LearningContentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningContentApiApplication.class, args);
    }

}
