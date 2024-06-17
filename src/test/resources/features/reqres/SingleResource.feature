@Tugas
Feature: Get Single Resource API
  Scenario Outline: Get single resource with valid parameter id
    Given Get single resource with parameter <id>
    When Send request get single resource
    Then Status code should be 200
    And Response body id should be <id>
    And Validate json schema "single_resource_json_schema.json"
    Examples:
      |id  |
      |1   |
      |2   |

    #negative test
  Scenario: Get single resource with invalid parameter id
    Given Get single resource with parameter 23
    When Send request get single resource
    Then Status code should be 404