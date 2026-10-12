Feature: Merchant Course Authoring
# =========================================================
# POSITIVE - CREATE COURSE
# =========================================================

  @merchant @course @positive
  Scenario: Create Merchant Course using Mandatory Fields
    When user opens Course Studio
    And user clicks Create New Course Program
    And user fills mandatory course details
    And user submits the course
    Then course should be submitted for administrative review
# =========================================================
# NEGATIVE - BLANK COURSE TITLE
# =========================================================

  @merchant @course @negative
  Scenario: Create course without course title
    When user opens Course Studio
    And user clicks Create New Course Program
    And user leaves the course title blank
    And user submits the course
    Then course should not be submitted for administrative review
# =========================================================
# NEGATIVE - INVALID TUITION FEE
# =========================================================

  @merchant @course @negative
  Scenario: Create course with invalid tuition fee
    When user opens Course Studio
    And user clicks Create New Course Program
    And user enters an invalid tuition fee
    And user submits the course
    Then course should not be submitted for administrative review
# =========================================================
# NEGATIVE - INVALID PROGRAM DURATION
# =========================================================

  @merchant @course @negative
  Scenario: Create course with invalid program duration
    When user opens Course Studio
    And user clicks Create New Course Program
    And user enters an invalid program duration
    And user submits the course
    Then course should not be submitted for administrative review
# =========================================================
# NEGATIVE - BLANK OVERVIEW
# =========================================================

  @merchant @course @negative
  Scenario: Create course without course overview
    When user opens Course Studio
    And user clicks Create New Course Program
    And user leaves the course overview blank
    And user submits the course
    Then course should not be submitted for administrative review
# =========================================================
# NEGATIVE - BLANK MODULE
# =========================================================

  @merchant @course @negative
  Scenario: Create course without module title
    When user opens Course Studio
    And user clicks Create New Course Program
    And user leaves the module title blank
    And user submits the course
    Then course should not be submitted for administrative review
# =========================================================
# POSITIVE - EDIT COURSE
# =========================================================

  @merchant @course @positive @edit
  Scenario: Edit existing merchant course
    When user opens Course Studio
    And user edits the configured course
# =========================================================
# POSITIVE - DELETE COURSE
# =========================================================

  @merchant @course @positive @delete
  Scenario: Delete existing merchant course
    When user opens Course Studio
    And user deletes the configured course
