Feature: Merchant Certificates and Approvals

  @merchant @certificate @review
  Scenario: Verify Certificates and Approvals page
    When user opens Certificates and Approvals
    Then Certificates and Approvals page should be displayed
    And Pending Approvals should be displayed
    And Templates Studio should be displayed
    When user clicks Preview for a certificate
    When user clicks Reject for a certificate
    When user clicks Sign and Approve for a certificate
    When user closes the Review tab

  @merchant @certificate @positive
  Scenario: Create certificate template with valid details
    When user opens Certificates and Approvals
    And user opens Templates Studio
    And user clicks New Template
    And user fills mandatory certificate template details
    And user saves the certificate template
    Then certificate template should be created successfully

  @merchant @certificate @negative
  Scenario Outline: Verify negative certificate validations
    When user opens Certificates and Approvals
    And user opens Templates Studio
    When user opens Templates Studio
    When user clicks New Template
    And user enters certificate details for "<TestCase>"
    Then certificate template should not be created

    Examples:
      | TestCase                    |
      | BlankCertificateTemplate    |
      | BlankCertificateSignatory   |
      | InvalidCertificateTemplate  |
      | InvalidCertificateSignatory |
