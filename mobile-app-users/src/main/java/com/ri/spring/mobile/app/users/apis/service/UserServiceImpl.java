/**
 * 
 */
package com.ri.spring.mobile.app.users.apis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.ri.spring.mobile.app.users.apis.data.UserEntity;
import com.ri.spring.mobile.app.users.apis.dto.UserDto;
import com.ri.spring.mobile.app.users.apis.exceptions.UsersException;
import com.ri.spring.mobile.app.users.apis.repositories.UsersRepository;
import com.ri.spring.mobile.app.users.ui.model.ProductResponseModel;

/**
 * @author ripum
 *
 */

public class UserServiceImpl implements UsersService {
	
	@Autowired
	private Environment env;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	@Override
	public UserDto createUser(UserDto userDetails) {
		String userId = UUID.randomUUID().toString();
		userDetails.setUserId(userId.substring(0, userId.indexOf("-")));
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		return modelMapper.map(usersRepository.save(userEntity), UserDto.class);
	}

	@Override
	public UserDto getUser(String userId) throws UsersException {
		UserDto result = null;
		if (StringUtils.isNotBlank(userId)) {
			UserEntity userEntity = usersRepository.findByUserId(userId);
			if (userEntity != null) {
				result = modelMapper.map(userEntity, UserDto.class);
				ResponseEntity<List<ProductResponseModel>> responseEntity = restTemplate.exchange(env.getProperty("products.service.url"), HttpMethod.GET,
						null, new ParameterizedTypeReference<List<ProductResponseModel>>() {
						});
				result.setProducts(responseEntity.getBody());
			} else {
				throw new UsersException("Users Details not found for : " + userId);
			}
			return result;
		} else {
			throw new UsersException("Invalid User Id !! Please provide Valid UserID");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = usersRepository.findByEmail(username);
		if (userEntity == null)
			throw new UsersException("User Name not found");
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true,
				new ArrayList<>());
	}

	@Override
	public UserDto getUserByEmail(String email) throws UsersException {
		UserEntity userEntity = usersRepository.findByEmail(email);
		if (userEntity == null)
			throw new UsersException("User not found");
		UserDto resultedUser = modelMapper.map(userEntity, UserDto.class);
		return resultedUser;
	}

}
