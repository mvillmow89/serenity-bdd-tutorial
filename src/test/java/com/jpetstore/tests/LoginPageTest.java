package com.jpetstore.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.jpetstore.steps.PetStoreSteps;

import static com.jpetstore.common.CommonTestData.*;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class LoginPageTest extends BaseTest {
	
	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	
	@Test
	@Title("Verify if a user can login successfully to the store with valid credentials.")
	public void verifyIfLoginIsSuccessful() {
		shopper.enterTheStore();
		shopper.navigateToLogInPage();
		shopper.doLogin(USERNAME, PASSWORD);
		String greetingMsg = shopper.getGreetingMessage();
		assertEquals("Welcome "+ NAME + "!", greetingMsg);
	}
	
	@Test
	@Title("Verify if the signed-in user can logout successfully from the store.")
	public void verifyIfUserCanLogOutIsSuccessful() {
		shopper.enterTheStore();
		shopper.navigateToLogInPage();
		shopper.doLogin(USERNAME, PASSWORD);
		shopper.signOut();
	}
	
	@Test
	@Title("Verify if message <b><i> 'Invalid username or password. Signon failed.' </i></b> is displayed for "
			+ "invalid credentials.")
	public void verifyIfMessageIsDisplayedForInvalidLogin() {
		shopper.enterTheStore();
		shopper.navigateToLogInPage();
		shopper.doLogin("tester", "tester");
		String invalidMsg = shopper.getMessageOnInvalidLogin();
		assertEquals("Invalid username or password. Signon failed.", invalidMsg);
	}

}
