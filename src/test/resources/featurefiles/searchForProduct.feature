Feature: A specific product can be found using the "Search" function on the page

    Rule: Test for searching and finding a specific product

    Background:
        Given I open Tesco page
        When I accept cookies

    Scenario: Search for a specific product by name
        Given I am on the main page
        When I enter a product in the Search field
        When I click on the search icon
        Then the appropriate product is found and displayed

