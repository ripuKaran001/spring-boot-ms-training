package com.ri.spring.mobile.app.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication

public class MobileAppUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppUsersApplication.class, args);
	}

}
