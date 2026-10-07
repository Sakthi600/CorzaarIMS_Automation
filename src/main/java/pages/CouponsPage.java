package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CouponsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public CouponsPage(WebDriver driver) {

		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	private By couponsMenu = By.xpath("//span[normalize-space()='Coupons & Promos']");

	private By createCouponButton = By.xpath("//span[normalize-space()='Create Coupon']");

	private By couponCode = By.xpath("//input[@id='coupon-code']");

	private By discountPercentage = By.xpath("//input[@id='discount-percentage-(%)']");

	private By submitApprovalButton = By.xpath("//span[text()='Submit for Approval']");

	public void openCoupons() {

		wait.until(ExpectedConditions.elementToBeClickable(couponsMenu)).click();
	}

	public void clickCreateCoupon() {

		wait.until(ExpectedConditions.elementToBeClickable(createCouponButton)).click();
	}

	public void enterCouponCode(String code) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(couponCode));

		element.clear();
		element.sendKeys(code);
	}

	public void enterDiscountPercentage(String percentage) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(discountPercentage));

		element.clear();
		element.sendKeys(percentage);
	}

	public void submitForApproval() {

		wait.until(ExpectedConditions.elementToBeClickable(submitApprovalButton)).click();
	}

	public boolean isCouponPending() {

		By pendingStatus = By.xpath("//*[contains(translate(normalize-space(.)," + "'PENDING','pending'),'pending')]");

		try {

			return wait.until(ExpectedConditions.visibilityOfElementLocated(pendingStatus)).isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}
}
