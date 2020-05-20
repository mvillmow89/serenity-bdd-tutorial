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
	@FindBy(xpath ="//div[@id='MainImageContent']//area[@alt='Cats']")
	private WebElementFacade CATS_LINK;
	private static String CATS_IMAGE_LINK = "//div[@id='MainImageContent']//area[@alt='Cats']";
	private static String DOGS_IMAGE_LINK = "//div[@id='MainImageContent']//area[@alt='Dogs']";
	private static String FISH_IMAGE_LINK = "//div[@id='MainImageContent']//area[@alt='Fish']";
	private static String REPTILES_IMAGE_LINK = "//div[@id='MainImageContent']//area[@alt='Reptiles']";
	
	// Pet Category Image Links - Two Image links for BIRDS so providing separate links
	private static final String BIRD_CENTER_IMAGE = "//div[@id='MainImageContent']//area[@alt='Birds'][1]";
	private static final String BIRD_SECONDARY_IMAGE = "//div[@id='MainImageContent']//area[@alt='Birds'][2]";
	
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
			$(BIRD_SECONDARY_IMAGE).click();
			break;
		case BIRDS_CENTER:
			$(BIRD_CENTER_IMAGE).click();
			break;
		case CATS:
			$(CATS_IMAGE_LINK).click();
			break;
		case DOGS:
			$(DOGS_IMAGE_LINK).click();
			break;
		case FISH:
			$(FISH_IMAGE_LINK).click();
			break;
		case REPTILES:
			$(REPTILES_IMAGE_LINK).click();
			break;
		default:
			break;
		}
		
		return this.switchToPage(ProductsPage.class);
	}
}
