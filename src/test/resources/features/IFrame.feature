@r1
Feature: user verifications for Frames functionality

  Scenario: user verifies a possibility of enter a text into the text box on iFrame Page
    Given user navigates to iFrame page
    When user enters 200 symbols of random text into the text box on iFrame Page
    Then user verifies the entered text on iFrames Page

  Scenario: user verifies of nested frames functionality
    Given user navigates to the Nested Frames page
    Then user should be able to verify the text "LEFT" in the left frame