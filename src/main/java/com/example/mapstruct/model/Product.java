package com.example.mapstruct.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

	@JsonProperty("gtin14")
	private String gtin14;
	
	@JsonProperty("familyTree")
	private FamilyTree familyTree;
	
	@JsonProperty("legacyData")
	private LegacyData legacyData;

	public String getGtin14() {
		return gtin14;
	}

	public void setGtin14(String gtin14) {
		this.gtin14 = gtin14;
	}

	public FamilyTree getFamilyTree() {
		return familyTree;
	}

	public void setFamilyTree(FamilyTree familyTree) {
		this.familyTree = familyTree;
	}

	public LegacyData getLegacyData() {
		return legacyData;
	}

	public void setLegacyData(LegacyData legacyData) {
		this.legacyData = legacyData;
	}
	
	
	
}
