package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OtpPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public OtpPage(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	private By otpField = By.xpath("//input[@id='enter-6-digit-passcode']");

	private By verifyButton = By.xpath("(//button[@type='submit'])[1]");

	private By otpVerificationTitle = By.xpath("(//label[@for='enter-6-digit-passcode'])[1]");

	public boolean isOtpVerificationPageDisplayed() {

		try {

			WebElement otpTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(otpVerificationTitle));

			return otpTitle.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public void enterOtp(String otp) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(otpField)).clear();

		driver.findElement(otpField).sendKeys(otp);
	}

	public void clickVerify() {

		WebElement button = wait.until(
		ExpectedConditions.visibilityOfElementLocated(verifyButton)
		);

		((JavascriptExecutor) driver).executeScript(
		"arguments[0].scrollIntoView({block:'center', inline:'center'});",
		button
		);

		wait.until(
		ExpectedConditions.elementToBeClickable(verifyButton)
		);

		try {

		button.click();

		} catch (ElementClickInterceptedException e) {

		((JavascriptExecutor) driver).executeScript(
		"arguments[0].click();",
		button
		);
		}
	}
}