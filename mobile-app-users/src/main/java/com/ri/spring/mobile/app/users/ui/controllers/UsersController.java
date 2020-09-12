/**
 * 
 */
package com.ri.spring.mobile.app.users.ui.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ri.spring.mobile.app.users.apis.dto.UserDto;
import com.ri.spring.mobile.app.users.apis.exceptions.UsersException;
import com.ri.spring.mobile.app.users.apis.service.UsersService;
import com.ri.spring.mobile.app.users.ui.model.CreateUserRequestModel;
import com.ri.spring.mobile.app.users.ui.model.CreateUserResponseModel;

/**
 * @author ripum
 *
 */
@RestController
@RequestMapping(path = "/users")
public class UsersController {

	@Autowired
	private Environment env;

	@Autowired
	private UsersService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/status/{api}")
	public String status(@PathVariable("api") String api) {
		return "working on - " + env.getProperty("local.server.port") + " ::" + api;
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetail) {
		UserDto userDto = modelMapper.map(userDetail, UserDto.class);
		UserDto created = userService.createUser(userDto);
		CreateUserResponseModel response = modelMapper.map(created, CreateUserResponseModel.class);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<CreateUserResponseModel> getUser(@PathVariable("userId") String userId)
			throws UsersException {
		UserDto userDto = userService.getUser(userId);
		CreateUserResponseModel response = modelMapper.map(userDto, CreateUserResponseModel.class);
		return new ResponseEntity<CreateUserResponseModel>(response, HttpStatus.OK);
	}
}
