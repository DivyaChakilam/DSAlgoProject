@TreeScenarios
Feature: Test Case Scenarios for Tree DS
  Background: clicking on Getstarted below Tree DS and land on Tree Page
    Given User logged in and landed on Home Page
    When User Clicks Get Started below Tree DS
    Then User should be redirected to Tree Page
     
    @TreeDSConcepts
  Scenario Outline: clicking on concepts under tree and giving code in try Editor 
    Given User is on Tree page
    When User clicks on "<Concepts>" under tree page
    Then User should be redirected to the clicked link Page 
    When User clicks on Try Here Button
    Then User should be redirected to Editor's page with Run Button
    When User clicks on Run Button entering code "<SheetName>" and <Rownum>
    Then User should be able to see the output on the console
  
   Examples:   
    |   SheetName    | Rownum | Concepts						|
    |Input and Output|    0   | Overview of Trees 	|
    |Input and Output|    1   | Overview of Trees 	|
    |Input and Output|    2   | Overview of Trees 	|  
    |Input and Output|    0   | Terminologies 			|
    |Input and Output|    1   | Terminologies		  	|
    |Input and Output|    2   | Terminologies 			| 
    |Input and Output|    0   | Types of Trees 			|
    |Input and Output|    1   | Types of Trees			|
    |Input and Output|    2   | Types of Trees 			| 
    |Input and Output|    0   | Tree Traversals 		|
    |Input and Output|    1   | Tree Traversals			|
    |Input and Output|    2   | Tree Traversals 		| 
    |Input and Output|    0   | Traversals-Illustration|
    |Input and Output|    1   | Traversals-Illustration|
    |Input and Output|    2   | Traversals-Illustration| 
    |Input and Output|    0   | Binary Trees	 			|
    |Input and Output|    1   | Binary Trees		  	|
    |Input and Output|    2   | Binary Trees	 			| 
    |Input and Output|    0   | Types of Binary Trees|
    |Input and Output|    1   | Types of Binary Trees|
    |Input and Output|    2   | Types of Binary Trees| 
    |Input and Output|    0   | Implementation in Python|
    |Input and Output|    1   | Implementation in Python|
    |Input and Output|    2   | Implementation in Python|                           
    |Input and Output|    0   | Binary Tree Traversals 	|
    |Input and Output|    1   | Binary Tree Traversals	|
    |Input and Output|    2   | Binary Tree Traversals 	| 
    |Input and Output|    0   | Implementation of Binary Trees|
    |Input and Output|    1   | Implementation of Binary Trees|
    |Input and Output|    2   | Implementation of Binary Trees| 
    |Input and Output|    0   | Applications of Binary trees|
    |Input and Output|    1   | Applications of Binary trees|
    |Input and Output|    2   | Applications of Binary trees|  
    |Input and Output|    0   | Binary Search Trees		|
    |Input and Output|    1   | Binary Search Trees		|
    |Input and Output|    2   | Binary Search Trees		| 
    |Input and Output|    0   | Implementation Of BST	|
    |Input and Output|    1   | Implementation Of BST	|
    |Input and Output|    2   | Implementation Of BST	|  
