package com.jpetstore.pages;

import org.apache.commons.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jpetstore.utils.PetCategory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DashBoardPage extends PageBase {

	private static final String GREETING_MSG = "//*[@id='WelcomeContent']";

	// Pet Category Sidebar Links
	private String FISH_SIDEBAR_LINK = "//div[@id='SidebarContent']/a[contains(@href, 'FISH')]";
	private String CATS_SIDEBAR_LINK = "//div[@id='SidebarContent']/a[contains(@href, 'CATS')]";
	private String DOGS_SIDEBAR_LINK = "//div[@id='SidebarContent']/a[contains(@href, 'DOGS')]";
	private String REPTILES_SIDEBAR_LINK = "//div[@id='SidebarContent']/a[contains(@href, 'REPTILES')]";
	private String BIRDS_SIDEBAR_LINK = "//div[@id='SidebarContent']/a[contains(@href, 'BIRDS')]";
	

	// Pet Category Image Links - FISH, DOGS, REPTILES, CATS
	// Using JS since FireFox has click problems clicking other locator methods
	private static String CATS_IMAGE_JS_LINK_CLICK = "document.getElementsByTagName('area')[4].click()";
	private static String DOGS_IMAGE_JS_LINK_CLICK = "document.getElementsByTagName('area')[2].click()";
	private static String FISH_IMAGE_JS_LINK_CLICK = "document.getElementsByTagName('area')[1].click()";
	private static String REPTILES_IMAGE_JS_LINK_CLICK = "document.getElementsByTagName('area')[3].click()";
	
	// Pet Category Image Links - Two Image links for BIRDS so providing separate links
	private static final String BIRD_CENTER_IMAGE_JS_LINK_CLICK = "document.getElementsByTagName('area')[0].click()";
	private static final String BIRD_SECONDARY_IMAGE_JS_LINK_CLICK = "document.getElementsByTagName('area')[5].click()";
	
	/**
	 * Get the greeting message
	 * @return
	 */
	public String getGreetingMessage() {
		return waitFor(GREETING_MSG).$(GREETING_MSG).getText();
	}
	
	/**
	 * Select a Pet Product from the SideBar
	 * @return
	 */
	public ProductsPage selectProductFromSideBarDisplay(PetCategory petType) {
		
		switch(petType) {
		case BIRDS:
			$(BIRDS_SIDEBAR_LINK).click();
			break;
		case CATS:
			$(CATS_SIDEBAR_LINK).click();
			break;
		case DOGS:
			$(DOGS_SIDEBAR_LINK).click();
			break;
		case FISH:
			$(FISH_SIDEBAR_LINK).click();
			break;
		case REPTILES:
			$(REPTILES_SIDEBAR_LINK).click();
			break;
		default:
			break;
		}
		return this.switchToPage(ProductsPage.class);
	}
	
	/**
	 * Select a Pet Product from the Image Display
	 * @return
	 */
	public ProductsPage selectProductFromImageDisplay(PetCategory petType) {
		
		switch(petType) {
		case BIRDS:
			evaluateJavascript(BIRD_SECONDARY_IMAGE_JS_LINK_CLICK);
			break;
		case BIRDS_CENTER:
			evaluateJavascript(BIRD_CENTER_IMAGE_JS_LINK_CLICK);
			break;
		case CATS:
			evaluateJavascript(CATS_IMAGE_JS_LINK_CLICK);
			break;
		case DOGS:
			evaluateJavascript(DOGS_IMAGE_JS_LINK_CLICK);
			break;
		case FISH:
			evaluateJavascript(FISH_IMAGE_JS_LINK_CLICK);
			break;
		case REPTILES:
			evaluateJavascript(REPTILES_IMAGE_JS_LINK_CLICK);
			break;
		default:
			break;
		}
		
		return this.switchToPage(ProductsPage.class);
	}
}
