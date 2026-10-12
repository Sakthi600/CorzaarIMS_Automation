Feature: Merchant Coupons and Promos
# =========================================================
# POSITIVE
# =========================================================

  @merchant @coupon @positive
  Scenario: Create coupon using mandatory details
    When user opens Coupons and Promos
    And user clicks Create Coupon
    And user fills mandatory coupon details
    And user submits the coupon for approval
    Then coupon should be submitted for approval
# =========================================================
# NEGATIVE - BLANK CODE
# =========================================================

  @merchant @coupon @negative
  Scenario: Create coupon without coupon code
    When user opens Coupons and Promos
    And user clicks Create Coupon
    And user leaves coupon code blank
    And user submits the coupon for approval
    Then coupon should not be submitted for approval
# =========================================================
# NEGATIVE - INVALID CODE
# =========================================================

  @merchant @coupon @negative
  Scenario: Create coupon with invalid coupon code
    When user opens Coupons and Promos
    And user clicks Create Coupon
    And user enters an invalid coupon code
    And user submits the coupon for approval
    Then coupon should not be submitted for approval
# =========================================================
# NEGATIVE - ZERO DISCOUNT
# =========================================================

  @merchant @coupon @negative
  Scenario: Create coupon with zero discount
    When user opens Coupons and Promos
    And user clicks Create Coupon
    And user enters zero coupon discount
    And user submits the coupon for approval
    Then coupon should not be submitted for approval
# =========================================================
# NEGATIVE - ABOVE 100 DISCOUNT
# =========================================================

  @merchant @coupon @negative
  Scenario: Create coupon with discount above one hundred
    When user opens Coupons and Promos
    And user clicks Create Coupon
    And user enters coupon discount above one hundred
    And user submits the coupon for approval
    Then coupon should not be submitted for approval
# =========================================================
# NEGATIVE - NEGATIVE DISCOUNT
# =========================================================

  @merchant @coupon @negative
  Scenario: Create coupon with negative discount
    When user opens Coupons and Promos
    And user clicks Create Coupon
    And user enters negative coupon discount
    And user submits the coupon for approval
    Then coupon should not be submitted for approval
# =========================================================
# NEGATIVE - ZERO USAGE LIMIT
# =========================================================

  @merchant @coupon @negative
  Scenario: Create coupon with zero usage limit
    When user opens Coupons and Promos
    And user clicks Create Coupon
    And user enters zero coupon usage limit
    And user submits the coupon for approval
    Then coupon should not be submitted for approval
# =========================================================
# POSITIVE - EDIT
# =========================================================
# @merchant @coupon @positive @edit

  Scenario: Edit configured coupon
    When user opens Coupons and Promos
    And user edits the configured coupon
# =========================================================
# POSITIVE - DELETE
# =========================================================
# @merchant @coupon @positive @delete

  Scenario: Delete configured coupon
    When user opens Coupons and Promos
    And user deletes the configured coupon
