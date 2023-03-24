package com.example.mapstruct.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FamilyTree {

	@JsonProperty("name")
	private String name;

	@Override
	public String toString() {
		return "FamilyTree [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
