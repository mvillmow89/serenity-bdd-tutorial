package com.jpetstore.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.jpetstore.steps.PetStoreSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class OrderProductTest {
	
	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	
	@Test
	@Title("Order a pet bulldog from the petstore")
	public void orderPetBullDogFromPetStoreTest() {
		String productType = "Bulldog";
		String productDescription = "Female Puppy Bulldog";
		String productCharacteristic = "Friendly dog from England";
		shopper.enterTheStore();
		shopper.navigateToLogInPage();
		shopper.doLogin("test", "test");
		shopper.searchForProduct(productType);
		shopper.selectProductFromSearchResultsTable(productType);
		shopper.addToCartByViewingItemDetails(productType, productDescription, productCharacteristic);
		shopper.proceedToCheckout();
		

		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String address1 = faker.address().streetAddress();
		String address2 = faker.address().buildingNumber();
		String city = faker.address().city();
		String state = faker.address().stateAbbr();
		String zip = faker.address().zipCode();
		String country = faker.address().country();
		if(country.length() >=20) {
			country = country.substring(0,19);
		}
		String cardType = "Visa";
		String cardNumber = faker.finance().creditCard(CreditCardType.VISA);
		String expiryDate = "12/2026";
		
		shopper.enterPaymentAndBillingDetails(cardType, cardNumber, expiryDate, firstName, lastName, address1, address2, city, state, zip, country);
		
		shopper.clickShipToDifferentAddress();
		shopper.clickOnContinueButton();
		
		String altAddress1 = faker.address().streetAddress();
		String altAddress2 = faker.address().buildingNumber();
		
		shopper.enterAlternateShippingInfo(firstName, lastName, altAddress1, altAddress2, city, state, zip, country);
		
		shopper.clickOnContinueButton();
		shopper.clickOnConfirmButton();
		shopper.verifyIfOrderSubmitted();
	}

}
