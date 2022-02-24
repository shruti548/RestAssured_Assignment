Feature: Validate RestAssured with Negative Scenario

  Scenario: RestAssured Script for Negative Scenario and log it on console
  
    Given user provides API
    When posted with correct Information
    Then validate positive response code received