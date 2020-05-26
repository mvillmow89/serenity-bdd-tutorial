package com.jpetstore.tests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenitySystemProperties;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.jpetstore.steps.PetStoreSteps;
import com.jpetstore.utils.PetCategory;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
public class NavigationTest {
	
	@Managed
	WebDriver driver;
	
	@Steps
	PetStoreSteps shopper;
	
	@Test
	@WithTag("smoke:navigation")
	@Title("Verify the Pet Category Image Navigation Links on the Main Dashboard Page")
	public void verifyDashboardPetImageNavigationLinks() throws InterruptedException {
		shopper.enterTheStore();
		shopper.selectProductFromImageDisplay(PetCategory.CATS);
		shopper.navigateToDashBoard();
		shopper.selectProductFromImageDisplay(PetCategory.DOGS);
		shopper.navigateToDashBoard();
		shopper.selectProductFromImageDisplay(PetCategory.REPTILES);
		shopper.navigateToDashBoard();
		shopper.selectProductFromImageDisplay(PetCategory.FISH);
		shopper.navigateToDashBoard();
		shopper.selectProductFromImageDisplay(PetCategory.BIRDS);
		shopper.navigateToDashBoard();
		shopper.selectProductFromImageDisplay(PetCategory.BIRDS_CENTER);
	}
	
	@Test
	@WithTag("smoke:navigation")
	@Title("Verify the Pet Category Side Navigation Links on the Main Dashboard Page")
	public void verifyDashboardPetSideNavigationLinks() throws InterruptedException {
		shopper.enterTheStore();
		shopper.selectProductFromSideBarDisplay(PetCategory.CATS);
		shopper.navigateToDashBoard();
		shopper.selectProductFromSideBarDisplay(PetCategory.DOGS);
		shopper.navigateToDashBoard();
		shopper.selectProductFromSideBarDisplay(PetCategory.REPTILES);
		shopper.navigateToDashBoard();
		shopper.selectProductFromSideBarDisplay(PetCategory.FISH);
		shopper.navigateToDashBoard();
		shopper.selectProductFromSideBarDisplay(PetCategory.BIRDS);
	}
	
	@Test
	@WithTag("smoke:navigation")
	@Title("Verify the Pet Category Top Navigation Links on the Main Dashboard Page")
	public void verifyDashboardPetTopNavigationLinks() throws InterruptedException {
		shopper.enterTheStore();
		shopper.navigateToProductCategoryTopNavBar(PetCategory.CATS);
		shopper.navigateToDashBoard();
		shopper.navigateToProductCategoryTopNavBar(PetCategory.DOGS);
		shopper.navigateToDashBoard();
		shopper.navigateToProductCategoryTopNavBar(PetCategory.REPTILES);
		shopper.navigateToDashBoard();
		shopper.navigateToProductCategoryTopNavBar(PetCategory.FISH);
		shopper.navigateToDashBoard();
		shopper.navigateToProductCategoryTopNavBar(PetCategory.BIRDS);
	}

}
