Feature: Right click button list alerts verifications

  Scenario Outline: Right click button and alerts handling
    Given user navigates to the given website
    When right clicks on the button
    And click the "<option>" from the list
    Then the alert should display the text "<expectedAlert>"

    # Scenario Outline is a data driven testing
    Examples:
      | option       | expectedAlert  |
      | Edit         | clicked: edit  |
      | Cut          | clicked: cut   |
      | Copy         | clicked: copy  |
      | Paste        | clicked: paste |
      | Delete       | clicked: delete|
      | Quit         | clicked: quit  |