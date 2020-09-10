package com.ri.spring.mobile.app.users.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ri.spring.mobile.app.users.apis.service.UserServiceImpl;
import com.ri.spring.mobile.app.users.apis.service.UsersService;

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
}
