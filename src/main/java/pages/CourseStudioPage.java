package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseStudioPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public CourseStudioPage(WebDriver driver) {

		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	private By courseStudioMenu = By.xpath("//span[text()='Course Studio']");

	private By createCourseButton = By.xpath("//span[text()='New Course Program']");

	private By courseTitle = By.xpath("//input[@id='course-title']");

	private By tuitionFee = By.xpath("//input[@id='tuition-fee-(₹)']");

	private By programDuration = By.xpath("//input[@id='program-duration']");

	private By courseOverview = By.xpath("//textarea[@id='course-overview-&-learning-outcomes']");

	private By moduleTitle = By.xpath("(//input[@id='module-1-title'])[1]");

	private By publishCourseButton = By.xpath("//span[text()='Publish Course']");

	public void openCourseStudio() {

		wait.until(ExpectedConditions.elementToBeClickable(courseStudioMenu)).click();
	}

	public void clickCreateCourse() {

		wait.until(ExpectedConditions.elementToBeClickable(createCourseButton)).click();
	}

	public void enterCourseTitle(String title) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(courseTitle));

		element.clear();
		element.sendKeys(title);
	}

	public void enterTuitionFee(String fee) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(tuitionFee));

		element.clear();
		element.sendKeys(fee);
	}

	public void selectProgramDuration(String duration) {

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(programDuration));

		element.clear();
		element.sendKeys(duration);
	}

	public void enterCourseOverview(String overview) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(courseOverview));

		element.clear();
		element.sendKeys(overview);
	}

	public void enterModuleTitle(String title) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(moduleTitle));

		element.clear();
		element.sendKeys(title);
	}

	public void publishCourse() {

		wait.until(ExpectedConditions.elementToBeClickable(publishCourseButton)).click();
	}

	public boolean isCourseUnderReview() {

		By status = By.xpath(
				"//*[contains(normalize-space(),'under_review')]" + " | //*[contains(normalize-space(),'Under Review')]"
						+ " | //*[contains(normalize-space(),'In Review')]");

		try {

			return wait.until(ExpectedConditions.visibilityOfElementLocated(status)).isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public void editCourse(String courseName, String updatedCourseName) {

		By courseRow = By.xpath("//*[normalize-space()='" + courseName + "']/ancestor::tr[1]");

		WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(courseRow));

		WebElement editButton = row.findElement(By.xpath("(//button[@title='Edit Course'])[1]"));

		wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();

		WebElement courseTitle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='course-title'])[1]")));

		courseTitle.clear();
		courseTitle.sendKeys(updatedCourseName);

		WebElement saveButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[1]")));

		saveButton.click();
	}

	public void deleteCourse(String courseName) {

		By courseRow = By.xpath("//*[normalize-space()='" + courseName + "']/ancestor::tr[1]");

		WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(courseRow));

		WebElement deleteButton = row.findElement(By.xpath("(//button[@title='Delete Course'])[1]"));

		wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();

		WebElement confirmDelete = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Yes, Delete Course']")));

		confirmDelete.click();
	}

}
