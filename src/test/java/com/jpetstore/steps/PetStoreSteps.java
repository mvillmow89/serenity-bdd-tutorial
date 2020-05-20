package com.jpetstore.steps;

import org.openqa.selenium.By;

import com.jpetstore.pages.AccountPage;
import com.jpetstore.pages.DashBoardPage;
import com.jpetstore.pages.HelpPage;
import com.jpetstore.pages.LoginPage;
import com.jpetstore.pages.OrdersPage;
import com.jpetstore.pages.PageBase;
import com.jpetstore.pages.ProductsPage;
import com.jpetstore.utils.PetCategory;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PetStoreSteps extends ScenarioSteps {
	
	PageBase pageBase;
	DashBoardPage dashboardPage;
	LoginPage loginPage;
	AccountPage accountPage;
	ProductsPage productsPage;
	OrdersPage ordersPage;
	
	/*****************************************************************************
	 * ***************************************************************************
	 * 
	 * BASE PAGE STEPS
	 * 
	 * ***************************************************************************
	 *****************************************************************************/
	
	@Step("Click the Link to Enter the Store")
	public DashBoardPage enterTheStore() {
		return pageBase.enterTheStore();
	}
	
	@Step("Navigate to the Sign On Page")
	public LoginPage navigateToLogInPage() {
		return pageBase.navigateToLogOnPage();
	}
	
	@Step("Signing out from the store")
	public DashBoardPage signOut() {
		return pageBase.signOut();
	}
	
	@Step("Signing into the store")
	public LoginPage clickOnSignInLink() {
		return pageBase.clickOnSignInLink();
	}
	
	@Step("Navigate to the Main Dashboard Page From the Store Logo")
	public DashBoardPage navigateToDashBoard() {
		return pageBase.navigateToDashBoard();
	}
	
	@Step("Navigate to the User Account Page")
	public AccountPage navigateToAccountPage() {
		return pageBase.navigateToAccountPage();
	}
	
	@Step("Search for a product: {0}")
	public ProductsPage searchForProduct(String searchValue) {
		return pageBase.searchForProduct(searchValue);
	}
	
	@Step("Navigate to the Help Page")
	public HelpPage navigateToHelpPage() {
		return pageBase.navigateToHelpPage();
	}
	
	@Step("Navigate to the Shopping Cart")
	public ProductsPage navigateToShoppingCart() {
		return pageBase.navigateToShoppingCart();
	}
	
	@Step("Navigate to the Pet Category Page for category: {0}")
	public ProductsPage navigateToProductCategory(PetCategory petCategory) {
		return pageBase.navigateToProductCategory(petCategory);
	}

	
	/*****************************************************************************
	 * ***************************************************************************
	 * 
	 * DASHBOARD PAGE STEPS
	 * 
	 * ***************************************************************************
	 *****************************************************************************/
	@Step("Get Greeting Message")
	public String getGreetingMessage() {
		return dashboardPage.getGreetingMessage();
	}
	
	@Step("Select Pet Product: {0} Using the Side Bar")
	public ProductsPage selectProductFromSideBarDisplay(PetCategory petType) {
		return dashboardPage.selectProductFromSideBarDisplay(petType);
	}
	
	@Step("Select Pet Product: {0} Using the Image Display")
	public ProductsPage selectProductFromImageDisplay(PetCategory petType) {
		return dashboardPage.selectProductFromImageDisplay(petType);
	}
	
	/*****************************************************************************
	 * ***************************************************************************
	 * 
	 * LOGIN PAGE STEPS
	 * 
	 * ***************************************************************************
	 *****************************************************************************/
	
	@Step("Log into the Pet Store with username: {0}, password: {1}")
	public DashBoardPage doLogin(String username, String password) {
		return loginPage.doLogin(username, password);
	}
	
	@Step("Navigating to User Registration Page")
	public AccountPage navigateToRegistrationPage() {	
		return loginPage.navigateToRegistrationPage();
	}
	
	@Step("Get Invalid Login Message")
	public String getMessageOnInvalidLogin() {
		return loginPage.getMessageOnInvalidLogin();
	}
	
	/*****************************************************************************
	 * ***************************************************************************
	 * 
	 * ACCOUNT PAGE STEPS
	 * 
	 * ***************************************************************************
	 *****************************************************************************/
	
	@Step("Adding new user info with username: {0}, password: {1}, repeatedPassword: {2}")
	public AccountPage addNewUserInformation(String username, String password, String repeatedPassword) {
		return accountPage.addNewUserInformation(username, password, repeatedPassword);
	}

	@Step("Adding account info with First Name: {0}, Last Name: {1}, Email: {2}, Phone: {3}, Address1: {4}, "
			+ "Address2: {5}, City: {6}, State: {7}, Zip: {8}, Country: {9}")
	public AccountPage addAccountInformation(String firstName, String lastName, 
			 String email, String phone, 
			 String address1, String address2,
			 String city, String state, 
			 String zip, String country) {
		return accountPage.addAccountInformation(firstName, lastName, email, phone, address1, address2, city, state, zip, country);
	}
	
	@Step("Adding Profile Information - language: {0}, category: {1}, myList: {2}, myBanner: {3}")
	public AccountPage addProfileInformation(String language, String category, 
			 boolean myList, boolean myBanner) {
		return accountPage.addProfileInformation(language, category, myList, myBanner);
	}
	
	@Step("Saving Account Information")
	public DashBoardPage clickSaveAccountInfo() {
		return accountPage.clickSaveAccountInfo();
	}
	
	/*****************************************************************************
	 * ***************************************************************************
	 * 
	 * PRODUCTS PAGE STEPS
	 * 
	 * ***************************************************************************
	 *****************************************************************************/

	@Step("Selecting a Pet with petCategory: {0} and petName: {1}")
	public ProductsPage selectPetByName(PetCategory petCategory, String petName) {
		return productsPage.selectPetByName(petCategory, petName);
	}
	
	@Step("Adding {1} to the shopping cart")
	public ProductsPage addToCartSpecificProduct(String productType, String specificProductName) {
		return productsPage.addToCartSpecificProduct(productType, specificProductName);
	}
	
	@Step("Adding {1} to the shopping cart after viewing item details")
	public ProductsPage addToCartByViewingItemDetails(String productType, String specificProductName,
			String productCharacteristic) {
		return productsPage.addToCartByViewingItemDetails(productType, specificProductName, productCharacteristic);
	}
	
	@Step("Selecting {0} from the search results")
	public ProductsPage selectProductFromSearchResultsTable(String specificProductName) {
		return productsPage.selectProductFromSearchResultsTable(specificProductName);
	}
	
	@Step("In the shopping cart, select {1} of the item {0}")
	public ProductsPage shoppingCart(String description, int quantity) {
		return productsPage.shoppingCart(description, quantity);
	}
	
	@Step("Remove item {0} from shopping cart")
	public boolean removeItemFromShoppintCart(String description) {
		return productsPage.removeItemFromShoppintCart(description);
	}
	
	@Step("Proceed to Checkout")
	public OrdersPage proceedToCheckout() {
		return productsPage.proceedToCheckout();
	}
	
	/*****************************************************************************
	 * ***************************************************************************
	 * 
	 * ORDERS PAGE STEPS
	 * 
	 * ***************************************************************************
	 *****************************************************************************/
	
	@Step("Enter the Payment and Billing Details for an order: "
			+ "cardType: {0}, cardNumber: {1}, expirationDate: {2}, "
			+ "firstName: {3}, lastName: {4}, address1: {5}, address2: {6}, "
			+ "city: {7}, state: {8}, zip: {9}, country: {10}")
	public OrdersPage enterPaymentAndBillingDetails(String cardType, String cardNumber, String expiryDate, 
			String firstName, String lastName,String address1, String address2, String city, String state, 
			String zip, String country) {
		return ordersPage.enterPaymentAndBillingDetails(cardType, cardNumber, expiryDate, firstName, 
				lastName, address1, address2, city, state, zip, country);
	}
	
	@Step("Check box to Ship Order to a Different Address")
	public OrdersPage clickShipToDifferentAddress() {
		return ordersPage.clickShipToDifferentAddress();
	}

	@Step("Click the Continue Button to Navigate to the Next Orders Checkout Step")
	public OrdersPage clickOnContinueButton() {
		return ordersPage.clickOnContinueButton();
	}
	
	@Step("Enter the Alternate Shipping Details for an order: "
			+ "firstName: {0}, lastName: {1}, address1: {2}, address2: {3}, "
			+ "city: {4}, state: {5}, zip: {6}, country: {7}")
	public OrdersPage enterAlternateShippingInfo(String firstName, String lastName, String address1, 
			String address2, String city, String state, String zip, String country) {
		return ordersPage.enterAlternateShippingInfo(firstName, lastName, address1, address2, city, state, zip, country);
	}
	
	@Step("Click on Confirmation Button to Complete the Order")
	public OrdersPage clickOnConfirmButton() {
		return ordersPage.clickOnConfirmButton();
	}
	
	@Step("Verify that Order Placed and Message is Displayed")
	public void verifyIfOrderSubmitted() {
		ordersPage.verifyIfOrderSubmitted();
	}
}
