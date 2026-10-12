package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MerchantDashboardPage;
import pages.OtpPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginSteps {

	private LoginPage loginPage;
	private OtpPage otpPage;
	private MerchantDashboardPage dashboardPage;

	@Given("user opens the Corzaar IMS merchant login page")
	public void userOpensMerchantLoginPage() {

		loginPage = new LoginPage(DriverFactory.getDriver());
		DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));

	}

	@When("user enters the institute mobile number")
	public void userEntersInstituteMobileNumber() {

		loginPage.enterMobileNumber(ConfigReader.getProperty("instituteMobile"));
	}

	@When("user enters an invalid institute mobile number")
	public void userEntersInvalidInstituteMobileNumber() {

		loginPage.enterMobileNumber(ConfigReader.getProperty("invalidInstituteMobile"));
	}

	@When("user leaves the institute mobile number blank")
	public void userLeavesInstituteMobileNumberBlank() {

		loginPage.enterMobileNumber(ConfigReader.getProperty("blankInstituteMobile"));
	}

	@When("user enters an excessive length mobile number")
	public void userEntersExcessiveLengthMobileNumber() {

		loginPage.enterMobileNumber(ConfigReader.getProperty("excessMobile"));
	}

	@When("user enters the institute contact person name")
	public void userEntersInstituteContactPersonName() {

		loginPage.enterContactPerson(ConfigReader.getProperty("instituteContact"));
	}

	@When("user enters an invalid institute contact person name")
	public void userEntersInvalidInstituteContactPersonName() {

		loginPage.enterContactPerson(ConfigReader.getProperty("invalidInstituteContact"));
	}

	@When("user leaves the institute contact person name blank")
	public void userLeavesInstituteContactPersonNameBlank() {

		loginPage.enterContactPerson(ConfigReader.getProperty("blankInstituteContact"));
	}

	@When("user enters an excessive length contact person name")
	public void userEntersExcessiveLengthContactPersonName() {

		loginPage.enterContactPerson(ConfigReader.getProperty("excessContact"));
	}

	@When("user clicks on Send Institute Verification Code")
	public void userClicksSendInstituteVerificationCode() {

		loginPage.clickSendVerificationCode();

		otpPage = new OtpPage(DriverFactory.getDriver());
	}

	@Then("OTP verification page should be displayed")
	public void otpVerificationPageShouldBeDisplayed() {

		Assert.assertTrue(otpPage.isOtpVerificationPageDisplayed(), "OTP verification page was not displayed");
	}

	@Then("OTP verification page should not be displayed")
	public void otpVerificationPageShouldNotBeDisplayed() {

		Assert.assertFalse(otpPage.isOtpVerificationPageDisplayed(),
				"OTP verification page was displayed for invalid login data");
	}

	@When("user enters the valid OTP")
	public void userEntersValidOtp() {

		otpPage.enterOtp(ConfigReader.getProperty("otp"));
	}

	@When("user enters an invalid OTP")
	public void userEntersInvalidOtp() {

		otpPage.enterOtp(ConfigReader.getProperty("invalidOtp"));
	}

	@When("user leaves the OTP field blank")
	public void userLeavesOtpFieldBlank() {

		otpPage.enterOtp(ConfigReader.getProperty("blankOtp"));
	}

	@When("user clicks on Verify and Enter Merchant Studio")
	public void userClicksVerifyAndEnterMerchantStudio() {

		otpPage.clickVerify();

		dashboardPage = new MerchantDashboardPage(DriverFactory.getDriver());
	}

	@Then("Merchant Studio dashboard should be displayed")
	public void merchantStudioDashboardShouldBeDisplayed() {

		Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Merchant Studio Dashboard was not displayed");
	}

	@Then("Merchant Studio dashboard should not be displayed")
	public void merchantStudioDashboardShouldNotBeDisplayed() {

		Assert.assertFalse(dashboardPage.isDashboardDisplayed(),
				"Merchant Studio Dashboard was displayed for invalid OTP");
	}

	@Then("Overview menu should be displayed")
	public void overviewMenuShouldBeDisplayed() {

		Assert.assertTrue(dashboardPage.isOverviewDisplayed(), "Overview menu is not displayed");
	}

	@Then("My Institute should be displayed")
	public void myInstituteShouldBeDisplayed() {

		Assert.assertTrue(dashboardPage.isMyInstituteDisplayed(), "My Institute is not displayed");
	}

	@Then("dashboard summary should be displayed")
	public void dashboardSummaryShouldBeDisplayed() {

		Assert.assertTrue(dashboardPage.isDashboardDataDisplayed(), "Dashboard summary is not displayed");
	}

	@When("user clicks Sign out")
	public void userClicksSignOut() {

		loginPage = new LoginPage(DriverFactory.getDriver());
		loginPage.clickSignOut();
	}

	@Then("user should be logged out successfully")
	public void userShouldBeLoggedOutSuccessfully() {
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"),
				"User was not redirected to Login page after Sign out");
	}

}