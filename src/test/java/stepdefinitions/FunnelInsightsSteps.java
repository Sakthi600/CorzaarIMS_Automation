package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FunnelInsightsPage;
import utils.DriverFactory;

public class FunnelInsightsSteps {

	private FunnelInsightsPage funnelPage;

	@When("user opens Funnel Insights")
	public void userOpensFunnelInsights() {

		funnelPage = new FunnelInsightsPage(DriverFactory.getDriver());

		funnelPage.openFunnelInsights();
	}

	@Then("Funnel Insights page should be displayed")
	public void funnelInsightsPageShouldBeDisplayed() {

		Assert.assertTrue(funnelPage.isLearnerDropOffPageDisplayed(), "Funnel Insights page is not displayed");
	}

	@And("Top Performing Programs should be displayed")
	public void topPerformingProgramsShouldBeDisplayed() {

		Assert.assertTrue(funnelPage.isTopPerformingProgramsDisplayed(), "Top Performing Programs is not displayed");
	}

	@And("Rank 1 should be displayed")
	public void rankOneShouldBeDisplayed() {

		Assert.assertTrue(funnelPage.isRankOneDisplayed(), "Rank #1 is not displayed");
	}

	@And("Rank 2 should be displayed")
	public void rankTwoShouldBeDisplayed() {

		Assert.assertTrue(funnelPage.isRankTwoDisplayed(), "Rank #2 is not displayed");
	}

	@And("Curriculum Completion and Drop-Off Matrix should be displayed")
	public void curriculumCompletionAndDropOffMatrixShouldBeDisplayed() {

		Assert.assertTrue(funnelPage.isCurriculumCompletionDisplayed(),
				"Curriculum Completion & Drop-Off Matrix is not displayed");
	}

	@And("no drop-off data message should be displayed")
	public void noDropOffDataMessageShouldBeDisplayed() {

		Assert.assertTrue(funnelPage.isNoDropOffDataDisplayed(), "No drop-off data message is not displayed");
	}
}