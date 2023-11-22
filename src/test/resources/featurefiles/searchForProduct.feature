Feature: A specific product can be found using the "Search" function on the page

    Background:
        Given I open home page
        And I accept cookies

    Rule: Test for searching and finding/not finding a specific product

        Scenario: Search for a specific product by name (társasjáték)
            When I search for "társasjáték"
            Then product is displayed that contains "társasjáték"

#    Rule: If search with empty input search is not available
#
#        Scenario: Search with an empty input
#            When I search for ""
#            Then the search function does nothing and stays on the same page
#
#    Rule: If search for a non-existing product a message displayed
#
#        Scenario: Search for a non existing product (asdf)
#            When I search for "asdf"
#            Then a message is displayed that the search didn't find anything

