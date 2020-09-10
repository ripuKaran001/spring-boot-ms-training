/**
 * 
 */
package com.ri.spring.mobile.apis.users.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ri.spring.mobile.apis.users.dto.UserDto;
import com.ri.spring.mobile.apis.users.service.UsersService;

/**
 * @author ripum
 *
 */
@Service
public class UserServiceImpl implements UsersService {

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		return null;
	}

}
