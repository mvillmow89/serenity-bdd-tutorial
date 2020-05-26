package com.jpetstore.utils;

public enum LanguageType {
	ENGLISH("english"),
	JAPANESE("japanese");
	
	private String languageType;

	private LanguageType(String languageType) {
		this.languageType = languageType;
	}
	
	public String getLanguageTypeString() {
		return languageType;
	}

}
