//package com.jpetstore.tests;
//
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.WebDriver;
//
//import com.jpetstore.steps.PetStoreSteps;
//import com.jpetstore.utils.PetCategory;
//
//import net.serenitybdd.junit.runners.SerenityRunner;
//import net.thucydides.core.annotations.Managed;
//import net.thucydides.core.annotations.Steps;
//import net.thucydides.core.annotations.Title;
//
//@RunWith(SerenityRunner.class)
//public class SampleTest {
//	
//	@Managed
//	WebDriver driver;
//	
//	@Steps
//	PetStoreSteps shopper;
//	
//	@Test
//	@Title("Navigating to the Sign In Page")
//	public void navigateToSignOnPage() throws InterruptedException {
//		shopper.enterTheStore();
//		shopper.selectProductFromImageDisplay(PetCategory.CATS);
//		shopper.selectPetByName(PetCategory.CATS, "Persian");
//		//shopper.addToCartSpecificProduct("Persian", "Adult Female Persian");
//		shopper.searchForProduct("Persian");
//		shopper.selectProductFromSearchResultsTable("Persian");
//		shopper.addToCartByViewingItemDetails("Persian", "Adult Female Persian", "Friendly house cat, doubles as a princess");
//		assertNotNull(shopper.shoppingCart("Adult Female Persian", 4));
//		//shopper.proceedToCheckout();
//		shopper.removeItemFromShoppintCart("Adult Female Persian");
//		Thread.sleep(3000);
//	}
//
//}
