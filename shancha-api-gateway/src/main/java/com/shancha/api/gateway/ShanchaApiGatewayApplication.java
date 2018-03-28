package com.shancha.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ShanchaApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShanchaApiGatewayApplication.class, args);
	}
}
