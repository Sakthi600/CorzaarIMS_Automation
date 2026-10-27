package pages;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtils;

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

	@FindBy(xpath = "(//span[normalize-space()='Overview'])[1]")
	private WebElement overviewHeading;

	@FindBy(xpath = "//span[text()='Overview']")
	private WebElement overview;

	@FindBy(xpath = "//*[normalize-space()='Published Courses']/following::span[1]")
	private WebElement publishedCoursesLabel;

	@FindBy(xpath = "(//*[contains(normalize-space(.),' in review')])[10]")
	private WebElement coursesInReviewLabel;

	@FindBy(xpath = "//*[normalize-space()='Cohort Batches']/following::span[1]")
	private WebElement cohortBatchesLabel;

	@FindBy(xpath = "//*[normalize-space()='Student Enrollments']/following::span[1]")
	private WebElement studentEnrollmentsValue;

	@FindBy(xpath = "(//span[normalize-space()='Total Revenue'])[1]")
	private WebElement totalRevenueCard;

	@FindBy(xpath = "(//p[@class='text-xs sm:text-sm text-ink-muted dark:text-dark-ink-muted mt-1'])[1]")
	private WebElement accreditationPending;

	@FindBy(xpath = "(//h1[normalize-space()='My Institute'])[1]")
	private WebElement instituteName;

	@FindBy(xpath = "(//h1[normalize-space()='Course Studio'])[1]")
	private WebElement courseStudioHeading;

	@FindBy(xpath = "(//h1[normalize-space()='Batches & Attendance'])[1]")
	private WebElement batchesAttendanceHeading;

	@FindBy(xpath = "(//h1[normalize-space()='My Institute'])[1]")
	private WebElement myInstituteHeading;

	@FindBy(xpath = "(//span[normalize-space()='Create Course'])[1]")
	private WebElement createCourseButton;

	@FindBy(xpath = "(//span[normalize-space()='Add Batch'])[1]")
	private WebElement addBatchButton;

	@FindBy(xpath = "//table//tbody/tr")
	private List<WebElement> studentEnrollRows;

	@FindBy(xpath = "(//h3[normalize-space()='Course Studio'])[1]")
	private WebElement courseStudioCard;

	@FindBy(xpath = "(//h3[normalize-space()='Batches & Attendance Matrix'])[1]")
	private WebElement batchesAttendanceCard;

	@FindBy(xpath = "(//h3[normalize-space()='Learner Drop-off & Funnel'])[1]")
	private WebElement learnerDropOffCard;

	private String getVisibleText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText().trim();
	}

	private int extractFirstNumber(String text) {
		Matcher matcher = Pattern.compile("\\b\\d+\\b").matcher(text);

		if (matcher.find()) {
			return Integer.parseInt(matcher.group());
		}

		throw new AssertionError("Number not found in UI text: " + text);
	}

	public boolean isTotalRevenueDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(totalRevenueCard)).isDisplayed();
	}

	public String getTotalRevenueText() {
		return wait.until(ExpectedConditions.visibilityOf(totalRevenueCard)).getText();
	}

	public boolean isMyInstituteDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(myInstituteHeading)).isDisplayed();
	}

	public boolean isAccreditationPending() {
		return wait.until(ExpectedConditions.visibilityOf(accreditationPending)).isDisplayed();
	}

	public boolean isExpectedInstituteDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(instituteName)).isDisplayed();
	}

	public boolean isCourseStudioPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(courseStudioHeading)).isDisplayed();
	}

	public boolean isBatchesAttendancePageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(batchesAttendanceHeading)).isDisplayed();
	}

	public boolean isOverviewDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(overviewHeading)).isDisplayed();
	}

	public int getStudentEnrollmentsCount() {
		String text = wait.until(ExpectedConditions.visibilityOf(studentEnrollmentsValue)).getText().trim();

		System.out.println("Student Enrollments value: " + text);

		return extractFirstNumber(text);
	}

	public int getPublishedCoursesCount() {
		return extractFirstNumber(getVisibleText(publishedCoursesLabel));
	}

	public int getCoursesInReviewCount() {
		return extractFirstNumber(getVisibleText(coursesInReviewLabel));
	}

	public int getAttendanceTrackingCount() {
		return extractFirstNumber(getVisibleText(cohortBatchesLabel));
	}

	public boolean isCreateCourseDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(createCourseButton)).isDisplayed();
	}

	public boolean isAddBatchDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(addBatchButton)).isDisplayed();
	}

	public int getStudentEnrollmentsTableCount() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfAllElements(studentEnrollRows));

		return studentEnrollRows.size();

	}

	public void clickCourseStudioCard() {
		elementUtils.click(courseStudioCard);
	}

	public void clickBatchesAttendanceCard() {
		elementUtils.click(batchesAttendanceCard);
	}

	public void clickLearnerDropOffCard() {
		elementUtils.click(learnerDropOffCard);
	}

	public void clickCreateCourse() {
		elementUtils.click(createCourseButton);
	}

	public void openOverview() {
		elementUtils.click(overview);
	}

	public void clickAddBatch() {
		elementUtils.click(addBatchButton);
	}

	public void clickOverview() {
		elementUtils.click(overviewHeading);
	}
}
