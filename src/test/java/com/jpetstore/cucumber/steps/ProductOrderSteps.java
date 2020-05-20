package com.jpetstore.cucumber.steps;

import java.util.List;

import com.jpetstore.cucumber.steps.serenity.PetStoreSteps;
import com.jpetstore.utils.PetCategory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ProductOrderSteps {
	
	@Steps
	PetStoreSteps shopper;
	
	@Given("^I login to the application with valid (.*) and (.*)$")
	public void i_login_to_the_application_with_valid_test_and_test(String userName, String password) {
	    shopper.enterTheStore();
	    shopper.navigateToLogInPage();
	    shopper.doLogin(userName, password);
	}

	@When("^I search for a (.*) it must show up in the search results$")
	public void i_search_for_a_pet_it_must_show_up_in_the_search_results(String petType) {
		Serenity.setSessionVariable("petType").to(petType);
		shopper.searchForProduct(petType);
		shopper.selectProductFromSearchResultsTable(petType);
	}

	@When("^I view details about the pet (.+) and add it to the cart$")
	public void i_view_details_about_the_pet_type_and_add_it_to_the_cart(String pet) {
		String petType = Serenity.sessionVariableCalled("petType");
		shopper.addToCartSpecificProduct(petType, pet);
	}

	@When("^I proceed to checkout$")
	public void i_proceed_to_checkout() {
		shopper.proceedToCheckout();
	}

	@When("^I enter my payment details (.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*)$")
	public void i_enter_my_payment_details(String cardType, String cardNumber, String expiryDate, String firstName,
			String lastName, String address1, String address2, String city, String state, String zip, String country) {
	    shopper.enterPaymentAndBillingDetails(cardType, cardNumber, expiryDate, firstName, lastName, address1, address2, city, state, zip, country);
	}

	@When("^I click on Continue$")
	public void i_click_on_Continue() {
		shopper.clickOnContinueButton();
	}

	@When("^I submit the order, the store must provide me a confirmation message on the placed order$")
	public void i_submit_the_order_the_store_must_provide_me_a_confirmation_message_on_the_placed_order() {
		shopper.clickOnConfirmButton();
		shopper.verifyIfOrderSubmitted();
	}
		
	@When("^I click on a category, then a category is displayed$")
	public void i_click_on_a_category_then_a_category_is_displayed(DataTable arg1) throws InterruptedException {
		
		List<String> searchVal =  arg1.asList(String.class);
		
		for( String s : searchVal ) {
			shopper.navigateToProductCategory(PetCategory.valueOf(s));
		}
	}
}
