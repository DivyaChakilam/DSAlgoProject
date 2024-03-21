Feature: Test Case Scenarios for Graph DS
  Background: clicking on Getstarted below Grpah DS and land on Graph Page
    Given User logged in and landed on Home Page
    When User Clicks Get Started below Graph DS
    Then User should be redirected to Graph Page
     
    @GraphDS
  Scenario Outline: Clicking on concepts under Graph and giving code in try Editor 
    Given User is on Graph page
    When User clicks on "<Concepts>" under Grpah page
    Then User should be redirected to the clicked Graph link Page 
    When User clicks on graph Try Here Button
    Then User should be redirected to graph Editor's page with Run Button
    When User clicks on Run Button for graph entering code "<SheetName>" and <Rownum>
    Then User should be able to see the output on the graph console
  
   Examples:   
    |   SheetName    | Rownum |         Concepts				    |
    |Input and Output|    0   | 					Graph 	          |
    |Input and Output|    1   | 					Graph 	          |
    |Input and Output|    2   | 					Graph 	          |  
    |Input and Output|    0   | Graph Representations 			|
    |Input and Output|    1   | Graph Representations		  	|
    |Input and Output|    2   | Graph Representations 			| 
   