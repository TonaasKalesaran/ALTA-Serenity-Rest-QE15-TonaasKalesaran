Feature: Get List Users API
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    #Given Get list users with parameter page <page>
    #kalau pake string jadi "<page>"
    Given Get list users with parameter page <page>
    When Send request get list users
    Then Status code should be 200
    And Response body page should be <page>
    And Validate json schema "list_users_json_schema.json"
  Examples:
    |page|
    |1   |
    |2   |

  @Tugas
  Scenario: Get list users with empty page
    Given Get list users with parameter page 234
    When Send request get list users
    Then Status code should be 200
    And Validate json schema "empty_page_json_schema.json"

  @Tugas
  Scenario: Get list users with invalid parameter page string
    Given Get list users with invalid parameter page "@#$@#"
    When Send request get list users
    Then Status code should be 400


  #Scenario Outline: Get list users with valid parameter page
    #Given Get list users with parameter page <page>
    #When Send request get list users
    #Then Status code should be 400
    #Examples:
    #  |page|
    #  |@#%@#$@ |
    #  |as@11A  |