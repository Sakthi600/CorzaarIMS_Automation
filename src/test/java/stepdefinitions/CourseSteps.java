package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CourseStudioPage;
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

		String courseTitle = "Selenium Automation Testing";

		String tuitionFee = "4999";

		String programDuration = "3 Months";

		String overview = "This program provides practical knowledge " + "of Selenium Java Cucumber and TestNG "
				+ "automation testing.";

		String moduleTitle = "Module 1: Automation Foundations";

		coursePage.enterCourseTitle(courseTitle);

		coursePage.enterTuitionFee(tuitionFee);

		coursePage.selectProgramDuration(programDuration);

		coursePage.enterCourseOverview(overview);

		coursePage.enterModuleTitle(moduleTitle);

	}

	@When("user submits the course")
	public void userSubmitsTheCourse() {

		coursePage.publishCourse();
	}

	@Then("course should be submitted for administrative review")
	public void courseShouldBeSubmittedForAdministrativeReview() {

		Assert.assertTrue(coursePage.isCourseUnderReview(), "Course was not moved to Under Review status");
	}

	@When("user edits the course {string} to {string}")
	public void userEditsTheCourseTo(String courseName, String updatedCourseName) {

		coursePage.editCourse(courseName, updatedCourseName);
	}

	@When("user deletes the course {string}")
	public void userDeletesTheCourse(String courseName) {

		coursePage.deleteCourse(courseName);
	}

}
