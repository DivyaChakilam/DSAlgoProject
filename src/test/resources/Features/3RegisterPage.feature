@RegisterScenarios
Feature: Register Page Test Scenarios
Background:
    Given User landed on Register Page

  
    @RegWithEmptyFields
    Scenario Outline: Register with empty fields
    Given User leaves all fields empty
    When User clicks RegisterButton 
    Then It should display an error <Validation> below Username textbox
		Examples:
    | Validation |
    | Please fill out this field.|
    
   @RegWithOnlyUsername  
    Scenario Outline: Register with only username field
    Given User gives only <username> field
    When User clicks RegisterButton 
    Then It should display an error <Validation> below password textbox
     Examples:
    | username | Validation |
    | abc@gmail.com | Please fill out this field.|
    
    @RegWithoutCinfirmPassword  
    Scenario Outline: Register without confirm password field
    Given User gives <username> and <password> without confirm password field
    When User clicks RegisterButton 
    Then It should display an error <Validation> below confirm password textbox
     Examples:
    | username | password | Validation |
    | abc@gmail.com | abc123* | Please fill out this field.|
     
    @InvalidUserName 
    Scenario Outline: Register with space and * in username field
    Given User gives invalid <username> and <password> and <confirmpassword>
    When User clicks RegisterButton 
    Then It is not showing valid error messages for invalid inputs
     Examples:
    | username         | password | confirmpassword |
    | abc * @gmail.com | abc123* | abc123*           | 
    
    @Invlidpassword
    Scenario Outline: Register with invalid password fields with all numbers and lessthan 8 characters
    Given User gives invalid <username> and <password> and <confirmpassword>
    When User clicks RegisterButton 
    Then It is not showing valid error messages for invalid inputs
     Examples:
    | username         | password | confirmpassword |
    | abc@gmail.com | abc123* | abc123*           | 
    | abc@gmail.com | 123453455 | 123453455       |
    
    @PasswordMismatch
    Scenario Outline: Register with passwords mismatch
    Given User gives invalid <username> and <password> and <confirmpassword>
    When User clicks RegisterButton 
    Then User should see password mismatch error message <Message>
     Examples:
    | username         | password | confirmpassword | Message|
    | abc@gmail.com | abc123* | abc123*@1          | password_mismatch:The two password fields didn’t match.|
    
    
    @ExistingCredentials
    Scenario Outline: Register with existing username and password
    Given User gives valid credentials <username> and <password> and <confirmpassword>
    When User clicks RegisterButton 
    Then It is giving irrelavant error message with password mismatch 
    
     Examples:
    | username                    | password        | confirmpassword | 
    | qualityinnovators@gmail.com | Happycoding@123 | Happycoding@123 | 
    
    