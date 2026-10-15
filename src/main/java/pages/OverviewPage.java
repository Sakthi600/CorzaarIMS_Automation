
package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtils;

import java.time.Duration;

public class OverviewPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private ElementUtils elementUtils;

	public OverviewPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.elementUtils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[normalize-space()='Overview']")
	private WebElement overviewHeading;

	@FindBy(xpath = "(//span[contains(text(),'₹0')])[1]")
	private WebElement totalRevenueCard;

	@FindBy(xpath = "(//span[normalize-space()='2'])[1]")
	private WebElement studentEnrollmentsCard;

	@FindBy(xpath = "(//span[normalize-space()='3'])[1]")
	private WebElement publishedCoursesCard;

	@FindBy(xpath = "(//span[normalize-space()='25'])[1]")
	private WebElement cohortBatchesCard;

	@FindBy(xpath = "(//span[normalize-space()='0 in review'])[1]")
	private WebElement reviewText;

	@FindBy(xpath = "(//span[@class='inline-flex items-center gap-1 shrink-0 bg-rose-50 text-rose-700 border-rose-200 text-xs px-2.5 py-1 font-medium border rounded-full'])[1]")
	private WebElement rejectedStatus;

	@FindBy(xpath = "(//p[@class='text-xs sm:text-sm text-ink-muted dark:text-dark-ink-muted mt-1'])[1]")
	private WebElement accreditationPending;

	@FindBy(xpath = "(//h1[normalize-space()='My Institute'])[1]")
	private WebElement myInstituteHeading;

	@FindBy(xpath = "(//span[normalize-space()='Create Course'])[1]")
	private WebElement createCourseButton;

	@FindBy(xpath = "(//span[normalize-space()='Add Batch'])[1]")
	private WebElement addBatchButton;

	@FindBy(xpath = "(//h1[normalize-space()='Course Studio'])[1]")
	private WebElement courseStudioHeading;
	
	@FindBy(xpath = "(//span[normalize-space()='Overview'])[1]")
	private WebElement overview;

	@FindBy(xpath = "(//h1[normalize-space()='Batches & Attendance'])[1]")
	private WebElement batchesAttendanceHeading;

// Update this locator to the actual institute name shown on the dashboard.
	@FindBy(xpath = "//*[normalize-space()='EXPECTED_INSTITUTE_NAME']")
	private WebElement instituteName;

	public boolean isOverviewDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(overviewHeading)).isDisplayed();
	}

	public boolean isTotalRevenueDisplayed() {
		String text = wait.until(ExpectedConditions.visibilityOf(totalRevenueCard)).getText();

		return text.replace("TOTAL REVENUE", "").trim().length() > 0;
	}

	public int getConfirmedPaidLearnersCount() {
		return extractFirstNumber(wait.until(ExpectedConditions.visibilityOf(studentEnrollmentsCard)).getText());
	}

	public int getPublishedCoursesCount() {
		String text = wait.until(ExpectedConditions.visibilityOf(publishedCoursesCard)).getText();

		System.out.println("Published Courses Card Text: " + text);

		Matcher matcher = Pattern.compile("\\b3\\b").matcher(text);

		if (matcher.find()) {
			return Integer.parseInt(matcher.group());
		}

		throw new AssertionError("Published Courses count not found in card text: " + text);
	}

	public int getCoursesInReviewCount() {

		String text = reviewText.getText();

		Matcher matcher = Pattern.compile("(\\d+)\\s*in\\s*review", Pattern.CASE_INSENSITIVE).matcher(text);

		if (matcher.find()) {
			return Integer.parseInt(matcher.group(1));
		}

		throw new AssertionError("Courses In Review count not found. Actual text: " + text);
	}

	public int getAttendanceTrackingCount() {
		return extractFirstNumber(wait.until(ExpectedConditions.visibilityOf(cohortBatchesCard)).getText());
	}

	private int extractFirstNumber(String text) {
		Matcher matcher = Pattern.compile("\\b\\d+\\b").matcher(text);

		if (matcher.find()) {
			return Integer.parseInt(matcher.group());
		}

		throw new AssertionError("Numeric value not found: " + text);
	}

	public boolean isRejected() {
		return wait.until(ExpectedConditions.visibilityOf(rejectedStatus)).isDisplayed();
	}

	public boolean isAccreditationPending() {
		return wait.until(ExpectedConditions.visibilityOf(accreditationPending)).isDisplayed();
	}

	public boolean isMyInstituteDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(myInstituteHeading)).isDisplayed();
	}

	public boolean isExpectedInstituteDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(instituteName)).isDisplayed();
	}

	public boolean isCreateCourseDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(createCourseButton)).isDisplayed();
	}

	public boolean isAddBatchDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(addBatchButton)).isDisplayed();
	}

	public void clickCreateCourse() {
		elementUtils.click(createCourseButton);
	}

	public boolean isCourseStudioPageDisplayed() {
		return elementUtils.isDisplayed(courseStudioHeading);
	}
	
	public void clickOverviewMenu() {
		elementUtils.click(overview);
	}

	public void clickAddBatch() {
		elementUtils.click(addBatchButton);
	}

	public boolean isBatchesAttendancePageDisplayed() {
		return elementUtils.isDisplayed(batchesAttendanceHeading);
	}

}
