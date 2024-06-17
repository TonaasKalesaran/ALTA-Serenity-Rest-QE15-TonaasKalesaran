Feature: Put Update User API
  @Latihan
  Scenario: Update user with valid parameter id and valid json
    Given Update user with parameter id 2 and valid json "update_user.json"
    When Send request put update user
    Then Status code should be 200
    And Response body name should be "Tonaas Kalesaran Edit" and job should be "QA Engineer Edit"
    And Validate json schema "update_user_json_schema.json"

  @Tugas
    #negative test case
  Scenario Outline: Update user with valid parameter id but invalid name data type
    Given Update user with parameter id 2 and invalid json "<dataType>"
    When Send request put update user
    Then Status code should be 400
    Examples:
      |dataType                         |
      |invalid_name_boolean.json        |
      |invalid_name_symbol.json         |
      |invalid_name_integer.json        |