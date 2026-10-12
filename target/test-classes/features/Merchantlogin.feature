Feature: Merchant Institute Login
As an Institute Partner
I want to login into Merchant Studio
So that I can access the institute dashboard
# =========================================================
# POSITIVE LOGIN
# =========================================================

  @login @positive
  Scenario: Successful Institute Partner Login
    Given user opens the Corzaar IMS merchant login page
    When user enters the institute mobile number
    And user enters the institute contact person name
    And user clicks on Send Institute Verification Code
    Then OTP verification page should be displayed
    When user enters the valid OTP
    And user clicks on Verify and Enter Merchant Studio
    Then Merchant Studio dashboard should be displayed
    And Overview menu should be displayed
    And My Institute should be displayed
    And dashboard summary should be displayed
# =========================================================
# NEGATIVE - INVALID MOBILE
# =========================================================

  @login @negative
  Scenario: Login with invalid institute mobile number
    Given user opens the Corzaar IMS merchant login page
    When user enters an invalid institute mobile number
    And user enters the institute contact person name
    And user clicks on Send Institute Verification Code
    Then OTP verification page should not be displayed
# =========================================================
# NEGATIVE - BLANK MOBILE
# =========================================================

  @login @negative
  Scenario: Login with blank institute mobile number
    Given user opens the Corzaar IMS merchant login page
    When user leaves the institute mobile number blank
    And user enters the institute contact person name
    And user clicks on Send Institute Verification Code
    Then OTP verification page should not be displayed
# =========================================================
# NEGATIVE - INVALID CONTACT
# =========================================================

 # @login @negative
  Scenario: Login with invalid contact person name
    Given user opens the Corzaar IMS merchant login page
    When user enters the institute mobile number
    And user enters an invalid institute contact person name
    And user clicks on Send Institute Verification Code
    Then OTP verification page should not be displayed
# =========================================================
# NEGATIVE - BLANK CONTACT
# =========================================================

 # @login @negative
  Scenario: Login with blank contact person name
    Given user opens the Corzaar IMS merchant login page
    When user enters the institute mobile number
    And user leaves the institute contact person name blank
    And user clicks on Send Institute Verification Code
    Then OTP verification page should not be displayed
# =========================================================
# NEGATIVE - INVALID OTP
# =========================================================

  @login @negative
  Scenario: Login with invalid OTP
    Given user opens the Corzaar IMS merchant login page
    When user enters the institute mobile number
    And user enters the institute contact person name
    And user clicks on Send Institute Verification Code
    Then OTP verification page should be displayed
    When user enters an invalid OTP
    And user clicks on Verify and Enter Merchant Studio
    Then Merchant Studio dashboard should not be displayed
# =========================================================
# NEGATIVE - BLANK OTP
# =========================================================

  @login @negative
  Scenario: Login with blank OTP
    Given user opens the Corzaar IMS merchant login page
    When user enters the institute mobile number
    And user enters the institute contact person name
    And user clicks on Send Institute Verification Code
    Then OTP verification page should be displayed
    When user leaves the OTP field blank
    And user clicks on Verify and Enter Merchant Studio
    Then Merchant Studio dashboard should not be displayed
# =========================================================
# NEGATIVE - EXCESS MOBILE
# =========================================================

  @login @negative
  Scenario: Login with excessive length mobile number
    Given user opens the Corzaar IMS merchant login page
    When user enters an excessive length mobile number
    And user enters the institute contact person name
    And user clicks on Send Institute Verification Code
    Then OTP verification page should not be displayed
# =========================================================
# NEGATIVE - EXCESS CONTACT
# =========================================================

 # @login @negative
  Scenario: Login with excessive length contact person name
    Given user opens the Corzaar IMS merchant login page
    When user enters the institute mobile number
    And user enters an excessive length contact person name
    And user clicks on Send Institute Verification Code
    Then OTP verification page should not be displayed

  @logout @positive
  Scenario: Verify merchant Sign out functionality
    When user clicks Sign out
    Then user should be logged out successfully
