package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class CourseStudioPage {

	private WebDriver driver;

	private ElementUtils elementUtils;

	public CourseStudioPage(WebDriver driver) {

		this.driver = driver;

		this.elementUtils = new ElementUtils(driver);

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Course Studio']")
	private WebElement courseStudioMenu;

	@FindBy(xpath = "//span[text()='New Course Program']")
	private WebElement createCourseButton;

	@FindBy(xpath = "//input[@id='course-title']")
	private WebElement courseTitle;

	@FindBy(xpath = "//input[@id='tuition-fee-(₹)']")
	private WebElement tuitionFee;

	@FindBy(xpath = "//input[@id='program-duration']")
	private WebElement programDuration;

	@FindBy(xpath = "//textarea[@id='course-overview-&-learning-outcomes']")
	private WebElement courseOverview;

	@FindBy(xpath = "(//input[@id='module-1-title'])[1]")
	private WebElement moduleTitle;

	@FindBy(xpath = "(//span[normalize-space()='Cancel'])[1]")
	private WebElement cancelButton;

	@FindBy(xpath = "//span[text()='Publish Course']")
	private WebElement publishCourseButton;

	@FindBy(xpath = "//*[contains(normalize-space(),'under_review')]"
			+ " | //*[contains(normalize-space(),'Under Review')]" + " | //*[contains(normalize-space(),'In Review')]")
	private WebElement courseUnderReviewStatus;

	public void openCourseStudio() {

		elementUtils.click(courseStudioMenu);
	}

	public void clickCreateCourse() {

		elementUtils.click(createCourseButton);
	}

	public void enterCourseTitle(String title) {

		elementUtils.fillValue(courseTitle, title);
	}

	public void enterTuitionFee(String fee) {

		elementUtils.fillValue(tuitionFee, fee);
	}

	public void enterProgramDuration(String duration) {

		elementUtils.fillValue(programDuration, duration);
	}

	public void enterCourseOverview(String overview) {

		elementUtils.fillValue(courseOverview, overview);
	}

	public void enterModuleTitle(String title) {

		elementUtils.fillValue(moduleTitle, title);
	}

	public void publishCourse() {

		elementUtils.click(publishCourseButton);
	}

	public void clickCancel() {
		elementUtils.click(cancelButton);
	}

	public boolean isCourseUnderReview() {

		return elementUtils.isDisplayed(courseUnderReviewStatus);
	}

	public void editCourse(String courseName, String updatedCourseName) {

		By courseRowLocator = By.xpath("//*[normalize-space()='" + courseName + "']/ancestor::tr[1]");

		WebElement courseRow = driver.findElement(courseRowLocator);

		WebElement editButton = courseRow.findElement(By.xpath("(//button[@title='Edit Course'])[1]"));

		elementUtils.click(editButton);

		WebElement courseTitleField = driver.findElement(By.xpath("(//input[@id='course-title'])[1]"));

		elementUtils.fillValue(courseTitleField, updatedCourseName);

		WebElement saveButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));

		elementUtils.click(saveButton);
	}

	public void deleteCourse(String courseName) {

		By courseRowLocator = By.xpath("//*[normalize-space()='" + courseName + "']/ancestor::tr[1]");

		WebElement courseRow = driver.findElement(courseRowLocator);

		WebElement deleteButton = courseRow.findElement(By.xpath("(//button[@title='Delete Course'])[1]"));

		elementUtils.click(deleteButton);

		WebElement confirmDelete = driver.findElement(By.xpath("//span[text()='Yes, Delete Course']"));

		elementUtils.click(confirmDelete);
	}
}