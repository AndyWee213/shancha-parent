package com.shancha.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@EnableConfigServer
@EnableEurekaClient
@Configuration
@EnableAutoConfiguration
public class ShanchaConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShanchaConfigServerApplication.class, args);
    }
}
