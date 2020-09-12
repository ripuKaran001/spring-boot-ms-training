package com.ri.spring.mobile.app.users.apis.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ri.spring.mobile.app.users.apis.dto.UserDto;
import com.ri.spring.mobile.app.users.apis.exceptions.UsersException;

public interface UsersService extends UserDetailsService {

	UserDto createUser(UserDto userDetails);

	UserDto getUser(String userId) throws UsersException;

	UserDto getUserByEmail(String userId) throws UsersException;
}
