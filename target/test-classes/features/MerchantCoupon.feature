Feature: Merchant Coupon Creation

  @merchant @coupon
  Scenario: Create Promotional Coupon using Mandatory Fields
    When user opens Coupons and Promos
    And user clicks Create Coupon
    And user fills mandatory coupon details
    And user submits coupon for approval
    Then coupon should be submitted for approval
