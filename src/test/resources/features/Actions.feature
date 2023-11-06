@regression @sanity
Feature: This functionality validates scenarios for Actions Page

  Scenario: drag and drop actions on DHTML Page
    Given user navigates to DHTML Page
    When user should be able to drag and drop capital to its city
    Then user verifies drag and drop performed successfully

  Scenario: switch to a frame and double click on it
    Given navigate to the jquery website
    When switch to the iframe
    And double click the box
    Then verify the box color is changed

  Scenario: user should be able to verify tooltip JQuery UI Page
    Given user navigates to JQuery UI page
    When user hovers over the tooltip field
    Then user validates tooltip on JQuery UI Page