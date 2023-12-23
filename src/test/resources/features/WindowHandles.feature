@regression
Feature: User handles additional windows

  Background:
    Given user navigates to the window site

  Scenario: user handles a new browser window
    When user clicks on Open New Window button
    And switch to the new window opened
    And fills out "User_first_name", "User_last_name" and choose English language
    And click register button on the new opened page
    Then verify message "Registration is Successful" is present
    When close the window
    And enter the text "a new browser window was handled successfully"
    Then verify the text is present

  Scenario: user handles a new tab in the existing browser window
    When user clicks on Open New Tab button
    And switch to the new tab opened
    When click button to display an alert box
    And handle alert
    Then verify popup box output "You selected alert popup"
    When close the new tab
    And enter the text "a new tab window was handled successfully"
    Then verify the text is present
