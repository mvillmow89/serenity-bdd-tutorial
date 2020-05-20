Feature: Purchase pets from the store

Background: User must be logged in
Given I login to the application with valid test and test

Scenario Outline: As a user, I must be able to search pets from the store and purchase them by entering my details
	
	When I search for a <petType> it must show up in the search results
	And I view details about the pet <pet> and add it to the cart
	And I proceed to checkout
	And I enter my payment details <cardType>,<cardNumber>,<expiryDate>,<firstName>,<lastName>,<address1>,<address2>,<city>,<state>,<zip>,<country>
	And I click on Continue
	When I submit the order, the store must provide me a confirmation message on the placed order
	
	Examples:
		| pet					| petType	| cardType	| cardNumber		| expiryDate	| firstName	| lastName	| address1		| address2	| city		| state		| zip	| country	|
		| Male Adult Bulldog	| Bulldog	| Visa		| 999999999999999	| 04/2016		| John		| Doe		| 33 Web Drive 	| #413		| Mobile	| Colorado	| 34562 | USA		|
		| Female Puppy Bulldog	| Bulldog	| Visa		| 999999999999999	| 04/2016		| John		| Doe		| 33 Web Drive 	| #413		| Mobile	| Colorado	| 34562 | USA		|
		

Scenario Outline: As a user, I want to view the Pet Types

	When I search for a <petType> it must show up in the search results
	
	Examples:
		| petType	|
		| Bulldog	|