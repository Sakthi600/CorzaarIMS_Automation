package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchesAttendancePage;
import utils.ConfigReader;
import utils.DriverFactory;

public class BatchSteps {

	private BatchesAttendancePage batchPage;

	@When("user opens Batches and Attendance")
	public void userOpensBatchesAndAttendance() {

		batchPage = new BatchesAttendancePage(DriverFactory.getDriver());

		batchPage.openBatchesAttendance();
	}

	@When("user clicks Create Cohort Batch")
	public void userClicksCreateCohortBatch() {

		batchPage.clickCreateCohortBatch();
	}

	@When("user fills mandatory batch details")
	public void userFillsMandatoryBatchDetails() {

		batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));

		batchPage.enterCoordinator(ConfigReader.getProperty("batchCoordinator"));

		batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));

		batchPage.enterStartDate(ConfigReader.getProperty("batchStartDate"));

		batchPage.enterEndDate(ConfigReader.getProperty("batchEndDate"));

		batchPage.enterSeatCapacity(ConfigReader.getProperty("batchSeatCapacity"));
	}

	@When("user creates a cohort batch")
	public void userCreatesACohortBatch() {
	batchPage.clickCreateCohortBatch();
	batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));
	batchPage.enterCoordinator(ConfigReader.getProperty("batchCoordinator"));
	batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));
	batchPage.enterStartDate(ConfigReader.getProperty("batchStartDate"));
	batchPage.enterEndDate(ConfigReader.getProperty("batchEndDate"));
	batchPage.enterSeatCapacity(ConfigReader.getProperty("batchSeatCapacity"));
	batchPage.generateSessions(); // form submit செய்யும் actual method
	}

	@Then("the created batch should be displayed in the batch table")
	public void createdBatchShouldBeDisplayedInTable() {
		Assert.assertTrue(batchPage.isCreatedBatchDisplayedInTable(),
				"Created batch is not displayed in the batch table");
	}

	@When("user clicks Roster Matrix for the created batch")
	public void userClicksRosterMatrixForCreatedBatch() {
		batchPage.clickRosterMatrixForCreatedBatch();
	}

	@Then("the Roster Matrix page should be displayed")
	public void rosterMatrixPageShouldBeDisplayed() {
		Assert.assertTrue(batchPage.isRosterMatrixDisplayed(), "Roster Matrix page is not displayed");
	}

	@Then("the Roster Matrix should be closed")
	public void rosterMatrixShouldBeClosed() {
		Assert.assertFalse(batchPage.isRosterMatrixDisplayed(), "Roster Matrix is still displayed");
	}

	@When("user closes the Roster Matrix")
	public void userClosesTheRosterMatrix() {
		batchPage.closeRosterMatrix();
	}

	@When("user tests batch validation for {string}")
	public void userTestsBatchValidationFor(String testCase) {

		switch (testCase) {

		case "MissingCoordinator":
			batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));
			batchPage.enterCoordinator("");
			batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));
			batchPage.enterStartDate(ConfigReader.getProperty("batchStartDate"));
			batchPage.enterEndDate(ConfigReader.getProperty("batchEndDate"));
			batchPage.enterSeatCapacity(ConfigReader.getProperty("batchSeatCapacity"));
			batchPage.generateSessions();
			break;

		case "InvalidStartDate":
			batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));
			batchPage.enterCoordinator(ConfigReader.getProperty("batchCoordinator"));
			batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));
			batchPage.enterStartDate(ConfigReader.getProperty("invalidBatchStartDate"));
			batchPage.enterEndDate(ConfigReader.getProperty("batchEndDate"));
			batchPage.enterSeatCapacity(ConfigReader.getProperty("batchSeatCapacity"));
			batchPage.generateSessions();
			break;

		case "InvalidEndDate":
			batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));
			batchPage.enterCoordinator(ConfigReader.getProperty("batchCoordinator"));
			batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));
			batchPage.enterStartDate(ConfigReader.getProperty("batchStartDate"));
			batchPage.enterEndDate(ConfigReader.getProperty("invalidBatchEndDate"));
			batchPage.enterSeatCapacity(ConfigReader.getProperty("batchSeatCapacity"));
			batchPage.generateSessions();
			break;

		case "ZeroSeatCapacity":
			batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));
			batchPage.enterCoordinator(ConfigReader.getProperty("batchCoordinator"));
			batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));
			batchPage.enterStartDate(ConfigReader.getProperty("batchStartDate"));
			batchPage.enterEndDate(ConfigReader.getProperty("batchEndDate"));
			batchPage.enterSeatCapacity("0");
			batchPage.generateSessions();
			break;

		case "NegativeSeatCapacity":
			batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));
			batchPage.enterCoordinator(ConfigReader.getProperty("batchCoordinator"));
			batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));
			batchPage.enterStartDate(ConfigReader.getProperty("batchStartDate"));
			batchPage.enterEndDate(ConfigReader.getProperty("batchEndDate"));
			batchPage.enterSeatCapacity(ConfigReader.getProperty("negativeBatchSeatCapacity"));
			batchPage.generateSessions();
			break;

		default:
			throw new IllegalArgumentException("Unknown batch test case: " + testCase);
		}
	}

	@Then("batch validation should be displayed for {string}")
	public void batchValidationShouldBeDisplayed(String testCase) {

		Assert.assertTrue(batchPage.isBatchValidationDisplayed(testCase),
				"Expected batch validation was not displayed for: " + testCase);
	}

	@When("user generates batch sessions")
	public void userGeneratesBatchSessions() {

		batchPage.generateSessions();
	}

	@Then("cohort sessions should be generated")
	public void cohortSessionsShouldBeGenerated() {

		Assert.assertTrue(batchPage.isBatchCreated(), "Cohort sessions were not generated");
	}

}