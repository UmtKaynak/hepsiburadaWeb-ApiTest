Feature:CartPageTestScenarios

  Background:
    Given Select Browser As "chrome"
    When User get "https://www.hepsiburada.com/" address
    And User can displayed "ACCEPT_COOKIE_BUTTON" on the "HomePage" page
    When User checks that the cart is empty

  @Test
  Scenario: Search_Product_Filtered_Add_To_Card_Price_Compare
    And User hover the "Elektronik" menu and selects "Bilgisayar/Tablet" category and click "Tablet" sub category
    When User applies filters on product list
      | Brand | Screen_Size | Ram_Capacity |
      | Apple | 13,2        | None         |
    And User selects "EXPENSIVE" product
    When User focuses on tab 2
    And User adds the product to the cart
    Then User compares the price In cart page



