Feature: Validation of RestAssured Script for Negative Scenario

  Scenario: Validate response status code for Negative Scenario using Assertion
    Given user provides API
    When posted with correct Information
    Then validate response status code received