Feature: Merchant Batch Creation
# =========================================================
# POSITIVE
# =========================================================

  @merchant @batch @positive
  Scenario: Create Cohort Batch using Mandatory Fields
    When user opens Batches and Attendance
    And user clicks Create Cohort Batch
    And user fills mandatory batch details
    And user generates batch sessions
    Then cohort sessions should be generated
# =========================================================
# NEGATIVE - BLANK COORDINATOR
# =========================================================

  @merchant @batch @negative
  Scenario: Create Cohort Batch without coordinator
    When user opens Batches and Attendance
    And user clicks Create Cohort Batch
    And user leaves batch coordinator blank
    And user generates batch sessions
    Then cohort sessions should not be generated
# =========================================================
# NEGATIVE - INVALID START DATE
# =========================================================

  @merchant @batch @negative
  Scenario: Create Cohort Batch with invalid start date
    When user opens Batches and Attendance
    And user clicks Create Cohort Batch
    And user enters an invalid batch start date
    And user generates batch sessions
    Then cohort sessions should not be generated
# =========================================================
# NEGATIVE - INVALID END DATE
# =========================================================

  @merchant @batch @negative
  Scenario: Create Cohort Batch with invalid end date
    When user opens Batches and Attendance
    And user clicks Create Cohort Batch
    And user enters an invalid batch end date
    And user generates batch sessions
    Then cohort sessions should not be generated
# =========================================================
# NEGATIVE - ZERO SEAT CAPACITY
# =========================================================

  @merchant @batch @negative
  Scenario: Create Cohort Batch with zero seat capacity
    When user opens Batches and Attendance
    And user clicks Create Cohort Batch
    And user enters zero batch seat capacity
    And user generates batch sessions
    Then cohort sessions should not be generated
# =========================================================
# NEGATIVE - NEGATIVE SEAT CAPACITY
# =========================================================

  @merchant @batch @negative
  Scenario: Create Cohort Batch with negative seat capacity
    When user opens Batches and Attendance
    And user clicks Create Cohort Batch
    And user enters negative batch seat capacity
    And user generates batch sessions
    Then cohort sessions should not be generated
