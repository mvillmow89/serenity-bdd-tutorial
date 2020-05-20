package com.jpetstore.pages;

public class OrdersPage extends PageBase {

	// Payment View Locators
	private static final String FIRST_NAME_INPUT = "//input[@name='order.billToFirstName']";
	private static final String LAST_NAME_INPUT = "//input[@name='order.billToLastName']";
	private static final String ADDRESS_1_INPUT = "//input[@name='order.billAddress1']";
	private static final String ADDRESS_2_INPUT = "//input[@name='order.billAddress2']";
	private static final String CITY_INPUT = "//input[@name='order.billCity']";
	private static final String STATE_INPUT = "//input[@name='order.billState']";
	private static final String ZIP_INPUT = "//input[@name='order.billZip']";
	private static final String COUNTRY_INPUT = "//input[@name='order.billCountry']";
	private static final String CARD_TYPE_DROPDOWN = "//select[@name='order.cardType']";
	private static final String CREDIT_CARD_INPUT = "//input[@name='order.creditCard']";
	private static final String EXPIRY_DATE_INPUT = "//input[@name='order.expiryDate']";
	private static final String SHIP_TO_DIFF_ADDRESS = "//input[@name='shippingAddressRequired']";
	private static final String CONTINUE_BUTTON = "//input[@name='newOrder']";
	
	// Shipping View Locators
	private static final String SHIPPING_FIRST_NAME_INPUT = "//input[@name='order.shipToFirstName']";
	private static final String SHIPPING_LAST_NAME_INPUT = "//input[@name='order.shipToLastName']";
	private static final String SHIPPING_ADDRESS_1_INPUT = "//input[@name='order.shipAddress1']";
	private static final String SHIPPING_ADDRESS_2_INPUT = "//input[@name='order.shipAddress2']";
	private static final String SHIPPING_CITY_INPUT = "//input[@name='order.shipCity']";
	private static final String SHIPPING_STATE_INPUT = "//input[@name='order.shipState']";
	private static final String SHIPPING_ZIP_INPUT = "//input[@name='order.shipZip']";
	private static final String SHIPPING_COUNTRY_INPUT = "//input[@name='order.shipCountry']";
	
	// Confirmation Locators
	private static final String CONFIRM_BUTTON = "//a[contains(@href,'confirmed')]";
	private static final String ORDER_CONFIRMATION_TEXT = "//div[@id='Content']/ul/li";
	
	/**
	 * Enter Payment and Billing Details for placing an order
	 * @param cardType :Visa, MasterCard, American Express
	 * @param cardNumber :16 digit fake number
	 * @param expiryDate : MM/YYYY format
	 * @param firstName
	 * @param lastName
	 * @param address1
	 * @param address2
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @return OrdersPage
	 */
	public OrdersPage enterPaymentAndBillingDetails(String cardType, String cardNumber, String expiryDate, String firstName, String lastName,
			String address1, String address2, String city, String state, String zip, String country) {
		waitForAnyTextToAppear("Payment Details","Billing Address");
		
		$(CARD_TYPE_DROPDOWN).selectByVisibleText(cardType);
		$(CREDIT_CARD_INPUT).type(cardNumber);
		$(EXPIRY_DATE_INPUT).type(expiryDate);
		$(FIRST_NAME_INPUT).type(firstName);
		$(LAST_NAME_INPUT).type(lastName);
		$(ADDRESS_1_INPUT).type(address1);
		$(ADDRESS_2_INPUT).type(address2);
		$(CITY_INPUT).type(city);
		$(STATE_INPUT).type(state);
		$(ZIP_INPUT).type(zip);
		$(COUNTRY_INPUT).type(country);
		
		return this;		
	}
	
	/**
	 * Select to enter details to ship to a different address
	 * @return OrdersPage
	 */
	public OrdersPage clickShipToDifferentAddress() {
		waitForTextToAppear("Ship to different address...");
		$(SHIP_TO_DIFF_ADDRESS).click();
		return this;
	}
	
	/**
	 * Click on the Continue Button
	 * @return OrdersPage
	 */
	public OrdersPage clickOnContinueButton() {
		waitFor(CONTINUE_BUTTON).$(CONTINUE_BUTTON).click();
		return this;
	}
	
	/**
	 * Enter the shipping information if different than Billing information
	 * @param firstName
	 * @param lastName
	 * @param address1
	 * @param address2
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @return OrdersPage
	 */
	public OrdersPage enterAlternateShippingInfo(String firstName, String lastName, String address1, String address2,
			String city, String state, String zip, String country) {
		waitForAnyTextToAppear("Shipping Address");
		
		$(SHIPPING_FIRST_NAME_INPUT).type(firstName);
		$(SHIPPING_LAST_NAME_INPUT).type(lastName);
		$(SHIPPING_ADDRESS_1_INPUT).type(address1);
		$(SHIPPING_ADDRESS_2_INPUT).type(address2);
		$(SHIPPING_CITY_INPUT).type(city);
		$(SHIPPING_STATE_INPUT).type(state);
		$(SHIPPING_ZIP_INPUT).type(zip);
		$(SHIPPING_COUNTRY_INPUT).type(country);
		
		return this;		
	}
	
	/**
	 * Click on the confirm button to purchase shopping cart items
	 * @return OrdersPage
	 */
	public OrdersPage clickOnConfirmButton() {
		waitForTextToAppear("Please confirm the information below and then press continue...");
		waitFor(CONFIRM_BUTTON).$(CONFIRM_BUTTON).click();
		return this;
	}
	
	/**
	 * Verify the order has been placed
	 */
	public void verifyIfOrderSubmitted() {
		waitFor(ORDER_CONFIRMATION_TEXT).shouldContainText("Thank you, your order has been submitted.");
	}
}
