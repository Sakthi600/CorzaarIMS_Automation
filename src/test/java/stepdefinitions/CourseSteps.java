package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CourseStudioPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class CourseSteps {

	private CourseStudioPage coursePage;

	@When("user opens Course Studio")
	public void userOpensCourseStudio() {

		coursePage = new CourseStudioPage(DriverFactory.getDriver());

		coursePage.openCourseStudio();
	}

	@When("user clicks Create New Course Program")
	public void userClicksCreateNewCourseProgram() {

		coursePage.clickCreateCourse();
	}

	@When("user fills mandatory course details")
	public void userFillsMandatoryCourseDetails() {

		coursePage.enterCourseTitle(ConfigReader.getProperty("courseTitle"));

		coursePage.enterTuitionFee(ConfigReader.getProperty("courseTuitionFee"));

		coursePage.enterProgramDuration(ConfigReader.getProperty("courseProgramDuration"));

		coursePage.enterCourseOverview(ConfigReader.getProperty("courseOverview"));

		coursePage.enterModuleTitle(ConfigReader.getProperty("courseModuleTitle"));
	}

	@When("user leaves the course title blank")
	public void userLeavesCourseTitleBlank() {

		coursePage.enterCourseTitle(ConfigReader.getProperty("invalidCourseTitle"));

		coursePage.enterTuitionFee(ConfigReader.getProperty("courseTuitionFee"));

		coursePage.enterProgramDuration(ConfigReader.getProperty("courseProgramDuration"));

		coursePage.enterCourseOverview(ConfigReader.getProperty("courseOverview"));

		coursePage.enterModuleTitle(ConfigReader.getProperty("courseModuleTitle"));
	}

	@When("user enters an invalid tuition fee")
	public void userEntersInvalidTuitionFee() {

		coursePage.enterCourseTitle(ConfigReader.getProperty("courseTitle"));

		coursePage.enterTuitionFee(ConfigReader.getProperty("invalidTuitionFee"));

		coursePage.enterProgramDuration(ConfigReader.getProperty("courseProgramDuration"));

		coursePage.enterCourseOverview(ConfigReader.getProperty("courseOverview"));

		coursePage.enterModuleTitle(ConfigReader.getProperty("courseModuleTitle"));
	}

	@When("user enters an invalid program duration")
	public void userEntersInvalidProgramDuration() {

		coursePage.enterCourseTitle(ConfigReader.getProperty("courseTitle"));

		coursePage.enterTuitionFee(ConfigReader.getProperty("courseTuitionFee"));

		coursePage.enterProgramDuration(ConfigReader.getProperty("invalidProgramDuration"));

		coursePage.enterCourseOverview(ConfigReader.getProperty("courseOverview"));

		coursePage.enterModuleTitle(ConfigReader.getProperty("courseModuleTitle"));
	}

	@When("user leaves the course overview blank")
	public void userLeavesCourseOverviewBlank() {

		coursePage.enterCourseTitle(ConfigReader.getProperty("courseTitle"));

		coursePage.enterTuitionFee(ConfigReader.getProperty("courseTuitionFee"));

		coursePage.enterProgramDuration(ConfigReader.getProperty("courseProgramDuration"));

		coursePage.enterCourseOverview(ConfigReader.getProperty("invalidCourseOverview"));

		coursePage.enterModuleTitle(ConfigReader.getProperty("courseModuleTitle"));
	}

	@When("user leaves the module title blank")
	public void userLeavesModuleTitleBlank() {

		coursePage.enterCourseTitle(ConfigReader.getProperty("courseTitle"));

		coursePage.enterTuitionFee(ConfigReader.getProperty("courseTuitionFee"));

		coursePage.enterProgramDuration(ConfigReader.getProperty("courseProgramDuration"));

		coursePage.enterCourseOverview(ConfigReader.getProperty("courseOverview"));

		coursePage.enterModuleTitle(ConfigReader.getProperty("invalidModuleTitle"));
	}

	@When("user submits the course")
	public void userSubmitsTheCourse() {

		coursePage.publishCourse();
	}

	@Then("course should be submitted for administrative review")
	public void courseShouldBeSubmittedForAdministrativeReview() {

		Assert.assertTrue(coursePage.isCourseUnderReview(), "Course was not moved to Under Review status");
	}

	@Then("course should not be submitted for administrative review")
	public void courseShouldNotBeSubmittedForAdministrativeReview() {

		Assert.assertFalse(coursePage.isCourseUnderReview(),
				"Course was submitted even though invalid data was entered");
	}

	@When("user edits the configured course")
	public void userEditsTheConfiguredCourse() {

		coursePage.editCourse(ConfigReader.getProperty("courseToEdit"), ConfigReader.getProperty("updatedCourseTitle"));
	}

	@When("user deletes the configured course")
	public void userDeletesTheConfiguredCourse() {

		coursePage.deleteCourse(ConfigReader.getProperty("courseToDelete"));
	}
}