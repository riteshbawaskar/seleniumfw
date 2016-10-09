@ignore
Feature: SelectRole
  Background:
    Given login to application with default user

  Scenario Outline: SelectRole
    Given user is on Dashboard Page
    When changes role as "<Role>"
    Then role should be changed successfully as "<Role>"
    Examples:
      |Role          |
      | Admin        |
      | Monitor      |
      | Sponsor      |
      | Investigator |

 # Scenario Outline: Check Access for Roles
  #  Given user is on Dashboard Page
   # When changes role as "<Role>"
   # Then role should be changed successfully as "<Role>"
   # And user can create study
   # Examples:
   #   |Role          | CreateStudy| AddStudyLogs| StudyDesign| MonitorData | AddUser | QueryList |
   #   | Admin        | Y         | Y            |Y           |Y            |Y        |Y          |
   #   | Monitor      |N      | Y            |Y           |Y            |Y        |Y          |
   #   | Sponsor      |N         | Y            |Y           |Y            |Y        |Y          |
   #   | Investigator |N       | Y            |Y           |Y            |Y        |Y          |
