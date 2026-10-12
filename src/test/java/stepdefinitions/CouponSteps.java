package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CouponsPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class CouponSteps {

	private CouponsPage couponPage;

	@When("user opens Coupons and Promos")
	public void userOpensCouponsAndPromos() {

		couponPage = new CouponsPage(DriverFactory.getDriver());

		couponPage.openCoupons();
	}

	@When("user clicks Create Coupon")
	public void userClicksCreateCoupon() {

		couponPage.clickCreateCoupon();
	}

	@When("user fills mandatory coupon details")
	public void userFillsMandatoryCouponDetails() {

		couponPage.enterCouponCode(ConfigReader.getProperty("couponCode"));

		couponPage.enterDiscountPercentage(ConfigReader.getProperty("couponDiscount"));

	}

	@When("user leaves coupon code blank")
	public void userLeavesCouponCodeBlank() {

		couponPage.enterCouponCode(ConfigReader.getProperty("blankCouponCode"));

		couponPage.enterDiscountPercentage(ConfigReader.getProperty("couponDiscount"));

	}

	@When("user enters an invalid coupon code")
	public void userEntersInvalidCouponCode() {

		couponPage.enterCouponCode(ConfigReader.getProperty("invalidCouponCode"));

		couponPage.enterDiscountPercentage(ConfigReader.getProperty("couponDiscount"));

	}

	@When("user enters zero coupon discount")
	public void userEntersZeroCouponDiscount() {

		couponPage.enterCouponCode(ConfigReader.getProperty("couponCode"));

		couponPage.enterDiscountPercentage(ConfigReader.getProperty("zeroCouponDiscount"));

	}

	@When("user enters coupon discount above one hundred")
	public void userEntersCouponDiscountAboveOneHundred() {

		couponPage.enterCouponCode(ConfigReader.getProperty("couponCode"));

		couponPage.enterDiscountPercentage(ConfigReader.getProperty("excessCouponDiscount"));

	}

	@When("user enters negative coupon discount")
	public void userEntersNegativeCouponDiscount() {

		couponPage.enterCouponCode(ConfigReader.getProperty("couponCode"));

		couponPage.enterDiscountPercentage(ConfigReader.getProperty("negativeCouponDiscount"));

	}

	@When("user enters zero coupon usage limit")
	public void userEntersZeroCouponUsageLimit() {

		couponPage.enterCouponCode(ConfigReader.getProperty("couponCode"));

		couponPage.enterDiscountPercentage(ConfigReader.getProperty("couponDiscount"));

	}

	@When("user submits the coupon for approval")
	public void userSubmitsCouponForApproval() {

		couponPage.submitForApproval();
	}

	@Then("coupon should be submitted for approval")
	public void couponShouldBeSubmittedForApproval() {
		Assert.assertTrue(couponPage.isCouponPending(), "Coupon was not submitted for approval");
	}

	@Then("coupon should not be submitted for approval")
	public void couponShouldNotBeSubmittedForApproval() {

		Assert.assertTrue(couponPage.isCouponFormStillDisplayed(), "Invalid coupon form should remain displayed");
	}

	@When("user edits the configured coupon")
	public void userEditsTheConfiguredCoupon() {

		couponPage.editCoupon(ConfigReader.getProperty("couponCode"), ConfigReader.getProperty("updatedCouponCode"),
				ConfigReader.getProperty("updatedCouponDiscount"));
	}

	@When("user deletes the configured coupon")
	public void userDeletesTheConfiguredCoupon() {

		couponPage.deleteCoupon(ConfigReader.getProperty("updatedCouponCode"));
	}
}