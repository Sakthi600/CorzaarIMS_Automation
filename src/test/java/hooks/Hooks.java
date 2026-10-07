package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.LoginPage;
import pages.OtpPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class Hooks {

	@Before(order = 0)
	public void setUp() {

		System.out.println("========== TEST STARTED ==========");

		DriverFactory.initializeDriver();

		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

		DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));

		loginPage.enterMobileNumber(ConfigReader.getProperty("instituteMobile"));

		loginPage.enterContactPerson(ConfigReader.getProperty("instituteContact"));

		loginPage.clickSendVerificationCode();

		OtpPage otpPage = new OtpPage(DriverFactory.getDriver());

		otpPage.enterOtp(ConfigReader.getProperty("otp"));

		otpPage.clickVerify();

		System.out.println("========== LOGIN & OTP COMPLETED ==========");
	}

	@After
	public void tearDown() {

		System.out.println("========== TEST COMPLETED ==========");

		DriverFactory.quitDriver();
	}
}