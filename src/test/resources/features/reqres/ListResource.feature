@Tugas
Feature: Get List Resource API
  Scenario Outline: Get list resource with valid parameter page
    Given Get list resource with parameter page <page>
    When Send request get list resource
    Then Status code should be 200
    And Response body page should be <page>
    And Validate json schema "list_resource_json_schema.json"
    Examples:
      |page|
      |1   |
      |2   |

  @Tugas
  Scenario: Get list resource with empty page
    Given Get list resource with parameter page 456
    When Send request get list resource
    Then Status code should be 200
    And Validate json schema "empty_page_json_schema.json"

