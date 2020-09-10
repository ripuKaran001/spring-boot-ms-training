/**
 * 
 */
package com.ri.spring.mobile.app.users.ui.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ri.spring.mobile.app.users.ui.model.CreateUserRequestModel;

/**
 * @author ripum
 *
 */
@RestController
@RequestMapping(path = "/users")
public class UsersController {

	@Autowired
	private Environment env;

	@GetMapping("/status/{api}")
	public String status(@PathVariable("api") String api) {
		return "working on - " + env.getProperty("local.server.port") + " ::" + api;
	}

	@PostMapping
	public String createUser(@Valid @RequestBody CreateUserRequestModel userDetail) {
		return "Create User method is called" + userDetail.getEmail();
	}
}
