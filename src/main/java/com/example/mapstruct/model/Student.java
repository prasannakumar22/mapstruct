package com.example.mapstruct.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("source")
	private String source;
	
	
	@JsonProperty("products")
	private List<Product> products;

	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
