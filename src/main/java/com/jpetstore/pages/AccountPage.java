package com.jpetstore.pages;

import net.thucydides.core.webelements.Checkbox;

public class AccountPage extends PageBase {
	
	private static final String USER_NAME_INPUT = "//input[@name='username']";
	private static final String PASSWORD_INPUT = "//input[@name='password']";
	private static final String REPEAT_PASSWORD_INPUT = "//input[@name='repeatedPassword']";
	private static final String FIRST_NAME_INPUT = "//input[@name='account.firstName']";
	private static final String LAST_NAME_INPUT = "//input[@name='account.lastName']";
	private static final String EMAIL_INPUT = "//input[@name='account.email']";
	private static final String PHONE_INPUT = "//input[@name='account.phone']";
	private static final String ADDRESS1_INPUT = "//input[@name='account.address1']";
	private static final String ADDRESS2_INPUT = "//input[@name='account.address2']";
	private static final String CITY_INPUT = "//input[@name='account.city']";
	private static final String STATE_INPUT = "//input[@name='account.state']";
	private static final String ZIP_INPUT = "//input[@name='account.zip']";
	private static final String COUNTRY_INPUT = "//input[@name='account.country']";
	private static final String LANGUAGE_PREFERENCE_DROPDOWN = "//select[@name='account.languagePreference']";
	private static final String FAVORITE_CATEGORY_DROPDOWN = "//select[@name='account.favouriteCategoryId']";
	private static final String ENABLE_MYLIST_CHECKBOX = "//input[@name='account.listOption']";
	private static final String ENABLE_MYBANNER_CHECKBOX = "//input[@name='account.bannerOption']";
	private static final String SAVE_ACCOUNT_INFO_BUTTON = "//input[@name='newAccount']";
	
	private static final String USER_INFO_TEXT = "User Information";
	private static final String ACOUNT_INFO_TEXT = "Account Information";
	private static final String PROFILE_INTO_TEXT = "Profile Information";
	
	/**
	 * Add New User Information
	 * @param username
	 * @param password
	 * @param repeatedPassword
	 * @return
	 */
	public AccountPage addNewUserInformation(String username, String password, String repeatedPassword) {
		waitForTextToAppear(USER_INFO_TEXT);
		$(USER_NAME_INPUT).type(username);
		$(PASSWORD_INPUT).type(password);
		$(REPEAT_PASSWORD_INPUT).type(repeatedPassword);
		
		return this;
	}
	
	/**
	 * Add User Account Information
	 * @param username
	 * @param password
	 * @param repeatedPassword
	 * @return
	 */
	public AccountPage addAccountInformation(String firstName, String lastName, 
											 String email, String phone, 
											 String address1, String address2,
											 String city, String state, 
											 String zip, String country) {
		waitForTextToAppear(ACOUNT_INFO_TEXT);
		$(FIRST_NAME_INPUT).type(firstName);
		$(LAST_NAME_INPUT).type(lastName);
		$(EMAIL_INPUT).type(email);
		$(PHONE_INPUT).type(phone);
		$(ADDRESS1_INPUT).type(address1);
		$(ADDRESS2_INPUT).type(address2);
		$(CITY_INPUT).type(city);
		$(STATE_INPUT).type(state);
		$(ZIP_INPUT).type(zip);
		$(COUNTRY_INPUT).type(country);
		
		return this;
	}
	
	/**
	 * Add User Profile Information
	 * @param username
	 * @param password
	 * @param repeatedPassword
	 * @return
	 */
	public AccountPage addProfileInformation(String language, String category, 
											 boolean myList, boolean myBanner) {
		waitForTextToAppear(PROFILE_INTO_TEXT);
		$(LANGUAGE_PREFERENCE_DROPDOWN).selectByVisibleText(language);
		$(FAVORITE_CATEGORY_DROPDOWN).selectByVisibleText(category);
		new Checkbox($(ENABLE_MYLIST_CHECKBOX)).setChecked(myList);
		new Checkbox($(ENABLE_MYBANNER_CHECKBOX)).setChecked(myBanner);
		
		return this;
	}
	
	/**
	 * Click Save Account Information
	 * @return
	 */
	public DashBoardPage clickSaveAccountInfo() {
		waitFor(SAVE_ACCOUNT_INFO_BUTTON).$(SAVE_ACCOUNT_INFO_BUTTON).click();
		
		return this.switchToPage(DashBoardPage.class);
	}
	
}

