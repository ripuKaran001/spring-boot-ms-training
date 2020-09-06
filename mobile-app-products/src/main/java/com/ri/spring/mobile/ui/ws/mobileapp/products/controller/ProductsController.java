/**
 * 
 */
package com.ri.spring.mobile.ui.ws.mobileapp.products.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ripum
 *
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

	@GetMapping(path = "/status")
	public String status() {
		return "Working";
	}

}
