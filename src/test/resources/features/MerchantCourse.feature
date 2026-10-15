Feature: Merchant Course Authoring

  @merchant @course @positive
  Scenario: Create a course with module from the create screen
    When user opens Course Studio
    And user clicks Create New Course Program
    And user fills mandatory course details
    And user clicks Add Module
    And user fills mandatory module details
    Then an additional module section should be displayed
    When user submits the course
    Then course should be submitted for administrative review

  @merchant @course @negative
  Scenario Outline: Verify negative course validations
    When user opens Course Studio
    And user clicks Create New Course Program
    And user tests course validation for "<TestCase>"
    Then validation should be displayed for "<TestCase>"
    And user clicks Add Module
    Then an additional module section should be displayed
    When user clicks the close button on the course program modal
    Then the course program modal should be closed

    Examples:
      | TestCase           |
      | MissingTitle       |
      | MissingTuitionFee  |
      | MissingDuration    |
      | MissingOverview    |
      | MissingModuleTitle |

  @merchant @course @update
 Scenario: Update all course fields
  When user opens Course Studio
  And user clicks Edit for the course "Test Course"
  And user edits all course fields
  And user saves the course changes
  Then the updated course should be displayed in the course table

@merchant @course @delete
Scenario: Delete existing merchant course
  When user opens Course Studio
  And user deletes the course "Selenium Automation Testing"
  Then the deleted course should not be displayed in the course table
