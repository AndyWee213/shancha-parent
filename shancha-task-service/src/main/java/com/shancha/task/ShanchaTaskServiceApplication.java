package com.shancha.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableTask
public class ShanchaTaskServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShanchaTaskServiceApplication.class, args);
    }
}
