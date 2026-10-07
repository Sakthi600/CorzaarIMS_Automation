Feature: Merchant Institute Login
As an Institute Partner
I want to login into Merchant Studio
So that I can access the institute dashboard

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
