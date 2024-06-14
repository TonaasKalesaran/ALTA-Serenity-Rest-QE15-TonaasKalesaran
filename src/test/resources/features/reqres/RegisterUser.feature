@Tugas
Feature: Register User API
#  @Tugas
#  Scenario Outline: Register new user with valid json
#    Given Register new user with file json "<fileName>"
#    When Send request post register user
#    Then Status code should be 201
#    And Response body id should be <id> and token should be "<token>"
#    And Validate json schema "register_user_json_schema.json"
#    Examples:
#      |fileName           |id |token            |
#      |register_user1.json|4  |QpwL5tke4Pnpja7X4|
#     #|register_user2.json|5  |QpwL5tke4Pnpja7X4|

  Scenario: Register new user with valid json
    Given Register new user with file json "register_user1.json"
    When Send request post register user
    Then Status code should be 200
    And Response body id should be 4 and token should be "QpwL5tke4Pnpja7X4"
    And Validate json schema "register_user_json_schema.json"

    #negative test
  Scenario: Register new user with missing password
    Given Register user with invalid json "invalid_register_user.json"
    When Send request post register user
    Then Status code should be 400
    And Response body error should be "Missing password"
    And Validate json schema "invalid_register_json_schema.json"
