package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	private By mobileNumber = By.xpath("(//input[@id='institute-manager-mobile-number'])[1]");

	private By contactPerson = By.xpath("(//input[@id='institute-contact-person-/-faculty-name'])[1]");

	private By sendVerificationCode = By.xpath("(//button[@type='submit'])[1]");

	private By verifyAndEnterMerchantStudio = By.xpath("//span[normalize-space()='Verify & Enter Merchant Studio']");

	public void enterMobileNumber(String mobile) {

		WebElement mobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumber));

		mobileField.clear();
		mobileField.sendKeys(mobile);
	}

	public void enterContactPerson(String name) {

		WebElement contactField = wait.until(ExpectedConditions.visibilityOfElementLocated(contactPerson));

		contactField.clear();
		contactField.sendKeys(name);
	}

	public void clickSendVerificationCode() {

		WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(sendVerificationCode));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});",
				button);

		wait.until(ExpectedConditions.visibilityOf(button));

		try {

			wait.until(ExpectedConditions.elementToBeClickable(button));

			button.click();

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
		}
	}
}