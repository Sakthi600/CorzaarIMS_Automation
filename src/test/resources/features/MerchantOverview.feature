Feature: Merchant Studio Overview Dashboard Validation

  @merchant @overview
  Scenario: Validate logged-in institute and all Overview values
    Given user is logged into Merchant Studio Overview
    Then Overview dashboard should be displayed
    And Total Revenue value should be displayed
    And Confirmed Paid Learners count should be 2
    And Published Courses count should be 3
    And Courses In Review count should be 0
    And Cohort Batches with Attendance Tracking count should be 25
    And My Institute status should be Rejected
    And Accreditation status should be Pending
    And logged-in institute should match expected institute
    And Create Course button should be displayed
    And Add Batch button should be displayed
    And Create Course button should navigate to Course Studio page
    When user returns to Overview page
    And Add Batch button should navigate to Batches Attendance page
