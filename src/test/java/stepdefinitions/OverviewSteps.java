package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.OverviewPage;
import utils.DriverFactory;

public class OverviewSteps {

	private final OverviewPage overviewPage = new OverviewPage(DriverFactory.getDriver());

	@Given("user is logged into Merchant Studio Overview")
	public void userIsLoggedIntoMerchantStudioOverview() {
		Assert.assertTrue(overviewPage.isOverviewDisplayed(), "Merchant Overview page is not displayed after login");
	}


	@Then("Overview dashboard should be displayed")
	public void overviewDashboardShouldBeDisplayed() {
		Assert.assertTrue(overviewPage.isOverviewDisplayed(), "Overview dashboard is not displayed");
	}

	
	@Then("Total Revenue value should be displayed")
	public void totalRevenueValueShouldBeDisplayed() {
		Assert.assertTrue(overviewPage.isTotalRevenueDisplayed(), "Total Revenue value is not displayed");

		System.out.println("Total Revenue: " + overviewPage.getTotalRevenueText());
	}

	
	@Then("Confirmed Paid Learners count should be displayed")
	public void confirmedPaidLearnersCountShouldBeDisplayed() {
		int count = overviewPage.getStudentEnrollmentsCount();

		Assert.assertTrue(count >= 0, "Invalid Confirmed Paid Learners count: " + count);

		System.out.println("Confirmed Paid Learners: " + count);
	}

	
	@Then("Published Courses count should be displayed")
	public void publishedCoursesCountShouldBeDisplayed() {
		int count = overviewPage.getPublishedCoursesCount();

		Assert.assertTrue(count >= 0, "Invalid Published Courses count: " + count);

		System.out.println("Published Courses: " + count);
	}

	
	@Then("Courses In Review count should be displayed")
	public void coursesInReviewCountShouldBeDisplayed() {
		int count = overviewPage.getCoursesInReviewCount();

		Assert.assertTrue(count >= 0, "Invalid Courses In Review count: " + count);

		System.out.println("Courses In Review: " + count);
	}

	
	@Then("Cohort Batches with Attendance Tracking count should be displayed")
	public void attendanceTrackingCountShouldBeDisplayed() {
		int count = overviewPage.getAttendanceTrackingCount();

		Assert.assertTrue(count >= 0, "Invalid Attendance Tracking count: " + count);

		System.out.println("Attendance Tracking: " + count);
	}

	
	@Then("My Institute status should be displayed")
	public void myInstituteStatusShouldBeDisplayed() {
		Assert.assertTrue(overviewPage.isMyInstituteDisplayed(), "My Institute section is not displayed");

		
		System.out.println("My Institute section is displayed");
	}

	
	@Then("Accreditation status should be displayed")
	public void accreditationStatusShouldBeDisplayed() {
		Assert.assertTrue(overviewPage.isAccreditationPending(), "Accreditation status is not displayed");
	}

	
	@Then("logged-in institute should match expected institute")
	public void loggedInInstituteShouldMatchExpectedInstitute() {
		Assert.assertTrue(overviewPage.isExpectedInstituteDisplayed(), "Expected institute is not displayed");
	}

	
	@Then("Create Course button should be displayed")
	public void createCourseButtonShouldBeDisplayed() {
		Assert.assertTrue(overviewPage.isCreateCourseDisplayed(), "Create Course button is not displayed");
	}

	
	@Then("Add Batch button should be displayed")
	public void addBatchButtonShouldBeDisplayed() {
		Assert.assertTrue(overviewPage.isAddBatchDisplayed(), "Add Batch button is not displayed");
	}

	
	@Then("Create Course button should navigate to Course Studio page")
	public void createCourseButtonShouldNavigateToCourseStudioPage() {
		overviewPage.clickCreateCourse();

		Assert.assertTrue(overviewPage.isCourseStudioPageDisplayed(), "Course Studio page was not opened");
	}

	
	@When("user returns to Overview page")
	public void userReturnsToOverviewPage() {
		overviewPage.clickOverview();

		Assert.assertTrue(overviewPage.isOverviewDisplayed(), "Unable to return to Overview page");
	}

	
	@Then("Add Batch button should navigate to Batches Attendance page")
	public void addBatchButtonShouldNavigateToBatchesAttendancePage() {
		overviewPage.clickAddBatch();

		Assert.assertTrue(overviewPage.isBatchesAttendancePageDisplayed(), "Batches & Attendance page was not opened");
	}
}