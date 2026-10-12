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

	@When("user leaves batch coordinator blank")
	public void userLeavesBatchCoordinatorBlank() {

		batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));

		batchPage.enterCoordinator(ConfigReader.getProperty("invalidBatchCoordinator"));

		batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));

		batchPage.enterStartDate(ConfigReader.getProperty("batchStartDate"));

		batchPage.enterEndDate(ConfigReader.getProperty("batchEndDate"));

		batchPage.enterSeatCapacity(ConfigReader.getProperty("batchSeatCapacity"));
	}

	@When("user enters an invalid batch start date")
	public void userEntersInvalidBatchStartDate() {

		batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));

		batchPage.enterCoordinator(ConfigReader.getProperty("batchCoordinator"));

		batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));

		batchPage.enterStartDate(ConfigReader.getProperty("invalidBatchStartDate"));

		batchPage.enterEndDate(ConfigReader.getProperty("batchEndDate"));

		batchPage.enterSeatCapacity(ConfigReader.getProperty("batchSeatCapacity"));
	}

	@When("user enters an invalid batch end date")
	public void userEntersInvalidBatchEndDate() {

		batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));

		batchPage.enterCoordinator(ConfigReader.getProperty("batchCoordinator"));

		batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));

		batchPage.enterStartDate(ConfigReader.getProperty("batchStartDate"));

		batchPage.enterEndDate(ConfigReader.getProperty("invalidBatchEndDate"));

		batchPage.enterSeatCapacity(ConfigReader.getProperty("batchSeatCapacity"));
	}

	@When("user enters zero batch seat capacity")
	public void userEntersZeroBatchSeatCapacity() {

		batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));

		batchPage.enterCoordinator(ConfigReader.getProperty("batchCoordinator"));

		batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));

		batchPage.enterStartDate(ConfigReader.getProperty("batchStartDate"));

		batchPage.enterEndDate(ConfigReader.getProperty("batchEndDate"));

		batchPage.enterSeatCapacity(ConfigReader.getProperty("invalidBatchSeatCapacity"));
	}

	@When("user enters negative batch seat capacity")
	public void userEntersNegativeBatchSeatCapacity() {

		batchPage.selectCourse(ConfigReader.getProperty("batchCourseName"));

		batchPage.enterCoordinator(ConfigReader.getProperty("batchCoordinator"));

		batchPage.enterWeeklySchedule(ConfigReader.getProperty("batchWeeklySchedule"));

		batchPage.enterStartDate(ConfigReader.getProperty("batchStartDate"));

		batchPage.enterEndDate(ConfigReader.getProperty("batchEndDate"));

		batchPage.enterSeatCapacity(ConfigReader.getProperty("negativeBatchSeatCapacity"));
	}

	@When("user generates batch sessions")
	public void userGeneratesBatchSessions() {

		batchPage.generateSessions();
	}

	@Then("cohort sessions should be generated")
	public void cohortSessionsShouldBeGenerated() {

		Assert.assertTrue(batchPage.isBatchCreated(), "Cohort sessions were not generated");
	}

	@Then("cohort sessions should not be generated")
	public void cohortSessionsShouldNotBeGenerated() {

		Assert.assertFalse(batchPage.isBatchCreated(), "Cohort sessions were generated with invalid data");
	}
}