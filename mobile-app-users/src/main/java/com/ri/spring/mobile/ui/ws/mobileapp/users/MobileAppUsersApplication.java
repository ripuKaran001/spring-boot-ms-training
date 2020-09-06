package com.ri.spring.mobile.ui.ws.mobileapp.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MobileAppUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppUsersApplication.class, args);
	}

}
