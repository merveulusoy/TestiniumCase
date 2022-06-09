Feature: Gittigidiyor Web Page

@testinium
  Scenario: Open web page
    Given the user enters the web page
    Then user type "bilgisayar" to search box
    Then user click to second page from search results
    Then the user should be able to see "https://www.gittigidiyor.com/arama?k=bilgisayar&sf=2" as web page URL
  ## Bazen bu sayfa "https://www.gittigidiyor.com/masaustu-desktop-bilgisayar?k=bilgisayar&qm=1&sf=2" olarak değişiyor.
    And the user choose a random product
    And the user type chosen product's information and price on txt file
    And the user add the chosen product to basket
    And the user verify that they are same the product price and the product which is in the basket
    And the user increase the number of product and verify that is 2
    Then the user delete the product and verify that the basket is empty


