package com.jpetstore.pages;

import org.openqa.selenium.By;

import com.jpetstore.utils.PetCategory;

import net.serenitybdd.core.pages.PageObject;

public class PageBase extends PageObject {
	
	private static final String ENTER_THE_STORE_LINK = "//a[@href='actions/Catalog.action']";
	private static final String SIGN_IN_LINK = "//*[@id='MenuContent']/a[contains(text(), 'Sign In')]";
	private static final String LOGO_LINK = "//div[@id='LogoContent']/a/img";
	private static final String SIGN_OUT_LINK = "//*[@id='MenuContent']/a[contains(text(), 'Sign Out')]";
	private static final String MY_ACCOUNT_LINK = "//*[@id='MenuContent']/a[contains(text(), 'My Account')]";
	private static final String HELP_LINK = "//a[@href='../help.html']";
	private static final String SHOPPING_CART_LINK = "//img[@src='../images/cart.gif']";
	private static final String SEARCH_INPUT = "//input[@name='keyword']";
	private static final String SEARCH_BUTTON = "//input[@name='searchProducts']";
	
	//Product Quick Links
	private static final String FISH_LINK = "//div[@id='QuickLinks']/a[contains(@href,'FISH')]";
	private static final String DOGS_LINK = "//div[@id='QuickLinks']/a[contains(@href,'DOGS')]";
	private static final String REPTILES_LINK = "//div[@id='QuickLinks']/a[contains(@href,'REPTILES')]";
	private static final String CATS_LINK = "//div[@id='QuickLinks']/a[contains(@href,'CATS')]";
	private static final String BIRDS_LINK = "//div[@id='QuickLinks']/a[contains(@href,'BIRDS')]";
	private static final String BANNER_IMG = "//*[@id='Banner']/img";
	
	public DashBoardPage enterTheStore() {
		open();
		waitForTextToAppear("Welcome to JPetStore 6");
		waitFor(ENTER_THE_STORE_LINK).$(ENTER_THE_STORE_LINK).click();
		return this.switchToPage(DashBoardPage.class);
	}
	
	/**
	 * Method used to navigate to the SignOn Page
	 * @return Login Page
	 */
	public LoginPage navigateToLogOnPage() {
		
		waitFor(SIGN_IN_LINK).$(SIGN_IN_LINK).click();
		
		return this.switchToPage(LoginPage.class);
	}
	
	/**
	 * Clicks on the Sign In Link
	 * @return Login Page
	 */
	public LoginPage clickOnSignInLink() {
		
		waitFor(SIGN_IN_LINK).find(By.xpath(SIGN_IN_LINK)).click();
		
		return this.switchToPage(LoginPage.class);
	}
	
	/**
	 * Click on the Logo Link to return to the Main Dashboard Page
	 * @return DashBoardPage
	 */
	public DashBoardPage navigateToDashBoard() {
		
		waitFor(LOGO_LINK).find(By.xpath(LOGO_LINK)).click();
		
		return this.switchToPage(DashBoardPage.class);
	}
	
	/**
	 * Sign out of the account
	 * @return DashBoardPage
	 */
	public DashBoardPage signOut() {
		
		waitFor(SIGN_OUT_LINK).find(By.xpath(SIGN_OUT_LINK)).click();
		
		waitForAbsenceOf(SIGN_OUT_LINK).shouldNotBeVisible(By.xpath(SIGN_OUT_LINK));
		
		return this.switchToPage(DashBoardPage.class);
		
	}
	
	/**
	 * Go to the My Account Page
	 * @return AccountPage
	 */
	public AccountPage navigateToAccountPage() {
		
		waitFor(MY_ACCOUNT_LINK).find(By.xpath(MY_ACCOUNT_LINK)).click();
		
		return this.switchToPage(AccountPage.class);
	}
	
	/**
	 * Search for a product in the store
	 * @param searchVal - product to search for
	 * @return ProductPage
	 */
	public ProductsPage searchForProduct(String searchVal) {
		
		waitFor(SEARCH_INPUT).find(By.xpath(SEARCH_INPUT)).sendKeys(searchVal);
		waitFor(SEARCH_BUTTON).find(By.xpath(SEARCH_BUTTON)).click();
		return this.switchToPage(ProductsPage.class);
	}
	
	/**
	 * Go to the Help Page
	 * @return HelpPage
	 */
	public HelpPage navigateToHelpPage() {
		
		waitFor(HELP_LINK).find(By.xpath(HELP_LINK)).click();
		
		return this.switchToPage(HelpPage.class);
	}
	
	/**
	 * Go to the Products Page for the selected Pet Category
	 * @return ProductsPage
	 */
	public ProductsPage navigateToShoppingCart() {
		
		waitFor(SHOPPING_CART_LINK).find(By.xpath(SHOPPING_CART_LINK)).click();
		
		return this.switchToPage(ProductsPage.class);
	}
	
	public ProductsPage navigateToProductCategoryTopNavBar(PetCategory productCategory) {		
		switch(productCategory) {
		case BIRDS:
			waitFor(BIRDS_LINK).find(By.xpath(BIRDS_LINK)).click();
			break;
		case CATS:
			waitFor(CATS_LINK).find(By.xpath(CATS_LINK)).click();
			break;
		case DOGS:
			waitFor(DOGS_LINK).find(By.xpath(DOGS_LINK)).click();
			break;
		case FISH:
			waitFor(FISH_LINK).find(By.xpath(FISH_LINK)).click();
			break;
		case REPTILES:
			waitFor(REPTILES_LINK).find(By.xpath(REPTILES_LINK)).click();
			break;
		default:
			break;
		}

		return this.switchToPage(ProductsPage.class);
	}

}
