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
@EnvironmentSetup
Feature: User should be able to navigate application social pages on social networking site


  @SocialNetworking @CloseBroser
  Scenario: Title of your scenario
    Given User has opened application on browser and application home page is loaded 
    When User click on twitter icon
    And  New twitter page is displayed 
   # Then User should be able to perform search on twitter page with search Term as "Persistent"
   # And switch back to parent window after closing twitter page
    