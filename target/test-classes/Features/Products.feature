@ProductsFeature
Feature: Feature to select some products into Sauce page
  
    @StandardUser
  Scenario: Select and purchase the lowest and highest priced products
    Given I log in to Swag Lab
    And user enters like "standard_user" and password "secret_sauce"
    When I select the "Price (low to high)" filter
    And I choose the products
    And I go to my cart to buy my products
    Then the new purchase should be successful
  