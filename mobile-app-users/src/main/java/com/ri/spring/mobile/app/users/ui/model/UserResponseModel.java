/**
 * 
 */
package com.ri.spring.mobile.app.users.ui.model;

import java.util.List;

/**
 * @author ripum
 *
 */
public class UserResponseModel {

	private String email;
	private String firstName;
	private String lastName;
	private String userId;
	private List<ProductResponseModel> products;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the products
	 */
	public List<ProductResponseModel> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<ProductResponseModel> products) {
		this.products = products;
	}

	
}
