package com.jpetstore.pages;

import org.openqa.selenium.By;

public class LoginPage extends PageBase {
	
	private static final String USER_NAME_INPUT = "//*[@id='Catalog']//input[@name='username']";
	private static final String PASSWORD_INPUT = "//*[@id='Catalog']//input[@name='password']";
	private static final String LOGIN_BUTTON = "//*[@id='Catalog']//input[contains(@value,'Login')]";
	private static final String REGISTER_NOW_LINK = "//*[@id='Catalog']//a[contains(text(),'Register Now!')]";
	private static final String INVALID_LOGIN_LABEL = "//*[@id='Content']/ul[@class='messages']/li";
	
	private static final String LOGIN_PAGE_TEXT = "Please enter your username and password.";
	private static final String REGISTER_USER_TEXT = "Need a user name and password?";
	
	/**
	 * Login to the Pet Store with a username and password
	 * @param username
	 * @param password
	 * @return
	 */
	public DashBoardPage doLogin(String username, String password) {
		waitForTextToAppear(LOGIN_PAGE_TEXT);
		waitForTextToAppear(REGISTER_USER_TEXT);
		
		waitFor(USER_NAME_INPUT).find(By.xpath(USER_NAME_INPUT)).type(username);
		waitFor(PASSWORD_INPUT).find(By.xpath(PASSWORD_INPUT)).type(password);
		
		waitFor(LOGIN_BUTTON).find(By.xpath(LOGIN_BUTTON)).click();
		
		return this.switchToPage(DashBoardPage.class);
	}
	
	/**
	 * Navigate to the registration page
	 * @return
	 */
	public AccountPage navigateToRegistrationPage() {
		waitForTextToAppear(LOGIN_PAGE_TEXT);
		waitForTextToAppear(REGISTER_USER_TEXT);
		
		waitFor(REGISTER_NOW_LINK).$(REGISTER_NOW_LINK).click();
		
		return this.switchToPage(AccountPage.class);
	}
	
	/**
	 * Return Error message when logging in with an unregistered user
	 * @return
	 */
	public String getMessageOnInvalidLogin() {
		return waitFor(INVALID_LOGIN_LABEL).$(INVALID_LOGIN_LABEL).getText();
	}

}
