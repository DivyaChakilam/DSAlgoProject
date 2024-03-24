
@QueueDS
Feature: Testing Queue Module functionality
  Background: clicking on Getstarted below Queue DS and land on Queue Page
    Given User logged in and landed on Home Page
    When User Clicks Get Started below Queue DS
    Then User should be redirected to Queue Page
    
 @QueueConcepts
  Scenario Outline: clicking on concepts under queue and giving code in try Editor 
    Given User is on Queue page
    When User clicks on "<QueueConcepts>" link under Queue page
    Then User should be redirected to  clicked link Page 
    When User clicks on Queue page Try Here Button
    Then User should be redirected to Queue Editor's page with Run Button
    When User clicks on Run Button after entering code "<SheetName>" and <Rownum>
    Then User will be able to see the output on the console
  
   Examples:   
     |   SheetName    | Rownum | QueueConcepts  |
    |Input and Output|    0   | Implementation of Queue in Python|
    |Input and Output|    1   |	Implementation of Queue in Python|
    |Input and Output|   	2   |	Implementation of Queue in Python|
    |Input and Output|    0   | Implementation using collections.deque|
    |Input and Output|    1   |	Implementation using collections.deque|
    |Input and Output|   	2   |	Implementation using collections.deque|
    |Input and Output|    0   | Implementation using array|
    |Input and Output|    1   |	Implementation using array|
    |Input and Output|   	2   |	Implementation using array|
    |Input and Output|    0   | Queue Operations|
    |Input and Output|    1   |	Queue Operations|
    |Input and Output|   	2   |	Queue Operations|