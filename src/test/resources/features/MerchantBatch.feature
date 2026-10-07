Feature: Merchant Batch Creation

  @merchant @batch
  Scenario: Create Cohort Batch using Mandatory Fields
    When user opens Batches and Attendance
    And user clicks Create Cohort Batch
    And user fills mandatory batch details
    And user generates batch sessions
    Then cohort sessions should be generated
