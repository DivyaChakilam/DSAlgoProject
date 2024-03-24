@LinkedList
Feature: Test Case Scenarios for LinkedList
Background: clicking on Getstarted below LinkedList and land on LinkedList Page
    Given User has logged in and landed on Home Page
    When User Clicks Get Started below LinkedList Page
    Then User should be redirected to LinkedList Page
     
  @concepts
  Scenario Outline: Clicking on Concepts under LinkedList and giving code in Try Editor
    Given User is on the LinkedList Page
    When User clicks on "<Concepts>" under LinkedList Page
    Then User should be redirected to the clicked Linked List link Page   
    When User clicks on Linked List Try Here Button
    Then User should be redirected to Linked List Editor's page with Run Button  
    When User clicks on Run Button entering Linked List code "<SheetName>" and <RowNum>
    Then User will be able to see the output on the Linked List console
    
    Examples:
    |   SheetName        | RowNum | Concepts                        |
    |   Input and Output |  0     | Creating Linked LIst            |
    |   Input and Output |  1     | Creating Linked LIst            |
    |   Input and Output |  2     | Creating Linked LIst            |
    |   Input and Output |  0     | Types of Linked List		        |
    |   Input and Output |  1     | Types of Linked List	          |
    |   Input and Output |  2     | Types of Linked List            |
    |   Input and Output |  0     | Implement Linked List in Python |		
    |		Input and Output |  1     | Implement Linked List in Python |	
    |   Input and Output |  2     | Implement Linked List in Python | 		 
    |		Input and Output |  0     | Traversal                       |
    |		Input and Output |  1     | Traversal                       |
    |		Input and Output |  2     | Traversal                       |
    |		Input and Output |  0     | Insertion                       |
    |		Input and Output |  1     | Insertion	                      | 	
    |		Input and Output |  2     | Insertion	                      |  			
    |		Input and Output |  0     | Deletion                        |
    |   Input and Output |  1     | Deletion                        |
    |   Input and Output |  2     | Deletion                        |
    

