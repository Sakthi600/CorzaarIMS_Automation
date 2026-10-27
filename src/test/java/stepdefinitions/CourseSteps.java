package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import pages.CourseStudioPage;
import utils.DriverFactory;
import utils.ConfigReader;

public class CourseSteps {

	private CourseStudioPage coursePage;

	private CourseStudioPage getCoursePage() {
		if (coursePage == null) {
			coursePage = new CourseStudioPage(DriverFactory.getDriver());
		}
		return coursePage;
	}

	@When("user opens Course Studio")
	public void userOpensCourseStudio() {

		getCoursePage().openCourseStudio();
	}

	@When("user clicks Create New Course Program")
	public void userClicksCreateNewCourseProgram() {
		getCoursePage().clickCreateCourse();
	}

	@When("user fills mandatory course details")
	public void userFillsMandatoryCourseDetails() {
		coursePage.enterCourseTitle(ConfigReader.getProperty("courseTitle"));

		coursePage.enterTuitionFee(ConfigReader.getProperty("courseTuitionFee"));

		coursePage.enterProgramDuration(ConfigReader.getProperty("courseDuration"));

		coursePage.enterCourseOverview(ConfigReader.getProperty("courseOverview"));

		// coursePage.enterModuleTitle(ConfigReader.getProperty("courseModuleTitle"));
	}

	@When("user clicks Add Module")
	public void userClicksAddModule() {
		coursePage.clickAddModule();
	}

	@When("user fills mandatory module details")
	public void userFillsMandatoryModuleDetails() {
		coursePage.fillModuleDetails(ConfigReader.getProperty("moduleTitle"));
	}

	@Then("an additional module section should be displayed")
	public void additionalModuleSectionShouldBeDisplayed() {
		Assert.assertTrue(coursePage.getModuleCount() >= 2, "Additional module section was not displayed");
	}

	@When("user submits the course")
	public void userSubmitsTheCourse() {
		coursePage.publishCourse();
	}

	@When("user tests course validation for {string}")
	public void userTestsCourseValidation(String testCase) {
		coursePage.testCourseValidation(testCase);
	}

	@Then("validation should be displayed for {string}")
	public void validationShouldBeDisplayed(String testCase) {
		Assert.assertTrue(coursePage.isValidationDisplayed(testCase),
				"Expected validation was not displayed for: " + testCase);
	}

	@When("user clicks the close button on the course program modal")
	public void userClicksCloseButtonOnCourseProgramModal() {
		coursePage.closeCourseProgramModal();
	}

	@Then("the course program modal should be closed")
	public void courseProgramModalShouldBeClosed() {
		Assert.assertTrue(coursePage.isCourseProgramModalClosed(), "Course Program modal is still displayed");
	}

	@Then("the created course status should be displayed")
	public void theCreatedCourseStatusShouldBeDisplayed() {

		String createdCourseName = ConfigReader.getProperty("courseTitle");

		String actualStatus = coursePage.getCourseStatus(createdCourseName);

		System.out.println("Created Course: " + createdCourseName);
		System.out.println("Created Course Actual Status: " + actualStatus);

		Assert.assertEquals(actualStatus.toLowerCase(), "under_review", "Created course status is incorrect!");
	}

	@Then("the existing course status should be displayed")
	public void theExistingCourseStatusShouldBeDisplayed() {

		String existingCourseName = ConfigReader.getProperty("existingCourseName");

		String actualStatus = coursePage.getCourseStatus(existingCourseName);

		System.out.println("Existing Course: " + existingCourseName);
		System.out.println("Existing Course Actual Status: " + actualStatus);

		Assert.assertFalse(actualStatus.isBlank(), "Existing course status is empty!");
	}

	@When("user clicks Edit for the course {string}")
	public void userClicksEditForCourse(String courseName) {
		coursePage.clickEditForCourse(courseName);
	}

	@When("user clicks Delete for the course {string}")
	public void userClicksDeleteForCourse(String courseName) {
		coursePage.deleteCourse(courseName);
	}

	@When("user edits all course fields")
	public void userEditsAllCourseFields() {
		coursePage.updateAllCourseFields(ConfigReader.getProperty("updatedCourseTitle"),
				ConfigReader.getProperty("updatedCourseTuitionFee"), ConfigReader.getProperty("updatedCourseDuration"),
				ConfigReader.getProperty("updatedCourseOverview"), ConfigReader.getProperty("updatedModuleTitle"),
				ConfigReader.getProperty("updatedModuleDescription"),
				ConfigReader.getProperty("updatedModuleDuration"));
	}

	@When("user saves the course changes")
	public void userSavesTheCourseChanges() {
		coursePage.saveCourseChanges();
	}

	@Then("the updated course should be displayed in the course table")
	public void updatedCourseShouldBeDisplayed() {
		Assert.assertTrue(coursePage.isCourseDisplayed(ConfigReader.getProperty("updatedCourseTitle")),
				"Updated course was not displayed in the course table");
	}

	@When("user deletes the configured course")
	public void userDeletesTheConfiguredCourse() {
		coursePage.deleteCourse(ConfigReader.getProperty("courseToDelete"));
	}

	@Then("the deleted course should not be displayed in the course table")
	public void deletedCourseShouldNotBeDisplayed() {
		Assert.assertTrue(coursePage.isCourseDisplayed(ConfigReader.getProperty("courseToDelete")),
				"Deleted course is still displayed in the course table");
	}

}