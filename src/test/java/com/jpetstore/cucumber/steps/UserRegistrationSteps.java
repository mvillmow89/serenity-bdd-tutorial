package com.jpetstore.cucumber.steps;

import static org.junit.Assert.assertEquals;

import com.github.javafaker.Faker;
import com.jpetstore.cucumber.steps.serenity.PetStoreSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class UserRegistrationSteps {
	
	@Steps
	PetStoreSteps shopper;

	@Given("I navigate to the registration page")
	public void I_Navigate_To_Registration_Page() {
		shopper.enterTheStore();
		shopper.navigateToLogInPage();
		shopper.navigateToRegistrationPage();
	}
	
	@And("I add new user information")
	public void I_Add_New_User_Information() {
		Faker faker = new Faker();
		String userName = "test" + faker.number().randomNumber(10, false);
		Serenity.setSessionVariable("userName").to(userName);
		String password = faker.internet().password();
		Serenity.setSessionVariable("password").to(password);
		
		String repeatPassword = password;
		shopper.addNewUserInformation(userName, password, repeatPassword);
	}
	
	@Given("I add account information")
	public void i_add_account_information() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		Serenity.setSessionVariable("firstName").to(firstName);
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String phone = faker.phoneNumber().cellPhone();
		String address1 = faker.address().streetAddress();
		String address2 = faker.address().buildingNumber();
		String city = faker.address().city();
		String state = faker.address().state();
		String zip = faker.address().zipCode();
		String country = faker.address().country();
		if(country.length() >=20) {
			country = country.substring(0,19);
		}
		shopper.addAccountInformation(firstName, lastName, email, phone, 
				address1, address2, city, state, zip, country);
	}

	@Given("I add profile information")
	public void i_add_profile_information() {
	    shopper.addProfileInformation("english", "CATS", true, true);
	}

	@Given("I save my information")
	public void i_save_my_information() {
	    shopper.clickSaveAccountInfo();
	}

	@When("I login with my credentials")
	public void i_login_with_my_credentials() {
	    shopper.navigateToLogInPage();
	    String userName = Serenity.sessionVariableCalled("userName");
	    String password = Serenity.sessionVariableCalled("password");
	    shopper.doLogin(userName, password);
	}

	@Then("I must be able to view the welcome greeting with my name")
	public void i_must_be_able_to_view_the_welcome_greeting_with_my_name() {
	    String greeting = shopper.getGreetingMessage();
		assertEquals("Welcome " + Serenity.sessionVariableCalled("firstName")
								+"!", greeting);
	}
}
