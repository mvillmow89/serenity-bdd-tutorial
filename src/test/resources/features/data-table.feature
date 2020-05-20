Feature: View all Pet Categories

#DataTable in Cucumber
Scenario: As a user, I want to view all the categories
	Given I login to the application with valid test and test
	When I click on a category, then a category is displayed
		| FISH	|
		| CATS	|
		| DOGS	|
		| BIRDS	|
		| REPTILES |