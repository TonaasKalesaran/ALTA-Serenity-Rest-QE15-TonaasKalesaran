Feature: Create User API
  @Latihan
  Scenario Outline: Create new user with valid json
    Given Create new user with file json "<fileName>"
    When Send request post create user
    Then Status code should be 201
    And Response body name should be "<name>" and job should be "<job>"
    And Validate json schema "create_user_json_schema.json"
  Examples:
    |fileName         |name              |job          |
    |create_user1.json|Tonaas Kalesaran 1|QA Engineer 1|
    |create_user2.json|Tonaas Kalesaran 2|QA Engineer 2|


#Feature: Create user API
#  @Tugas
#  Scenario Outline: Create new user with valid json
#    Given Create new user with file json "<fileName>"
#    When Send request post create user
#    Then Status code should be 201
#    Examples:
#      |fileName|
#      |create_user1.json|
#      |create_user2.json|
#      |create_user3.json|