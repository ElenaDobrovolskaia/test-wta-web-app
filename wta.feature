@wta
Feature: Smoke testing

  @wta1
  Scenario: Joining WTA
    Given I open "WTA" page
    And  I navigate to "My Backpack" menu
    And I choose a "Sign Up" element in menu
    And fill out required fields except for Captcha
    When I submit the form
    Then  I verify error message appears


  @wta2
  Scenario Outline: Required fields verification
    Given I open "WTA" page
    And  I navigate to "My Backpack" menu
    And I choose a "Sign Up" element in menu
    And I fill out all fields except for "<field>"
    When I submit the form
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
    And  I navigate to "My Backpack" menu
    And I choose a "Sign Up" element in menu
    And fill out required fields except for Captcha
    And I uncheck "<subscription>" checkbox
    When I submit the form
    Then I verify that error message next to "<subscription>" is not present
    Examples:
      |subscription|
      |trailnews |
      |trailaction|


  @wta4
  Scenario Outline:Top menu bar functionality verification
      Given I open "WTA" page
      When  I navigate to "<topBarMenuItem>" menu
      Then I should see the page "<topBarMenuItem>"
    Examples:
      |topBarMenuItem|
      |Our Work      |
      |Go Outside    |
      |Get Involved  |
      |Donate        |


  @wta5
  Scenario: End-to-end searching hike and saving to backpack
    Given I open "WTA" page
    And  I navigate to "My Backpack" menu
    And I choose a "Log In" element in menu
    And I login
    And  I mouse over to "Go Outside" menu
    When I choose a "Hiking Guide" element in menu
    Then I should see the page "Hiking Guide"
    And I type name of desired hike in search field
    When I click search button
    Then I verify search result is contained sought trail
    When I move to trail page
    Then I should see the page "Tolmie Peak Lookout"
    When I save hike to my backpack
    Then I verify that hike was successfully saved


  @wta6
  Scenario: End-to-end searching hike and writing trip report
    Given I open "WTA" page
    And  I navigate to "My Backpack" menu
    And I choose a "Log In" element in menu
    And I login
    And  I mouse over to "My Account" menu
    And I choose a "Write a Trip Report" element in menu
    When I write trip report
    And I verify that trip report was saved successfully








