package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtils;

public class BatchesAttendancePage {

	private WebDriver driver;

	private ElementUtils elementUtils;

	public BatchesAttendancePage(WebDriver driver) {

		this.driver = driver;

		this.elementUtils = new ElementUtils(driver);

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Batches & Attendance']")
	private WebElement batchesAttendanceMenu;

	@FindBy(xpath = "//span[normalize-space()='Create Cohort Batch']")
	private WebElement createCohortBatchButton;

	@FindBy(xpath = "//select[@id='select-course']")
	private WebElement selectCourseDropdown;

	@FindBy(xpath = "(//input[@id='course-coordinator-/-instructor'])[1]")
	private WebElement coordinator;

	@FindBy(xpath = "//input[@id='weekly-schedule-(days)']")
	private WebElement weeklySchedule;

	@FindBy(xpath = "//input[@id='start-date']")
	private WebElement startDate;

	@FindBy(xpath = "//input[@id='end-date']")
	private WebElement endDate;

	@FindBy(xpath = "//input[@id='cohort-seat-capacity']")
	private WebElement seatCapacity;
	@FindBy(xpath = "//*[normalize-space()='Selenium Automation Testing']")
	private WebElement createdBatchNames;

	@FindBy(xpath = "//span[text()='Generate Sessions & Schedule']")
	private WebElement generateSessionsButton;

	@FindBy(xpath = "(//span[normalize-space()='Cancel'])[1]")
	private WebElement cancelButton;

	@FindBy(xpath = "//*[normalize-space()='Selenium Automation Testing']")
	private WebElement createdBatchName;

	@FindBy(xpath = "//tbody/tr[1]")
	private WebElement rosterMatrixButton;

	@FindBy(xpath = "//p[text()='Tracking attendance across 0 scheduled sessions']")
	private WebElement rosterMatrixHeading;

	@FindBy(xpath = "(//button[@aria-label='Close modal'])[1]")
	private WebElement rosterMatrixCloseButton;

	@FindBy(xpath = "//*[contains(normalize-space(),'Scheduled')]" + " | //*[contains(normalize-space(),'Cohort')]"
			+ " | //*[contains(normalize-space(),'Mon')]")
	private WebElement batchResult;

	@FindBy(xpath = "//table//tr")
	private List<WebElement> batchRows;

	public void openBatchesAttendance() {

		elementUtils.click(batchesAttendanceMenu);
	}

	public void clickCreateCohortBatch() {

		elementUtils.click(createCohortBatchButton);
	}

	public void selectCourse(String courseName) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(selectCourseDropdown)).click();

		WebElement courseOption = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//option[@value='f8ff4b74-86a6-49f7-a731-61e9c654863d']")));

		courseOption.click();
	}

	public void enterCoordinator(String name) {

		elementUtils.clear(coordinator);
		elementUtils.fillValue(coordinator, name);
	}

	public void enterWeeklySchedule(String days) {

		elementUtils.clear(weeklySchedule);
		elementUtils.fillValue(weeklySchedule, days);
	}

	public void enterStartDate(String date) {

		elementUtils.clear(startDate);
		elementUtils.fillValue(startDate, date);
	}

	public void enterEndDate(String date) {

		elementUtils.clear(endDate);
		elementUtils.fillValue(endDate, date);
	}

	public void enterSeatCapacity(String capacity) {

		elementUtils.clear(seatCapacity);
		elementUtils.fillValue(seatCapacity, capacity);
	}

	public void generateSessions() {

		elementUtils.click(generateSessionsButton);
	}

	public void clickCancel() {
		elementUtils.click(cancelButton);
	}

	public boolean isBatchCreated() {

		return elementUtils.isDisplayed(batchResult);
	}

	public boolean isCreatedBatchDisplayed() {
		return createdBatchName.isDisplayed();
	}

	public void clickRosterMatrixForCreatedBatch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.elementToBeClickable(rosterMatrixButton));

		elementUtils.click(rosterMatrixButton);
	}

	public boolean isRosterMatrixDisplayed() {
		return rosterMatrixHeading.isDisplayed();
	}

	public void closeRosterMatrix() {
		elementUtils.click(rosterMatrixCloseButton);
	}

	public void createCohortBatch() {
		elementUtils.click(createCohortBatchButton);
	}

	public boolean isBatchValidationDisplayed(String testCase) {
		return driver.getPageSource().contains("required");
	}

	public boolean isCreatedBatchDisplayedInTable() {
		for (WebElement row : batchRows) {
			String rowText = row.getText();

			if (rowText != null && rowText.contains("Selenium Automation Testing")) {
				return true;
			}
		}
		return false;
	}

}