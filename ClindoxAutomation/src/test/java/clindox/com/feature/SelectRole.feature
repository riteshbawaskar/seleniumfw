Feature: SelectRole
  Background:
    Given login to application with default user

  Scenario Outline: SelectRole
    Given user is on Dashboard Page
    When changes role as "<Role>"
    Then role should be changed successfully as "<Role>"
    Examples:
      |Role|
      | Admin   |
