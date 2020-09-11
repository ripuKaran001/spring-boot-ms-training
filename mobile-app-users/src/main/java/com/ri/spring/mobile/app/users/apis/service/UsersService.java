package com.ri.spring.mobile.app.users.apis.service;

import com.ri.spring.mobile.app.users.apis.dto.UserDto;
import com.ri.spring.mobile.app.users.apis.exceptions.UsersException;

public interface UsersService {

	UserDto createUser(UserDto userDetails);

	UserDto getUser(String userId) throws UsersException;
}
