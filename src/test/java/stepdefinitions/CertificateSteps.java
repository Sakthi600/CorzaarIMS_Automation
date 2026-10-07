package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CertificatesApprovalsPage;
import utils.DriverFactory;

public class CertificateSteps {

	private CertificatesApprovalsPage certificatesPage;

	@When("user opens Certificates and Approvals")
	public void userOpensCertificatesAndApprovals() {

		certificatesPage = new CertificatesApprovalsPage(DriverFactory.getDriver());

		certificatesPage.openCertificatesApprovals();
	}

	@Then("Certificates and Approvals page should be displayed")
	public void certificatesAndApprovalsPageShouldBeDisplayed() {

		Assert.assertTrue(certificatesPage.isCertificatesApprovalsPageDisplayed(),
				"Certificates & Approvals page is not displayed");
	}

	@And("Pending Approvals should be displayed")
	public void pendingApprovalsShouldBeDisplayed() {

		Assert.assertTrue(certificatesPage.isPendingApprovalsDisplayed(), "Pending Approvals is not displayed");
	}

	@And("Templates Studio should be displayed")
	public void templatesStudioShouldBeDisplayed() {

		Assert.assertTrue(certificatesPage.isTemplatesStudioDisplayed(), "Templates Studio is not displayed");
	}

	@And("Learner and Program section should be displayed")
	public void learnerAndProgramSectionShouldBeDisplayed() {

		Assert.assertTrue(certificatesPage.isLearnerProgramDisplayed(), "Learner & Program section is not displayed");
	}

	@And("certificate table headers should be displayed")
	public void certificateTableHeadersShouldBeDisplayed() {

		Assert.assertTrue(certificatesPage.isCertificateIdDisplayed(), "CERTIFICATE ID is not displayed");

		Assert.assertTrue(certificatesPage.isCompletedOnDisplayed(), "COMPLETED ON is not displayed");

		Assert.assertTrue(certificatesPage.isReviewDecisionDisplayed(), "REVIEW & DECISION is not displayed");
	}

	@And("no pending certificate approval message should be displayed")
	public void noPendingCertificateApprovalMessageShouldBeDisplayed() {

		Assert.assertTrue(certificatesPage.isNoPendingMessageDisplayed(),
				"No pending certificate approval message is not displayed");
	}

	@When("user clicks Templates Studio")
	public void userClicksTemplatesStudio() {
		certificatesPage.clickTemplateStudio();
	}

	@When("user clicks New Template")
	public void userClicksNewTemplate() {

		certificatesPage.clickNewTemplate();
	}

	@When("user enters certificate template name {string}")
	public void userEntersCertificateTemplateName(String templateName) {

		certificatesPage.enterTemplateName(templateName);
	}

	@When("user selects branding accent color")
	public void userSelectsBrandingAccentColor() {

		certificatesPage.selectBrandingAccentColor();
	}

	@When("user enters signatory title and name {string}")
	public void userEntersSignatoryTitleAndName(String signatory) {

		certificatesPage.enterSignatory(signatory);
	}

	@When("user clicks Save Template")
	public void userClicksSaveTemplate() {

		certificatesPage.clickSaveTemplate();
	}

	@Then("certificate template should be created successfully")
	public void certificateTemplateShouldBeCreatedSuccessfully() {

		Assert.assertTrue(certificatesPage.isTemplateCreatedSuccessfully(),
				"Certificate template was not created successfully");
	}
}