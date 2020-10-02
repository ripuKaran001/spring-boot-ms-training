/**
 * 
 */
package com.ri.spring.mobile.ui.ws.mobileapp.products.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ri.spring.mobile.ui.ws.mobileapp.products.service.ProductService;
import com.ri.spring.mobile.ui.ws.mobileapp.products.ui.model.Product;

/**
 * @author ripum
 *
 */
@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductService productService;

	@GetMapping(path = "/status")
	public String status() {
		return "Working";
	}
	
	@GetMapping
	public List<Product> getProducts(){
		return productService.getProducts();
	}

}
