@DSIntroduction
Feature: Test Case Scenarios for DS Introduction
  Background: clicking on Getstarted below DS and land on DS-Introduction Page
    Given User logged in and landed on the HomePage
    When User Clicks on the Get Started below DS Page
    Then User should be on the DS Introduction Page
     
  @DSConcepts
  Scenario Outline: clicking on  concepts under DataStructures and giving code in Try Editor
    Given User is on DS Page 
    When User clicks on Time Complexity in DS Page
    Then User should be redirected to clicked link Page
    When User clicks on Try Here Button
    Then User should be redirected to DS Editor's page with Run Button
    When User clicks on the Run after entering DS code "<SheetName>" and <RowNum>
    Then User will see output on console
    
    
    Examples:   
    |   SheetName    | RowNum |
    |Input and Output|    0   |
    |Input and Output|    1   |
    |Input and Output|    2   |
