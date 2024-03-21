@DSIntroduction
Feature: Test Case Scenarios for DS Introduction
  Background: clicking on Getstarted below DS and land on DS-Introduction Page
    Given User logged in and landed on Home Page
    When User Clicks on the Get Started below DS Page
    Then User should be on the DS Introduction Page
     
  @Concepts
  Scenario Outline: clicking on  concepts under DataStructures and giving code in Try Editor
    Given User is on DS Page 
    When User clicks on "<Concepts>" under DS Page
    Then User should be redirected to clicked link Page
    When User clicks on Try Here Button
    Then User should be redirected to Editor's page with Run Button
    When User clicks on the Run Button entering code "<SheetName>" and <RowNum>
    Then User will be able to see the output on console
    
    Examples:
    |   SheetName        |  RowNum  |  Concepts          |
    |   Input and Output |   0      |  Time Complexity   |
    |   Input and Output |   1      |  Time Complexity   |
    |   Input and Output |   2      |  Time Complexity   |