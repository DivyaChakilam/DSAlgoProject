
@loginscenarios
Feature: Login Page Test Case Scenarios
Background:
    Given User landed on Login Page
    
@loginInvalid
Scenario Outline: Validating Login process for User with invalid data
    When User clicks on Login button with entering invalid data sheet "<SheetName>" and row <Rownumber>
    Then User should get error validation message 

 Examples: 

      | SheetName | Rownumber | 
      | Sheet1    |     0     |
      | Sheet1    |     1     |
      | Sheet1    |     2     |
      | Sheet1    |     3     |
      | Sheet1    |     4     |
      
@loginEmpty
Scenario: Validating Login process with all empty fields
    When User clicks on Login button with entering empty fields
    Then User should get error validation message for emptyfields     

@validlogin
Scenario Outline: Validating Login Page with valid data
    When User clicks on Login button with entering valid data sheet "<SheetName>" and row <Rownumber>
    Then User should land on home page 

 Examples: 
      | SheetName | Rownumber | 
      | Sheet1    |     5     |
      

  
		
