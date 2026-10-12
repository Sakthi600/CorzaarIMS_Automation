package pages;

import java.time.Duration;

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

	@FindBy(xpath = "//span[text()='Generate Sessions & Schedule']")
	private WebElement generateSessionsButton;

	@FindBy(xpath = "(//span[normalize-space()='Cancel'])[1]")
	private WebElement cancelButton;

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

	@FindBy(xpath = "//*[contains(normalize-space(),'Scheduled')]" + " | //*[contains(normalize-space(),'Cohort')]"
			+ " | //*[contains(normalize-space(),'Mon')]")
	private WebElement batchResult;

	public boolean isBatchCreated() {

		return elementUtils.isDisplayed(batchResult);
	}
}