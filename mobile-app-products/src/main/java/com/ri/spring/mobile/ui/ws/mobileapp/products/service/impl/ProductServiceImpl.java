package com.ri.spring.mobile.ui.ws.mobileapp.products.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ri.spring.mobile.ui.ws.mobileapp.products.service.ProductService;
import com.ri.spring.mobile.ui.ws.mobileapp.products.ui.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private static List<Product> products = new ArrayList<>();

	static {
		products.add(new Product("Mobile", "Electronics", 10000, LocalDate.now()));
		products.add(new Product("Laptop", "Electronics", 30000, LocalDate.now()));
		products.add(new Product("Television", "Electronics", 11000, LocalDate.now()));
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
