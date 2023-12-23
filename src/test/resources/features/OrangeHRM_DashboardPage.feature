Feature: user validations for OrangeHRM Dashboard Page functionality

  Background:
    Given user logs in to OrangeHRM

  Scenario: User should be able to validate main tabs on OrangeHRM Homepage via ListOfMaps
    Then user validates main tabs on Dashboard Page via ListOfMaps
      | TabName     |
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Claim       |
      | Buzz        |

  Scenario: User should be able to verify main tabs on Dashboard Page via ListOfData
    Then user validates main tabs on Dashboard Page via ListOfData
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Claim       |
      | Buzz        |