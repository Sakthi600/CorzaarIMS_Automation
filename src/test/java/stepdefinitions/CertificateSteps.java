package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CertificatesApprovalsPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class CertificateSteps {

	private CertificatesApprovalsPage certificatePage;

	@When("user opens Certificates and Approvals")
	public void userOpensCertificatesAndApprovals() {

		certificatePage = new CertificatesApprovalsPage(DriverFactory.getDriver());

		certificatePage.openCertificatesApprovals();
	}

	@Then("Certificates and Approvals page should be displayed")
	public void certificatesAndApprovalsPageShouldBeDisplayed() {

		Assert.assertTrue(certificatePage.isCertificatesApprovalsPageDisplayed(),
				"Certificates & Approvals page is not displayed");
	}

	@When("user clicks Preview for a certificate")
	public void userClicksPreviewForACertificate() {
		certificatePage.clickPreview();
	}

	@When("user clicks Reject for a certificate")
	public void userClicksRejectForACertificate() {
		certificatePage.clickReject();
	}

	@When("user clicks Sign and Approve for a certificate")
	public void userClicksSignAndApproveForACertificate() {
		certificatePage.clickSignAndApprove();
	}

	@When("user closes the Review tab")
	public void userClosesTheReviewTab() {
		certificatePage.closeReviewTab();
	}

	@Then("Pending Approvals should be displayed")
	public void pendingApprovalsShouldBeDisplayed() {

		Assert.assertTrue(certificatePage.isPendingApprovalsDisplayed(), "Pending Approvals is not displayed");
	}

	@Then("Templates Studio should be displayed")
	public void templatesStudioShouldBeDisplayed() {

		Assert.assertTrue(certificatePage.isTemplatesStudioDisplayed(), "Templates Studio is not displayed");
	}

	@When("user opens Templates Studio")
	public void userOpensTemplatesStudio() {

		certificatePage.clickTemplateStudio();
	}

	@When("user clicks New Template")
	public void userClicksNewTemplate() {

		certificatePage.clickNewTemplate();
	}

	@When("user fills mandatory certificate template details")
	public void userFillsMandatoryCertificateTemplateDetails() {

		certificatePage.enterTemplateName(ConfigReader.getProperty("certificateTemplateName"));

		certificatePage.enterBrandingAccentColor(ConfigReader.getProperty("certificateAccentColor"));

		certificatePage.enterSignatory(ConfigReader.getProperty("certificateSignatory"));
	}

	@When("user enters certificate details for {string}")
	public void userEntersCertificateDetailsFor(String testCase) {

		switch (testCase) {
		case "BlankCertificateTemplate":
			certificatePage.enterTemplateName(ConfigReader.getProperty("blankCertificateTemplateName"));
			certificatePage.enterSignatory(ConfigReader.getProperty("certificateSignatoryTitle"));
			break;

		case "BlankCertificateSignatory":
			certificatePage.enterTemplateName(ConfigReader.getProperty("certificateTemplateName"));
			certificatePage.enterSignatory(ConfigReader.getProperty("blankCertificateSignatory"));
			break;

		case "InvalidCertificateTemplate":
			certificatePage.enterTemplateName(ConfigReader.getProperty("invalidCertificateTemplateName"));
			certificatePage.enterSignatory(ConfigReader.getProperty("certificateSignatoryTitle"));
			break;

		case "InvalidCertificateSignatory":
			certificatePage.enterTemplateName(ConfigReader.getProperty("certificateTemplateName"));
			certificatePage.enterSignatory(ConfigReader.getProperty("invalidCertificateSignatory"));
			break;

		default:
			throw new IllegalArgumentException("Unknown certificate test case: " + testCase);
		}
	}

	@When("user saves the certificate template")
	public void userSavesCertificateTemplate() {

		certificatePage.clickSaveTemplate();
	}

	@Then("certificate template should be created successfully")
	public void certificateTemplateShouldBeCreatedSuccessfully() {

		Assert.assertTrue(certificatePage.isTemplateCreatedSuccessfully(),
				"Certificate template was not created successfully");
	}

	@Then("certificate template should not be created")
	public void certificateTemplateShouldNotBeCreated() {

		Assert.assertFalse(certificatePage.isTemplateCreatedSuccessfully(),
				"Certificate template was created with invalid data");
	}

}