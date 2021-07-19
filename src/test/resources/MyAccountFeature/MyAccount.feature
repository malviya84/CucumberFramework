#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@myAccount
Feature: Users Activities on My account page
  I want to use this template for my feature file

  @MyAccount
  Scenario: Title of your scenario
    Given User has opened application on browser and application home page is loaded
    And Perform click on signIn page
    And application Login page is displayed
    And User attempt login with valid username as "abcd@efgh.com" and password as "123456789"
    And User should navigated to My account Page
    When Click on UPdate Address button
    And Update City as "XYZ" and Click on Save button
    Then Verify that Updated Changes are saved
    And User is still on MyAccount Page
     And User may perform Logout from application
