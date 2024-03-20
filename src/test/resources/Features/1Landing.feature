
Feature: Landing on dsalgoportal
  
  @GetStarted
  Scenario Outline:  Land on algoportal and click GetStarted
    Given user opened a browser and landed on dsalgo portal 
    When  user clicks on GetStarted button
    Then  user should land on dsalgo introduction page with register and signin links
    
 