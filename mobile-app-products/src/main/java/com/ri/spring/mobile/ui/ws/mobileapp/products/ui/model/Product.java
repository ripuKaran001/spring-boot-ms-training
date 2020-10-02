package com.ri.spring.mobile.ui.ws.mobileapp.products.ui.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String productName;
	private String category;
	private double price;
	private LocalDate releasedOn;

	public Product() {
	}

	public Product(String productName, String category, double price, LocalDate releasedOn) {
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.releasedOn = releasedOn;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the releasedOn
	 */
	public LocalDate getReleasedOn() {
		return releasedOn;
	}

	/**
	 * @param releasedOn the releasedOn to set
	 */
	public void setReleasedOn(LocalDate releasedOn) {
		this.releasedOn = releasedOn;
	}

}
