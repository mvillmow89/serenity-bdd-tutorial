package com.jpetstore.pages;

import com.jpetstore.utils.PetCategory;
import static net.thucydides.core.matchers.BeanMatchers.*;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsPage extends PageBase {
	
	private static final String PRODUCT_TABLE = "//*[@id='Catalog']/table";
	private static final String ANCHOR = "//*[@id='Catalog']//table//td[normalize-space()='";
	private static final String BUTTON = "//a[@class='Button']";
	private static final String PROCEED_TO_CHECKOUT = "//a[contains(@href, 'newOrderForm')]";
	
	/**
	 * Select the pet from the name provided
	 * @param petType
	 * @param petName
	 * @return
	 */
	public ProductsPage selectPetByName(PetCategory petCategory, String petName) {
		waitForTextToAppear(petCategory.getPetTypeString());
		
		List<WebElement> rows = inTable($(PRODUCT_TABLE)).filterRows(the("Name", equalTo(petName)));
		
		rows.get(0).findElement(By.tagName("a")).click();
		
		return this;
	}
	
	/**
	 * This method will add a pet to the shopping cart
	 * @param productType
	 * @param specificProductName
	 * @return
	 */
	public ProductsPage addToCartSpecificProduct(String productType, String specificProductName) {
		waitForTextToAppear(productType);
		
		$(PRODUCT_TABLE).shouldContainText(specificProductName);
		String addToCartButton = ANCHOR + specificProductName + "']//parent::tr//a[contains(@href,'addItemToCart')]";
		
		waitFor(addToCartButton).$(addToCartButton).click();
		
		return this;
	}
	
	/**
	 * Add an item to the cart by viewing details
	 * @param productType - Product Category
	 * @param specificProductName - Description of the Product
	 * @param specificProductName - Description of the Product
	 * @return
	 */
	public ProductsPage addToCartByViewingItemDetails(String productType, String specificProductName,
			String productCharacteristic) {
		waitForTextToAppear(productType);

		$(PRODUCT_TABLE).shouldContainText(specificProductName);
		String viewDetailsLink = ANCHOR + specificProductName + "']//parent::tr//a[contains(@href,'viewItem')]";
		
		waitFor(viewDetailsLink).$(viewDetailsLink).click();
		waitForAnyTextToAppear(productType, specificProductName, productCharacteristic);
		$(BUTTON).click();
		
		return this;
	}
	
	/**
	 * Search for an item and select a product from the table
	 * @param specificProductName - the specific product item to select
	 * @return
	 */
	public ProductsPage selectProductFromSearchResultsTable(String specificProductName) {
		
		String searchResultProductLink = ANCHOR + specificProductName + "']//parent::tr//img//parent::a";
		waitFor(searchResultProductLink).$(searchResultProductLink).click();
		return this;
	}
	
	/**
	 * Interact with the cart
	 * @param description - description of the product being purchased
	 * @param quantity - number of items for the product being purchased
	 * @return
	 */
	public ProductsPage shoppingCart(String description, int quantity) {
		waitForTextToAppear(description);
		
		String quantityInput = ANCHOR + description + "']//following-sibling::td/input";
		String totalCostLabel = ANCHOR + description + "']//following-sibling::td[4]";
		
		if(quantity > 0) {
			float initialCost = Float.valueOf($(totalCostLabel).getText().substring(1));
			$(quantityInput).typeAndEnter(Integer.toString(quantity));
			
			float totalCost = Float.valueOf($(totalCostLabel).getText().substring(1));
			if( (quantity * initialCost) != totalCost) {
				return null;
			} 
		}
		
		if(quantity == 0) {
			$(quantityInput).typeAndEnter(Integer.toString(quantity));
			waitForAbsenceOf(quantityInput).shouldNotBeVisible(By.xpath(quantityInput));
		}
		
		return this;
	}
	
	/**
	 * Remove an item from the shopping cart
	 * @param description
	 * @return
	 */
	public boolean removeItemFromShoppintCart(String description) {

		String removeButton = ANCHOR + description + "']//following-sibling::td/a";
		waitFor(removeButton).$(removeButton).click();
		return !waitForAbsenceOf(removeButton).isElementVisible(By.xpath(removeButton));
	}
	
	/**
	 * Click on Proceed to checkout
	 * @return OrdersPage
	 */
	public OrdersPage proceedToCheckout() {
		waitFor(PROCEED_TO_CHECKOUT).$(PROCEED_TO_CHECKOUT).click();
		return this.switchToPage(OrdersPage.class);
	}
	
}
