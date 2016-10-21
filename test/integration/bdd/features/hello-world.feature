Feature: Say Hello

  Scenario: Check Hello World
    Given that I am on the main site
    When the index page is display
    Then I should see "hello world"
