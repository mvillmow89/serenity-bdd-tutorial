package com.jpetstore.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.jpetstore.steps.PetStoreSteps;
import com.jpetstore.utils.PetCategory;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata\\orders.csv")
public class OrderProductDataDrivenTest {

	private String userName;
	private String password;
	private String productCategory;
	private String productName;
	private String specificProductName;
	private String cardType;
	private String cardNumber;
	private String expiryDate;
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setSpecificProductName(String specificProductName) {
		this.specificProductName = specificProductName;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	
	@Test
	@Title("Order pets & verify purchase")
	public void orderPetBullDogFromPetStoreTest() {
		
		shopper.enterTheStore();
		shopper.navigateToLogInPage();
		shopper.doLogin(userName, password);
		
		PetCategory petCategory = PetCategory.valueOf(productCategory);
		shopper.navigateToProductCategoryTopNavBar(petCategory);
		shopper.selectPetByName(petCategory, productName);
		shopper.addToCartSpecificProduct(productName, specificProductName);
		shopper.proceedToCheckout();
		shopper.enterPaymentAndBillingDetails(cardType, cardNumber, expiryDate, firstName, lastName, 
				address1, address2, city, state, zip, country);
		shopper.clickOnContinueButton();
		shopper.clickOnConfirmButton();
		shopper.verifyIfOrderSubmitted();
	}

}
