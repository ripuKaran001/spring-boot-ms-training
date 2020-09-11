/**
 * 
 */
package com.ri.spring.mobile.app.users.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ripum
 *
 */
@Configuration
@EnableWebSecurity
public class UsersWebSecurity extends WebSecurityConfigurerAdapter {

	/*
	 * @Autowired private Environment environment;
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/users/**")
				.permitAll();/* .hasIpAddress(environment.getProperty("gateway-api-ip")); */
	}

}