@regression
Feature: Right click button

  Scenario Outline: Right click button and alert handling
    Given user navigates to the given website
    When right clicks on the button
    And click all the "<options>" available in the right click
    Then switch to "<expectedAlert>" and verify it

    # Scenario Outline is a data driven testing ()
    Examples:
      | options      | expectedAlert  |
      | Edit         | clicked: edit  |
      | Cut          | clicked: cut   |
      | Copy         | clicked: copy  |
      | Paste        | clicked: paste |
      | Delete       | clicked: delete|
      | Quit         | clicked: quit  |