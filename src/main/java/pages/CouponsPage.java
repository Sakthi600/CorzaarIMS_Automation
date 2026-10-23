package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class CouponsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public CouponsPage(WebDriver driver) {

		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Coupons & Promos']")
	private WebElement couponsMenu;

	@FindBy(xpath = "//span[normalize-space()='Create Coupon']")
	private WebElement createCouponButton;

	@FindBy(xpath = "//input[@id='coupon-code']")
	private WebElement couponCode;

	@FindBy(xpath = "//input[@id='discount-percentage-(%)']")
	private WebElement discountPercentage;

	@FindBy(xpath = "//input[@id='usage-limit']")
	private WebElement usageLimit;

	@FindBy(xpath = "//span[normalize-space()='Submit for Approval']")
	private WebElement submitApprovalButton;

	@FindBy(xpath = "(//span[normalize-space()='Cancel'])[1]")
	private WebElement cancelButton;

	@FindBy(xpath = "//*[contains(translate(normalize-space(.)," + "'PENDING','pending'),'pending')]")
	private WebElement pendingStatus;

	public void openCoupons() {

		elementUtils.click(couponsMenu);
	}

	public void clickCreateCoupon() {

		elementUtils.click(createCouponButton);
	}

	public void enterCouponCode(String code) {

		elementUtils.clear(couponCode);
		elementUtils.fillValue(couponCode, code);
	}

	public void enterDiscountPercentage(String discount) {

		elementUtils.clear(discountPercentage);
		elementUtils.fillValue(discountPercentage, discount);
	}

	public void submitForApproval() {

		elementUtils.click(submitApprovalButton);
	}

	public void clickCancel() {
		elementUtils.click(cancelButton);
	}

	public boolean isCouponPending() {
		try {
			return elementUtils.isDisplayed(pendingStatus);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isCouponFormStillDisplayed() {
		try {
			return couponCode.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

}