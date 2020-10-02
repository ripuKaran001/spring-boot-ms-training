/**
 * 
 */
package com.ri.spring.mobile.ui.ws.mobileapp.products.service;

import java.util.List;

import com.ri.spring.mobile.ui.ws.mobileapp.products.ui.model.Product;

/**
 * @author ripum
 *
 */
public interface ProductService {

	public List<Product> getProducts();

	public Product getProductByName(String name);
}
