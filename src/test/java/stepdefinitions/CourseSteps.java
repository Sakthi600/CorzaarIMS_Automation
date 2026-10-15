package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import pages.CourseStudioPage;
import utils.DriverFactory;
import utils.ConfigReader;

public class CourseSteps {

	private CourseStudioPage coursePage;

	// Open Course Studio
	@When("user opens Course Studio")
	public void userOpensCourseStudio() {
		coursePage = new CourseStudioPage(DriverFactory.getDriver());
		coursePage.openCourseStudio();
	}

	// Open Create Course modal
	@When("user clicks Create New Course Program")
	public void userClicksCreateNewCourseProgram() {
		coursePage.clickCreateCourse();
	}

	// Fill mandatory course fields
	@When("user fills mandatory course details")
	public void userFillsMandatoryCourseDetails() {
		coursePage.enterCourseTitle(ConfigReader.getProperty("courseTitle"));

		coursePage.enterTuitionFee(ConfigReader.getProperty("courseTuitionFee"));

		coursePage.enterProgramDuration(ConfigReader.getProperty("courseDuration"));

		coursePage.enterCourseOverview(ConfigReader.getProperty("courseOverview"));

		// coursePage.enterModuleTitle(ConfigReader.getProperty("courseModuleTitle"));
	}

	// Add another module section
	@When("user clicks Add Module")
	public void userClicksAddModule() {
		coursePage.clickAddModule();
	}

	@Then("an additional module section should be displayed")
	public void additionalModuleSectionShouldBeDisplayed() {
		Assert.assertTrue(coursePage.getModuleCount() >= 2, "Additional module section was not displayed");
	}

	// Fill the additional module
	@When("user fills mandatory module details")
	public void userFillsMandatoryModuleDetails() {
		coursePage.fillModuleDetails(ConfigReader.getProperty("moduleTitle"));
	}

	// Submit course
	@When("user submits the course")
	public void userSubmitsTheCourse() {
		coursePage.publishCourse();
	}

	@Then("course should be submitted for administrative review")
	public void courseShouldBeSubmittedForAdministrativeReview() {
		Assert.assertTrue(coursePage.isCourseUnderReview(), "Course was not moved to Under Review status");
	}

	// Negative validation scenarios
	@When("user tests course validation for {string}")
	public void userTestsCourseValidation(String testCase) {
		coursePage.testCourseValidation(testCase);
	}

	@Then("validation should be displayed for {string}")
	public void validationShouldBeDisplayed(String testCase) {
		Assert.assertTrue(coursePage.isValidationDisplayed(testCase),
				"Expected validation was not displayed for: " + testCase);
	}

	// Close Course Program modal
	@When("user clicks the close button on the course program modal")
	public void userClicksCloseButtonOnCourseProgramModal() {
		coursePage.closeCourseProgramModal();
	}

	@Then("the course program modal should be closed")
	public void courseProgramModalShouldBeClosed() {
		Assert.assertTrue(coursePage.isCourseProgramModalClosed(), "Course Program modal is still displayed");
	}

	// Verify invalid course is not submitted
	@Then("course should not be submitted for administrative review")
	public void courseShouldNotBeSubmittedForAdministrativeReview() {
		Assert.assertFalse(coursePage.isCourseUnderReview(),
				"Course was submitted even though invalid data was entered");
	}

	@When("user clicks Edit for the course {string}")
	public void userClicksEditForCourse(String courseName) {
		coursePage.clickEditCourse(courseName);
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

	// Delete a configured course
	@When("user deletes the configured course")
	public void userDeletesTheConfiguredCourse() {
		coursePage.deleteCourse(ConfigReader.getProperty("courseToDelete"));
	}

	@Then("the deleted course should not be displayed in the course table")
	public void deletedCourseShouldNotBeDisplayed() {
		Assert.assertFalse(coursePage.isCourseDisplayed(ConfigReader.getProperty("courseToDelete")),
				"Deleted course is still displayed in the course table");
	}

}