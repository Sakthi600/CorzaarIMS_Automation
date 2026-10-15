package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OverviewPage;
import utils.DriverFactory;

public class OverviewSteps {

	private OverviewPage overviewPage;

	@Given("user is logged into Merchant Studio Overview")
	public void userIsLoggedIntoMerchantStudioOverview() {
		overviewPage = new OverviewPage(DriverFactory.getDriver());

		Assert.assertTrue(overviewPage.isOverviewDisplayed(), "Overview dashboard did not open after login");
	}

	@Then("Overview dashboard should be displayed")
	public void overviewDashboardShouldBeDisplayed() {
		Assert.assertTrue(overviewPage.isOverviewDisplayed());
	}

	@Then("Total Revenue value should be displayed")
	public void totalRevenueValueShouldBeDisplayed() {
		Assert.assertTrue(overviewPage.isTotalRevenueDisplayed(), "Total Revenue value is missing");
	}

	@Then("Confirmed Paid Learners count should be {int}")
	public void confirmedPaidLearnersCountShouldBe(int expected) {
		Assert.assertEquals(overviewPage.getConfirmedPaidLearnersCount(), expected,
				"Confirmed Paid Learners count mismatch");
	}

	@Then("Published Courses count should be {int}")
	public void publishedCoursesCountShouldBe(int expected) {
		Assert.assertEquals(overviewPage.getPublishedCoursesCount(), expected, "Published Courses count mismatch");
	}

	@Then("Courses In Review count should be {int}")
	public void coursesInReviewCountShouldBe(int expected) {
		Assert.assertEquals(overviewPage.getCoursesInReviewCount(), expected, "Courses In Review count mismatch");
	}

	@Then("Cohort Batches with Attendance Tracking count should be {int}")
	public void attendanceTrackingCountShouldBe(int expected) {
		Assert.assertEquals(overviewPage.getAttendanceTrackingCount(), expected, "Attendance Tracking count mismatch");
	}

	@Then("My Institute status should be Rejected")
	public void myInstituteStatusShouldBeRejected() {
		Assert.assertTrue(overviewPage.isRejected(), "My Institute status is not Rejected");
	}

	@Then("Accreditation status should be Pending")
	public void accreditationStatusShouldBePending() {
		Assert.assertTrue(overviewPage.isAccreditationPending(), "Accreditation status is not Pending");
	}

	@Then("logged-in institute should match expected institute")
	public void loggedInInstituteShouldMatchExpectedInstitute() {
		Assert.assertTrue(overviewPage.isMyInstituteDisplayed(), "My Institute section is missing");
	}

	@Then("Create Course button should be displayed")
	public void createCourseButtonShouldBeDisplayed() {
		Assert.assertTrue(overviewPage.isCreateCourseDisplayed());
	}

	@Then("Add Batch button should be displayed")
	public void addBatchButtonShouldBeDisplayed() {
		Assert.assertTrue(overviewPage.isAddBatchDisplayed());
	}

	@Then("Create Course button should navigate to Course Studio page")
	public void createCourseButtonShouldNavigateToCourseStudioPage() {
		overviewPage.clickCreateCourse();
		Assert.assertTrue(overviewPage.isCourseStudioPageDisplayed(), "Course Studio page did not open");
	}

	@When("user returns to Overview page")
	public void userReturnsToOverviewPage() {
		overviewPage.clickOverviewMenu();
		Assert.assertTrue(overviewPage.isRejected(), "Overview page did not open");
	}

	@Then("Add Batch button should navigate to Batches Attendance page")
	public void addBatchButtonShouldNavigateToBatchesAttendancePage() {
		overviewPage.clickAddBatch();
		Assert.assertTrue(overviewPage.isBatchesAttendancePageDisplayed(), "Batches & Attendance page did not open");
	}

}
