Feature: Merchant Institute Login
As an Institute Partner
I want to login into Merchant Studio
So that I can access the institute dashboard


 @merchant @login @positive
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

 @merchant @login @negative
  Scenario Outline: Validate negative login and OTP cases
    Given user opens the Corzaar IMS merchant login page
    When user executes login negative case "<testType>" using mobile key "<mobileKey>" and OTP key "<otpKey>"
    Then login negative case "<testType>" should be validated

    Examples:
      | testType      | mobileKey       | otpKey      |
      | blank_mobile  | blankMobile     |             |
      | alphabet      | alphabetMobile  |             |
      | special_char  | specialMobile   |             |
      | short_mobile  | shortMobile     |             |
      | long_mobile   | longMobile      |             |
      | alphabet_otp  | instituteMobile | alphabetOtp |
      | invalid_otp   | instituteMobile | invalidOtp  |
      | change_mobile | instituteMobile |             |
