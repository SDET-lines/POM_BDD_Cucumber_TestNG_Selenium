@regression
Feature: user validations for Alert functionality

  Scenario Outline: user should be able to validate Alert on Alert Page
    Given user navigates to Alerts Page
    When user clicks on "<alertType>" on Alerts Page
    Then user should be able to validate "<expectedAlertText>" alert on Alert Page

    # Scenario Outline is a data driven testing
    Examples:
      | alertType    | expectedAlertText                   |
      | regular      | You clicked a button                |
      | timer        | This alert appeared after 5 seconds |
      | confirm      | Do you confirm action?              |
      | prompt       | Please enter your name              |

