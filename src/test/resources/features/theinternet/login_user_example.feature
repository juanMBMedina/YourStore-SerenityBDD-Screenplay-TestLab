@example
Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given the user opens the login page
    When the user logs in with username "tomsmith" and password "SuperSecretPassword!"
    Then the user should see the secure area
