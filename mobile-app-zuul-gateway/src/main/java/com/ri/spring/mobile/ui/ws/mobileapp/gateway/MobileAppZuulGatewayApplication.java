package com.ri.spring.mobile.ui.ws.mobileapp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class MobileAppZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppZuulGatewayApplication.class, args);
	}

}
