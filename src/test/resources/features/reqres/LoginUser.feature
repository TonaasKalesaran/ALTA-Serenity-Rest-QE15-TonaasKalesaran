@Tugas
Feature: Post Login User API
  Scenario: Login user with valid json
    Given Login user with valid json "login_user.json"
    When Send request post login user
    Then Status code should be 200
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And Validate json schema "login_user_json_schema.json"

  #Negative test
  Scenario: Login user without password
    Given Login user with invalid json "invalid_login_user.json"
    When Send request post login user
    Then Status code should be 400
    And Response body error should be "Missing password"
    And Validate json schema "invalid_login_json_schema.json"