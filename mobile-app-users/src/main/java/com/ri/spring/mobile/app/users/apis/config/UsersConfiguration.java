package com.ri.spring.mobile.app.users.apis.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.ri.spring.mobile.app.users.apis.exceptions.FeignErrorDecoder;
import com.ri.spring.mobile.app.users.apis.service.UserServiceImpl;
import com.ri.spring.mobile.app.users.apis.service.UsersService;

import feign.Logger;

/**
 * 
 * @author ripum
 *
 */
@Configuration
public class UsersConfiguration {

	@Bean
	public UsersService usersService() {
		return new UserServiceImpl();
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Logger.Level getFeignLogger() {
		return Logger.Level.FULL;
	}

	@Bean
	public FeignErrorDecoder getErrorDecoder() {
		return new FeignErrorDecoder();
	}

}
