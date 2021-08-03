@wta
Feature: Smoke testing

  @wta1
  Scenario: Joining WTA
    Given I open "WTA" page
    Then  I navigate to "My Backpack" menu
    Then I choose a "Sign Up" element in menu
    When fill out required fields except for Captcha
    Then I submit the form
    Then  I verify error message appears

  @wta2
  Scenario Outline: Required fields verification
    Given I open "WTA" page
    Then  I navigate to "My Backpack" menu
    Then I choose a "Sign Up" element in menu
    Then I fill out all fields except for "<field>"
    And I submit the form
    Then I verify that appeared error message next to "<field>" field is equal to "<errorMessage>"
    Examples:
      |field                 |errorMessage              |
      |fullname              |Required input is missing.|
      |first_name            |Required input is missing.|
      |last_name             |Required input is missing.|
      |email                 |Required input is missing.|
      |postal_code           |Required input is missing.|

  @wta3
  Scenario Outline: Verification non-required fields
    Given I open "WTA" page
    Then  I navigate to "My Backpack" menu
    Then I choose a "Sign Up" element in menu
    When fill out required fields except for Captcha
    Then I uncheck "<subscription>" checkbox
    Then I submit the form
    Then I verify that error message next to "<subscription>" is not present
    Examples:
      |subscription|
      |trailnews |
      |trailaction|







