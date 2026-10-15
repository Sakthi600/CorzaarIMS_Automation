package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtils;

public class CourseStudioPage {

	private WebDriver driver;

	private WebDriverWait wait;
	private ElementUtils elementUtils;

	public CourseStudioPage(WebDriver driver) {

		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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

	@FindBy(xpath = "//button[contains(.,'Add Module')]")
	private WebElement addModuleButton;

	@FindBy(xpath = "//input[starts-with(@id,'module-') and contains(@id,'-title')]")
	private List<WebElement> allModuleTitles;

	@FindBy(css = "button.absolute.top-3.right-3")
	private WebElement courseModalCloseButton;

	@FindBy(xpath = "//*[normalize-space()='Create New Course Program']")
	private WebElement courseModalHeading;

	@FindBy(id = "module-1-title")
	private WebElement moduleTitleField;

	// Replace these example locators with actual HTML attributes
	@FindBy(id = "module-1-description")
	private WebElement moduleDescriptionField;

	@FindBy(id = "module-1-duration")
	private WebElement moduleDurationField;

	@FindBy(xpath = "//span[text()='Publish Course']")
	private WebElement publishCourseButton;

	@FindBy(xpath = "//*[contains(normalize-space(),'under_review')]"
			+ " | //*[contains(normalize-space(),'Under Review')]" + " | //*[contains(normalize-space(),'In Review')]")
	private WebElement courseUnderReviewStatus;

	@FindBy(xpath = "//button[@title='Edit Course']")
	private List<WebElement> editCourseButtons;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

	@FindBy(xpath = "//span[normalize-space()='Yes, Delete Course']")
	private WebElement confirmDeleteButton;

	@FindBy(xpath = "//button[@title='Delete Course']")
	private List<WebElement> deleteCourseButtons;

	@FindBy(xpath = "//table//tr")
	private List<WebElement> courseRows;

	@FindBy(xpath = ".//button[@title='Delete Course']")
	private List<WebElement> buttons;

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

	public void clickAddModule() {
		int previousCount = allModuleTitles.size();

		elementUtils.click(addModuleButton);

		wait.until(driver -> allModuleTitles.size() > previousCount);
	}

	public int getModuleCount() {
		return allModuleTitles.size();
	}

	public void testCourseValidation(String testCase) {
		WebElement field;

		switch (testCase) {
		case "MissingTitle":
			field = courseTitle;
			break;

		case "MissingTuitionFee":
			field = tuitionFee;
			break;

		case "MissingDuration":
			field = programDuration;
			break;

		case "MissingOverview":
			field = courseOverview;
			break;

		case "MissingModuleTitle":
			field = moduleTitleField;
			break;

		default:
			throw new IllegalArgumentException("Unknown test case: " + testCase);
		}

		field.clear();

		// HTML required-field validation
		if (!field.getAttribute("required").equals("true")) {
			// The browser may use a required attribute with an empty value.
		}
	}

	public void closeCourseProgramModal() {
		wait.until(ExpectedConditions.elementToBeClickable(courseModalCloseButton)).click();

		wait.until(ExpectedConditions.invisibilityOf(moduleTitleField));
	}

	public boolean isCourseProgramModalClosed() {
		return wait.until(ExpectedConditions.invisibilityOf(moduleTitleField));
	}

	public boolean isValidationDisplayed(String testCase) {
		WebElement field;

		switch (testCase) {
		case "MissingTitle":
			field = courseTitle;
			break;

		case "MissingTuitionFee":
			field = tuitionFee;
			break;

		case "MissingDuration":
			field = programDuration;
			break;

		case "MissingOverview":
			field = courseOverview;
			break;

		case "MissingModuleTitle":
			field = moduleTitleField;
			break;

		default:
			throw new IllegalArgumentException("Unknown test case: " + testCase);
		}

		return Boolean.TRUE
				.equals(((JavascriptExecutor) driver).executeScript("return !arguments[0].checkValidity();", field));
	}

	public void fillModuleDetails(String title) {

		elementUtils.fillValue(moduleTitleField, title);
		// elementUtils.fillValue(moduleDescriptionField, description);
		// elementUtils.fillValue(moduleDurationField, duration);
	}

	public void clickEditCourse(String courseName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(courseRows));

		for (int i = 0; i < courseRows.size(); i++) {
			if (courseRows.get(i).getText().contains(courseName)) {
				wait.until(ExpectedConditions.elementToBeClickable(editCourseButtons.get(i))).click();
				return;
			}
		}

		throw new RuntimeException("Course not found: " + courseName);
	}

	public void updateAllCourseFields(String title, String fee, String duration, String overview,
			String updatedModuleTitle, String moduleDescription, String moduleDuration) {

		elementUtils.fillValue(courseTitle, title);
		elementUtils.fillValue(tuitionFee, fee);
		elementUtils.fillValue(programDuration, duration);
		elementUtils.fillValue(courseOverview, overview);
		elementUtils.fillValue(moduleTitle, updatedModuleTitle);

		// Add module description and duration only after
		// confirming their actual editable input locators.
	}

	public void saveCourseChanges() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		elementUtils.click(saveButton);
	}

	public boolean isCourseDisplayed(String courseName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(courseRows));

		for (WebElement row : courseRows) {
			if (row.getText().contains(courseName)) {
				return true;
			}
		}

		return false;
	}

	public void deleteCourse(String courseName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(courseRows));

		for (int i = 0; i < courseRows.size(); i++) {
			if (courseRows.get(i).getText().contains(courseName)) {
				elementUtils.click(deleteCourseButtons.get(i));

				wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton));

				elementUtils.click(confirmDeleteButton);
				wait.until(ExpectedConditions.invisibilityOf(courseRows.get(i)));
				return;
			}
		}

		throw new RuntimeException("Course not found: " + courseName);
	}

}