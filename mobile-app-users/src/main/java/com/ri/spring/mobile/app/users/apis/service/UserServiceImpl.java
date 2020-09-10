/**
 * 
 */
package com.ri.spring.mobile.app.users.apis.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ri.spring.mobile.app.users.apis.data.UserEntity;
import com.ri.spring.mobile.app.users.apis.dto.UserDto;
import com.ri.spring.mobile.app.users.apis.repositories.UsersRepository;

/**
 * @author ripum
 *
 */

public class UserServiceImpl implements UsersService {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto userDetails) {
		String userId = UUID.randomUUID().toString();
		userDetails.setUserId(userId.substring(0, userId.indexOf("-")));
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		return modelMapper.map(usersRepository.save(userEntity), UserDto.class);
	}

}
