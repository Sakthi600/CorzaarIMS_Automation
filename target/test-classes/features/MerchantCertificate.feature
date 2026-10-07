Feature: Certificates and Approvals

  @merchant @certificate
  Scenario: Verify Certificates and Approvals page
    When user opens Certificates and Approvals
    Then Certificates and Approvals page should be displayed
    And Pending Approvals should be displayed
    And Templates Studio should be displayed
    And Learner and Program section should be displayed
    And certificate table headers should be displayed
    And no pending certificate approval message should be displayed
@merchant @templates
  Scenario: Create a new certificate template
    When user opens Certificates and Approvals
    And user clicks Templates Studio
    And user clicks New Template
    And user enters certificate template name "Automation Certificate"
    And user selects branding accent color
    And user enters signatory title and name "Academic Director"
    And user clicks Save Template
    Then certificate template should be created successfully
