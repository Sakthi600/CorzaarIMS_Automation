package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CouponsPage;
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

		String couponCode = "AUTO20";

		String discount = "20";

		couponPage.enterCouponCode(couponCode);

		couponPage.enterDiscountPercentage(discount);

	}

	@When("user submits coupon for approval")
	public void userSubmitsCouponForApproval() {

		couponPage.submitForApproval();
	}

	@Then("coupon should be submitted for approval")
	public void couponShouldBeSubmittedForApproval() {

		Assert.assertTrue(couponPage.isCouponPending(), "Coupon was not submitted in Pending status");
	}
}
