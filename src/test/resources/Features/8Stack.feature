@StackDS
Feature: Test Case Scenarios for Stack DS
  Background: clicking on Getstarted below Stack DS and land on Stack Page
    Given User is logged in and landed on Home Page
    When User Clicks Get Started below Stack DS
    Then User should be redirected to Stack Page
    
    @StackConcepts
  Scenario Outline: clicking on concepts under stack and giving code in try Editor 
    Given User is on Stack page
    When User clicks on "<Concepts>" under stack page
    Then User should be redirected to the clicked stack link Page 
    When User clicks on stack Try Here Button
    Then User should be redirected to stack Editor's page with Run Button
    When User clicks on Run Button entering stack code "<SheetName>" and <Rownum>
    Then User will be able to see the output on the stack data structure console
  
   Examples:   
    |   SheetName    | Rownum | Concepts       |
    |Input and Output|    0   | Operations in Stack |
    |Input and Output|    1   | Operations in Stack |
    |Input and Output|    2   | Operations in Stack | 
    |Input and Output|    0   | Implementation |
    |Input and Output|    1   | Implementation |
    |Input and Output|    2   | Implementation |  
    |Input and Output|    0   | Applications |
    |Input and Output|    1   | Applications |
    |Input and Output|    2   | Applications |

