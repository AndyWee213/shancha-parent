package com.shancha.eureka.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by weiq on 2018/02/28.
 *
 * @author weiq
 */
@EnableEurekaServer
@SpringBootApplication
public class ShanchaEurekaServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ShanchaEurekaServerApplication.class).web(true).run(args);
    }
}
