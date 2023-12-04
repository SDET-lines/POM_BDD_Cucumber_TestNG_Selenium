Feature: User verifications for OrangeHRM Login page functionality

  Background:
  Given user navigates to OrangeHRM Login Page

  Scenario: User should be able to login to OrangeHRM with valid credentials
    When user enters "Admin" username
    And user enters "admin123" password
    And user clicks on login button
    Then user should be able to verify Dashboard active tab on OrangeHRM Homepage

  Scenario: User shouldn't be able to login to OrangeHRM with missing Username.
            Message "Required" should be displayed under Username field
    When user enters "admin123" password
    And user clicks on login button
    Then user verifies message "Required" under Username field

  Scenario: User shouldn't be able to login to OrangeHRM with missing Password.
            Message "Required" should be displayed under Password field
    When user enters "Admin" username
    And user clicks on login button
    Then user verifies message "Required" under Password field

  Scenario Outline: User should not be able to login to OrangeHRM with invalid credentials
    When user enters "<username>" username
    And user enters "<password>" password
    And user clicks on login button
    Then user verifies "<errorMessage>"

    # this is a data driven testing (Scenario Outline)
    Examples:
      | username  | password | errorMessage        |
      | Admin     | wrongPsw | Invalid credentials |
      | wrongName | admin123 | Invalid credentials |
      | wrongName | wrongPsw | Invalid credentials |
