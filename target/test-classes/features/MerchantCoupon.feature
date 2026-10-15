Feature: Merchant Coupon Creation

  @merchant @coupon @positive
  Scenario: Create coupon with valid details
    When user opens Coupons and Promos
    And user clicks Create Coupon
    And user fills mandatory coupon details
    And user submits the coupon for approval
    Then coupon should be submitted for approval

  @merchant @coupon @negative
  Scenario Outline: Validate coupon with invalid details
    When user opens Coupons and Promos
    And user clicks Create Coupon
    And user enters invalid coupon details for "<testCase>"
    And user submits the coupon for approval
    Then coupon should not be submitted for approval

    Examples:
      | testCase               |
      | BlankCouponCode        |
      | InvalidCouponCode      |
      | ZeroCouponDiscount     |
      | CouponDiscountAbove100 |
      | NegativeCouponDiscount |
      | ZeroCouponUsageLimit   |
