package com.ri.spring.mobile.app.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MobileConfigServerApp {
	public static void main(String[] args) {
		SpringApplication.run(MobileConfigServerApp.class, args);
	}
}
