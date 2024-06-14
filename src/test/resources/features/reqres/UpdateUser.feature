Feature: Put Update User API
  @Latihan
  Scenario: Update user with valid parameter id and valid json
    Given Update user with parameter id 2 and valid json "update_user.json"
    When Send request put update user
    Then Status code should be 200
    And Response body name should be "Tonaas Kalesaran Edit" and job should be "QA Engineer Edit"
    And Validate json schema "update_user_json_schema.json"
