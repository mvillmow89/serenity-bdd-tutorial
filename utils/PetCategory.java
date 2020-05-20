package com.jpetstore.utils;

public enum PetCategory {
	FISH("Fish"),
	CATS("Cats"),
	DOGS("Dogs"),
	REPTILES("Reptiles"),
	BIRDS("Birds"),
	BIRDS_CENTER("Birds");
	
	private String petType;

	private PetCategory(String petType) {
		this.petType = petType;
	}
	
	public String getPetTypeString() {
		return petType;
	}
}
