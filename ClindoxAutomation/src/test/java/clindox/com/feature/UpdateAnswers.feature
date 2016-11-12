@demo
Feature: Update Answers
  Background:
    Given login to application with default user

  Scenario: UpdateAnswer
    Given user is on Dashboard Page
    And set user role as "Investigator"
    And user navigates to "Monitor Input Data"
    And selects study as "eCRF (New)"
    And user enters data for subject "01-012" and visit "1"
    And User Selects Visit "Visit 1 Checklist: Initial Baseline Assessment" and Section "Visit 1: Conducting the Study Visit"
    When User enters data in control
      |Question|Answer|ControlType|
      |Test 1  |Answer 1 |Input      |
      |Test 2  |Answer 2 |TextArea   |
      |Test 3  | 2       |Select     |
      |Test 4  | 3       |Option     |
      |Test 5  |2,3,4    |Checkbox   |
      |Test 6  |08/10/2016    |Input   |
      |Test 7  |8:04 pm   |Input   |
      |Test 8  |08/10/2016 9:04:23 pm    |Input   |
      |Test 9  |2    |Slider     |
    Then data should be saved successfully

  @input
    Scenario: Enter data from Input Sheet.
      Given user is on Dashboard Page
      And set user role as "Investigator"
      When User Enters data from Input Sheet
      Then data should be saved successfully