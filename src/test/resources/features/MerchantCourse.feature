Feature: Merchant Course Authoring

  @merchant @course
  Scenario: Create Merchant Course using Mandatory Fields
    When user opens Course Studio
    And user clicks Create New Course Program
    And user fills mandatory course details
    And user submits the course
    Then course should be submitted for administrative review

  @merchant @course @edit
  Scenario: Edit existing merchant course
    When user opens Course Studio
    And user edits the course "Selenium Automation Testing" to "Selenium Automation Testing Updated"

  @merchant @course @delete
  Scenario: Delete existing merchant course
    When user opens Course Studio
    And user deletes the course "Selenium Automation Testing"
