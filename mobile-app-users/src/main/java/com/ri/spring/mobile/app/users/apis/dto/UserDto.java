package com.ri.spring.mobile.app.users.apis.dto;

import java.io.Serializable;
import java.util.List;

import com.ri.spring.mobile.app.users.ui.model.ProductResponseModel;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2454976490258461837L;

	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String userId;
	private String encryptedPassword;

	private List<ProductResponseModel> products;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
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
