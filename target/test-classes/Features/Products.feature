#Author: rociodelalba@gmail.com
#Description: This feature contains 4 scenarios based on the types of users with which the application can be accessed:
#Standard, Locked Out and Problem Users.
@ProductsFeature
Feature: Feature to try enter with the available users in the Sauce Demo web

  @StandardUser
  Scenario: Select and purchase the lowest and highest priced products
    Given I navigate to the Sauce Demo application
    And I enter the web such as standard_user user
    When I select the filter Price Low to High
    And I choose the products
    And I go to my cart to buy my products
    Then the new purchase should be successful

  @LockedOutUser
  Scenario: Validates login with locked out user
    Given I navigate to the Sauce Demo application
    When I enter the web such as locked_out_user user
    Then The application should be display an error message

  @ProblemUser
  Scenario Outline: Login with Problem user and try to select a filter option
    Given I navigate to the Sauce Demo application
    And I enter the web such as problem_user user
    When I select the filter <Option>
    Then the application should not select the filter option

    Examples: 
      | Option              |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |

  @FillsCheckout
  Scenario: Tries to verify the checkout your information section with Problem User
    Given I navigate to the Sauce Demo application
    And I enter the web such as problem_user user
    When I choose the products
    And I go to my cart to buy my products
    And I try to fill all the required fields
    Then the checkout form should not allow me to fill the Last Name field
