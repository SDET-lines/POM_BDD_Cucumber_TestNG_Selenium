@sanity
Feature: This functionality validates scenarios for Actions Page

  Scenario: drag and drop actions on DHTML Page
    Given user navigates to DHTML Page
    When user should be able to drag and drop capital to its country
    Then user verifies drag and drop performed successfully

  Scenario: switch to a frame and double click on it
    Given user navigates to the jquery webpage
    When switch to the iframe
    And double click the block
    Then verify the block color is changed

  Scenario: user should be able to verify tooltip JQuery UI Page
    Given user navigates to JQuery UI page
    When user hovers over the tooltip field
    Then user verifies tooltip on JQuery UI Page

  Scenario: user verifies a possibility of enter a text into the text box on iFrame Page
    Given user navigates to iFrame page
    When user enters 200 symbols of random text into the text box on iFrame Page
    Then user verifies the entered text on iFrames Page

  Scenario: user verifies nested frames functionality
    Given user navigates to the Nested Frames page
    Then user should be able to verify the text "LEFT" in the left frame