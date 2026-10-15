Feature: Merchant Batch Creation

  @merchant @batch @positive
  Scenario: Create Cohort Batch using Mandatory Fields
    When user opens Batches and Attendance
    And user clicks Create Cohort Batch
    And user fills mandatory batch details
    And user generates batch sessions
    Then cohort sessions should be generated

  @merchant @batch @roster
  Scenario: Verify batch creation and Roster Matrix navigation
    When user opens Batches and Attendance
    And user creates a cohort batch
    Then the created batch should be displayed in the batch table
    When user clicks Roster Matrix for the created batch
    Then the Roster Matrix page should be displayed
    When user closes the Roster Matrix
    Then the Roster Matrix should be closed

  @merchant @batch @negative
  Scenario Outline: Verify negative batch validations
    When user opens Batches and Attendance
    And user clicks Create Cohort Batch
    And user tests batch validation for "<TestCase>"
    Then batch validation should be displayed for "<TestCase>"

    Examples:
      | TestCase             |
      | MissingCoordinator   |
      | InvalidStartDate     |
      | InvalidEndDate       |
      | ZeroSeatCapacity     |
      | NegativeSeatCapacity |
