Feature: Merchant Certificates and Approvals
# =========================================================
# POSITIVE - PAGE
# =========================================================

  @merchant @certificate @positive
  Scenario: Verify Certificates and Approvals page
    When user opens Certificates and Approvals
    Then Certificates and Approvals page should be displayed
    And Pending Approvals should be displayed
    And Templates Studio should be displayed
# =========================================================
# POSITIVE - CREATE TEMPLATE
# =========================================================

  @merchant @certificate @positive
  Scenario: Create certificate template with valid details
    When user opens Certificates and Approvals
    And user opens Templates Studio
    And user clicks New Template
    And user fills mandatory certificate template details
    And user saves the certificate template
    Then certificate template should be created successfully
# =========================================================
# NEGATIVE - BLANK TEMPLATE NAME
# =========================================================

  @merchant @certificate @negative
  Scenario: Create certificate template without template name
    When user opens Certificates and Approvals
    And user opens Templates Studio
    And user clicks New Template
    And user leaves certificate template name blank
    And user saves the certificate template
    Then certificate template should not be created
# =========================================================
# NEGATIVE - INVALID TEMPLATE NAME
# =========================================================

  @merchant @certificate @negative
  Scenario: Create certificate template with invalid template name
    When user opens Certificates and Approvals
    And user opens Templates Studio
    And user clicks New Template
    And user enters invalid certificate template name
    And user saves the certificate template
    Then certificate template should not be created
# =========================================================
# NEGATIVE - BLANK SIGNATORY
# =========================================================

  @merchant @certificate @negative
  Scenario: Create certificate template without signatory
    When user opens Certificates and Approvals
    And user opens Templates Studio
    And user clicks New Template
    And user leaves certificate signatory blank
    And user saves the certificate template
    Then certificate template should not be created
# =========================================================
# NEGATIVE - INVALID SIGNATORY
# =========================================================

  @merchant @certificate @negative
  Scenario: Create certificate template with invalid signatory
    When user opens Certificates and Approvals
    And user opens Templates Studio
    And user clicks New Template
    And user enters invalid certificate signatory
    And user saves the certificate template
    Then certificate template should not be created
# =========================================================
# POSITIVE - EDIT
# =========================================================

 # @merchant @certificate @positive @edit
  Scenario: Edit configured certificate template
    When user opens Certificates and Approvals
    And user opens Templates Studio
    And user edits the configured certificate template
# =========================================================
# POSITIVE - DELETE
# =========================================================

 # @merchant @certificate @positive @delete
  Scenario: Delete configured certificate template
    When user opens Certificates and Approvals
    And user opens Templates Studio
    And user deletes the configured certificate template
