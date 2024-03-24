
@Array
Feature: Testing Array Module functionality
	   
 Background: 
   	Given User logged in and is on DSHome Page
    When The User Clicks Get Started below ArrayDS
    Then The User should be redirected to Array Page
    
    @ArraysConcepts
  Scenario Outline: testing Arrays Functionality
    Given The User is on Array page
    When The User clicks on "<ArraysConcepts>" Link
    Then The User should be redirected to clicked Page 
    When The User clicks on TryHere button
    Then The User should be redirected to Editor's Page with Run button
    When The User clicks on Run Button after entering Array code "<SheetName>" and <Rownum>
    Then The User should be able to see the output in the console
 
   Examples:   
    |   SheetName    | Rownum | ArraysConcepts  |
    |Input and Output|    0   | Arrays in Python|
    |Input and Output|    1   |	Arrays in Python|
    |Input and Output|   	2   |	Arrays in Python|
    |Input and Output|    0   | Arrays Using List|
    |Input and Output|    1   |	Arrays Using List|
    |Input and Output|   	2   |	Arrays Using List|
    |Input and Output|    0   | Basic Operations in Lists|
    |Input and Output|    1   |	Basic Operations in Lists|
    |Input and Output|   	2   |	Basic Operations in Lists|
    |Input and Output|    0   | Applications of Array|
    |Input and Output|    1   |	Applications of Array|
    |Input and Output|   	2   |	Applications of Array|
   
    @PracticeQuestion
    Scenario Outline: testing on Array practice Questions
     Given The User is on Array page
     When The User clicks on Arrays in Python Link
     Then The User should be redirected to Arrays in Python Page 
     When The User clicks on PracticeQuestion Link
     Then The User should be redirected to Practice question Page
     When The User clicks on "<PracticeQuestionList>" Page
     Then The User should be redirected to clicked Question Page with Run and Submit Button
     When The User clicks on Run after entering Array Prac code "<SheetName>" and <Rownum>
     Then The User should see Run output in the console
     When The User clicks on Submit Button after entering Array Prac code "<SheetName>" and <Rownum>
     Then The User should see Submit output in the console
     
   Examples:   
    |SheetName| Rownum | PracticeQuestionList  |
    | Sheet1 |    0   | Search the array|
    | Sheet1 |    1   | Search the array|
    | Sheet1 |    2   | Search the array|
    | Sheet1 |    0   | Max Consecutive Ones|
    | Sheet1 |    1   | Max Consecutive Ones|
    | Sheet1 |    2   | Max Consecutive Ones|
    | Sheet1 |    0   | Find Numbers with Even Number of Digits|
    | Sheet1 |    1   | Find Numbers with Even Number of Digits|
    | Sheet1 |    2   | Find Numbers with Even Number of Digits|
    | Sheet1 |    3   | Squares of  a Sorted Array|
    | Sheet1 |    4   | Squares of  a Sorted Array|
    | Sheet1 |    5   | Squares of  a Sorted Array|
  
     
     