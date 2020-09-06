/**
 * 
 */
package com.ri.spring.mobile.ui.ws.mobileapp.accountservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ripum
 *
 */
@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

	@GetMapping("/status")
	public String status() {
		return "Working";
	}
}
