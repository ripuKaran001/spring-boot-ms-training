package com.ri.spring.mobile.ui.ws.mobileapp.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MobileAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAccountServiceApplication.class, args);
	}

}
