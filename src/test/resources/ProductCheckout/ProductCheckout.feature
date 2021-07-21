@EnvironmentSetup
Feature: Product Checkout

  #@Purchase
  #Scenario: User will purchase a product
    #Given User is logged in
    #When User select a product to buy
    #Then User would buy a good

  @Purchase
  Scenario: User should be able to search of product category and complete checkout by adding product from search result
    Given User has opened application on browser and application home page is loaded
    And Perform click on signIn page
    And application Login page is displayed
    #And User attempt login with valid username as "abcd@efgh.com" and password as "123456789"
    #When User Select category as "Women>Tops>T-shirts"
    #And Add product a product "Faded Short Sleeve T-shirts" to cart
    #Then User should be able to complete checkout process
    # And User may perform Logout from application
    
