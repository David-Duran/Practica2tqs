Feature: Tests a page using Selenium WebDriver
  In order to evaluate Selenium Framework
  As a developer
  I want to interact with my web

  Scenario: My website can be browsed
    When I go to the home page
    Then I should see a "Oubiti" button

  Scenario: My website has a "About Me" section
    Given I go to the home page
    When I click on "Oubiti" button
    Then I should see a "About Me" text
    And I take a screenshot with filename "About Me"
