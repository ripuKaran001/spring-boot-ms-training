/**
 * 
 */
package com.ri.spring.mobile.app.users.apis.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.userdetails.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ri.spring.mobile.app.users.apis.constant.UserServiceConstant;
import com.ri.spring.mobile.app.users.apis.dto.UserDto;
import com.ri.spring.mobile.app.users.apis.service.UsersService;
import com.ri.spring.mobile.app.users.ui.model.LoginRequestModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author ripum
 *
 */
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private Environment env;
	private UsersService usersService;

	public AuthenticationFilter(Environment env, UsersService usersService,
			AuthenticationManager authenticationManager) {
		this.env = env;
		this.usersService = usersService;
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			LoginRequestModel credentials = new ObjectMapper().readValue(request.getInputStream(),
					LoginRequestModel.class);
			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
					credentials.getEmail(), credentials.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getLocalizedMessage());
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String userName = ((User) authResult.getPrincipal()).getUsername();
		UserDto userDto = usersService.getUserByEmail(userName);
		String tokenString = Jwts.builder().setSubject(userDto.getUserId())
				.setExpiration(new Date(System.currentTimeMillis()
						+ Long.valueOf(env.getProperty(UserServiceConstant.TOKEN_EXPIRATION_TIME))))
				.signWith(SignatureAlgorithm.HS512, env.getProperty(UserServiceConstant.TOKEN_SECRET)).compact();
		response.addHeader(UserServiceConstant.TOKEN, tokenString);
		response.addHeader("userId", userDto.getUserId());
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.unsuccessfulAuthentication(request, response, failed);
	}

}
