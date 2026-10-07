package stepdefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MerchantDashboardPage;
import pages.OtpPage;
import utils.ConfigReader;

public class LoginSteps extends BaseClass {

	private LoginPage loginPage;
	private OtpPage otpPage;
	private MerchantDashboardPage dashboardPage;

	@Given("user opens the Corzaar IMS merchant login page")
	public void user_opens_merchant_login_page() {

		initialize();

		navigateToApplication(ConfigReader.getProperty("baseUrl"));

		loginPage = new LoginPage(driver);
	}

	@When("user enters the institute mobile number")
	public void userentersinstitutemobilenumber() {

		loginPage.enterMobileNumber(ConfigReader.getProperty("instituteMobile"));
	}

	@When("user enters the institute contact person name")
	public void userentersinstitutecontactpersonname() {

		loginPage.enterContactPerson(ConfigReader.getProperty("instituteContact"));
	}

	@When("user clicks on Send Institute Verification Code")
	public void userclickssendverificationcode() {

		loginPage.clickSendVerificationCode();

		otpPage = new OtpPage(driver);
	}

	@Then("OTP verification page should be displayed")
	public void otpverificationpageshouldbedisplayed() {

		Assert.assertTrue(otpPage.isOtpVerificationPageDisplayed(),
				"OTP verification page was not displayed");
	}

	@When("user enters the valid OTP")
	public void userentersvalidotp() {

		otpPage.enterOtp(ConfigReader.getProperty("otp"));
	}

	@When("user clicks on Verify and Enter Merchant Studio")
	public void userclicksverifyandentermerchantstudio() {

		otpPage.clickVerify();

		dashboardPage = new MerchantDashboardPage(driver);
	}

	@Then("Merchant Studio dashboard should be displayed")
	public void merchantstudiodashboardshouldbedisplayed() {

		Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Merchant Studio Dashboard was not displayed");
	}

	@Then("Overview menu should be displayed")
	public void overviewmenushouldbedisplayed() {

		Assert.assertTrue(dashboardPage.isOverviewDisplayed(), "Overview menu is not displayed");
	}

	@Then("My Institute should be displayed")
	public void myinstituteshouldbedisplayed() {

		Assert.assertTrue(dashboardPage.isMyInstituteDisplayed(), "My Institute is not displayed");
	}

	@Then("dashboard summary should be displayed")
	public void dashboardsummaryshouldbedisplayed() {

		Assert.assertTrue(dashboardPage.isDashboardDataDisplayed(), "Dashboard summary is not displayed");
	}
}
