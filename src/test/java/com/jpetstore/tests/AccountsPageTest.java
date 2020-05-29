package com.jpetstore.tests;

import static org.junit.Assert.assertEquals;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.jpetstore.steps.PetStoreSteps;
import static com.jpetstore.utils.PetCategory.*;
import static com.jpetstore.utils.LanguageType.*;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class AccountsPageTest extends BaseTest {
	
	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	
	@Test
	@Title("Add a new user to the store & verify if the new user can login")
	public void addNewUserToStoreAndVerify() {
		Faker faker = new Faker();
		String userName = "test" + faker.number().randomNumber(100, false);
		String password = faker.internet().password();
		String repeatedPassword = password;
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String phoneNumber = faker.phoneNumber().cellPhone();
		String addr1 = faker.address().streetAddress();
		String addr2 = faker.address().buildingNumber();
		String city = faker.address().city();
		String state = faker.address().stateAbbr();
		String zip = faker.address().zipCode();
		String country = faker.address().country();
		if(country.length() >=20) {
			country = country.substring(0,19);
		}
		shopper.enterTheStore();
		shopper.navigateToLogInPage();
		shopper.navigateToRegistrationPage();
		shopper.addNewUserInformation(userName, password, repeatedPassword);
		shopper.addAccountInformation(firstName, lastName, email, phoneNumber, addr1, addr2, city, state, zip, country);
		shopper.addProfileInformation(ENGLISH.getLanguageTypeString(), DOGS.toString(), true, true);
		shopper.clickSaveAccountInfo();
		shopper.clickOnSignInLink();
		shopper.doLogin(userName, password);
		String greetingMsg = shopper.getGreetingMessage();
		assertEquals("Welcome " + firstName + "!", greetingMsg);
	}

}
