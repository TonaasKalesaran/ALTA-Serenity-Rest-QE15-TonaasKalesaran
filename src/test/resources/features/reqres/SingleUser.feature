@Tugas
Feature: Get Single Users API
  Scenario Outline: Get single user with valid parameter id
    Given Get single user with parameter <id>
    When Send request get single user
    Then Status code should be 200
    And Response body id should be <id>
    And Validate json schema "single_user_json_schema.json"
    Examples:
      |id  |
      |1   |
      |2   |

    #negative test
  Scenario: Get single user with invalid parameter id
    Given Get single user with parameter 23
    When Send request get single user
    Then Status code should be 404
