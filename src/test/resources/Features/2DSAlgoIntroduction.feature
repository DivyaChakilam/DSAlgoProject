@DSAlgoIntro
Feature: DS Algo Introduction Page
  #Validating DsAlgo Intro Page

  Scenario: DropDown options check
    Given User Landed on DsAlgo Introduction Page
    When User clicks on DataStructure Dropdown
    Then User should see six different datastructures
    
  Scenario: DropDown option click and check for error message 
    Given User Landed on DsAlgo Introduction Page
    When User clicks on DataStructure Dropdown
    And User clicks on any item from DataStructures DropDown
    Then User gets alert message
    
  Scenario: Clicks any Ds GetStarted button and check error message
    Given User Landed on DsAlgo Introduction Page
    When User clicks on any GetStarted button
    Then User gets alert message
    
    Scenario: Land on Registration Page
    Given User Landed on DsAlgo Introduction Page
    When User clicks on Register button
    Then User should land on Register page 
    
    Scenario: Landing on Login Page
    Given User Landed on DsAlgo Introduction Page
    When User clicks on Login 
    Then User lands on Login page with Register link below the textboxes
    
     
    
    