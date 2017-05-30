@demo
Feature: Update Answers
  Background:
    Given login to application with default user

  Scenario: UpdateAnswer
    Given user is on Dashboard Page
    And set user role as "Investigator"
    And user navigates to "Monitor Input Data"
    And selects study as "NEW CRF"
    And user enters data for subject "autoBOT" and visit "1"
    And User Selects Visit "V1" and Section "SEC1"
    When User enters data in control
      |Question|Answer|ControlType|
      |QQ  |Test QQ |Input        |
    Then data should be saved successfully

  @input
    Scenario: Enter data from Input Sheet.
      Given user is on Dashboard Page
      And set user role as "Investigator"
      When User Enters data from Input Sheet
      Then data should be saved successfully

  @output
  Scenario: Validate data from  Sheet.
    Given user is on Dashboard Page
    And set user role as "Investigator"
    Then data should be validated successfully