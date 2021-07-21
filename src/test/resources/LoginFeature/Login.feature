#Author: amit.malviya84@yahoo.co.in
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
@EnvironmentSetup
Feature: Verifying login feature

#@login
#Scenario: User should be able to perform login with valid credential	
#	Given User has opened application on browser and application home page is loaded 
#	When Perform click on signIn page
  #And application Login page is displayed
  #And User attempt login with valid username as "abcd@efgh.com" and password as "123456789"
  #Then User should navigated to My account Page
  #And User may perform Logout from application
 
 
 
@login
Scenario: User should be able to perform login with valid credential	
	Given User has opened application on browser and application home page is loaded 
	When Perform click on signIn page
  And application Login page is displayed
 # And User attempt login with valid username as "abcd@efgh.com" and password as "123456789"
  #Then User should navigated to My account Page
  #And able to verify below tabs are displayed
  #And User may perform Logout from application
 
    

  
