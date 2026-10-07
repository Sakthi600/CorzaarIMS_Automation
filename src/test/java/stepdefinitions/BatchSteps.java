package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchesAttendancePage;
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

	@And("user fills mandatory batch details")
	public void userFillsMandatoryBatchDetails() {

		batchPage.selectCourse("Course Studio");

		batchPage.enterCoordinator("Senior Faculty");

		batchPage.selectWeeklySchedule("Mon, Wed, Fri");

		batchPage.enterStartDate("30-09-2026");

		batchPage.enterEndDate("29-12-2026");

		batchPage.enterSeatCapacity("30");
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
