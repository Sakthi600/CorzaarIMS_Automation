package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BatchesAttendancePage {

	private WebDriver driver;
	private WebDriverWait wait;

	public BatchesAttendancePage(WebDriver driver) {

		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	private By batchesAttendanceMenu = By.xpath("//span[text()='Batches & Attendance']");

	private By createCohortBatchButton = By.xpath("//span[normalize-space()='Create Cohort Batch']");

	private By selectCourseDropdown = By.xpath("//select[@id='select-course']");

	private By coordinator = By.xpath("(//input[@id='course-coordinator-/-instructor'])[1]");

	private By weeklyScheduleDropdown = By.xpath("//input[@id='weekly-schedule-(days)']");

	private By startDate = By.xpath("//input[@id='start-date']");

	private By endDate = By.xpath("//input[@id='end-date']");

	private By seatCapacity = By.xpath("//input[@id='cohort-seat-capacity']");

	private By generateSessionsButton = By.xpath("//span[text()='Generate Sessions & Schedule']");

	public void openBatchesAttendance() {

		wait.until(ExpectedConditions.elementToBeClickable(batchesAttendanceMenu)).click();
	}

	public void clickCreateCohortBatch() {

		wait.until(ExpectedConditions.elementToBeClickable(createCohortBatchButton)).click();
	}

	public void selectCourse(String courseName) {

		// Open Course dropdown
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(selectCourseDropdown));

		dropdown.click();

		// Wait for the course text displayed in the opened dropdown
		By courseOption = By.xpath("//option[@value='06413bea-c85c-43e0-ae5f-5bca7160e559']");

		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(courseOption));
		option.click();

	}

	public void enterCoordinator(String name) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(coordinator));

		element.clear();
		element.sendKeys(name);
	}

	public void selectWeeklySchedule(String day) {

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(weeklyScheduleDropdown));

		element.clear();
		element.sendKeys(day);

	}

	public void enterStartDate(String date) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(startDate));

		element.clear();
		element.sendKeys(date);
	}

	public void enterEndDate(String date) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(endDate));

		element.clear();
		element.sendKeys(date);
	}

	public void enterSeatCapacity(String capacity) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(seatCapacity));

		element.clear();
		element.sendKeys(capacity);
	}

	public void generateSessions() {

		wait.until(ExpectedConditions.elementToBeClickable(generateSessionsButton)).click();
	}

	public boolean isBatchCreated() {

		By batchResult = By.xpath("//*[contains(normalize-space(),'Scheduled')]"
				+ " | //*[contains(normalize-space(),'Cohort')]" + " | //*[contains(normalize-space(),'Mon')]");

		try {

			return wait.until(ExpectedConditions.visibilityOfElementLocated(batchResult)).isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}
}
