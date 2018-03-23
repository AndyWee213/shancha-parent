package com.shancha.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShanchaAdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShanchaAdminServiceApplication.class, args);
	}
}
