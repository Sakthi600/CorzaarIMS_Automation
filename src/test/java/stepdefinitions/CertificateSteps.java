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

	@When("user leaves certificate template name blank")
	public void userLeavesCertificateTemplateNameBlank() {

		certificatePage.enterTemplateName(ConfigReader.getProperty("blankCertificateTemplateName"));

		certificatePage.enterBrandingAccentColor(ConfigReader.getProperty("certificateAccentColor"));

		certificatePage.enterSignatory(ConfigReader.getProperty("certificateSignatory"));
	}

	@When("user enters invalid certificate template name")
	public void userEntersInvalidCertificateTemplateName() {

		certificatePage.enterTemplateName(ConfigReader.getProperty("invalidCertificateTemplateName"));

		certificatePage.enterBrandingAccentColor(ConfigReader.getProperty("certificateAccentColor"));

		certificatePage.enterSignatory(ConfigReader.getProperty("certificateSignatory"));
	}

	@When("user leaves certificate signatory blank")
	public void userLeavesCertificateSignatoryBlank() {

		certificatePage.enterTemplateName(ConfigReader.getProperty("certificateTemplateName"));

		certificatePage.enterBrandingAccentColor(ConfigReader.getProperty("certificateAccentColor"));

		certificatePage.enterSignatory(ConfigReader.getProperty("blankCertificateSignatory"));
	}

	@When("user enters invalid certificate signatory")
	public void userEntersInvalidCertificateSignatory() {

		certificatePage.enterTemplateName(ConfigReader.getProperty("certificateTemplateName"));

		certificatePage.enterBrandingAccentColor(ConfigReader.getProperty("certificateAccentColor"));

		certificatePage.enterSignatory(ConfigReader.getProperty("invalidCertificateSignatory"));
	}

	@When("user saves the certificate template")
	public void userSavesCertificateTemplate() {

		certificatePage.clickSaveTemplate();
	}

	@Then("certificate template should be created successfully")
	public void certificateTemplateShouldBeCreatedSuccessfully() {

		Assert.assertFalse(certificatePage.isTemplateCreatedSuccessfully(),
				"Certificate template was not created successfully");
	}

	@Then("certificate template should not be created")
	public void certificateTemplateShouldNotBeCreated() {

		Assert.assertTrue(certificatePage.isTemplateCreatedSuccessfully(),
				"Certificate template was created with invalid data");
	}

	@When("user edits the configured certificate template")
	public void userEditsConfiguredCertificateTemplate() {

		certificatePage.editTemplate(

				ConfigReader.getProperty("certificateTemplateName"),

				ConfigReader.getProperty("updatedCertificateTemplateName"),

				ConfigReader.getProperty("updatedCertificateSignatory"));
	}

	@When("user deletes the configured certificate template")
	public void userDeletesConfiguredCertificateTemplate() {

		certificatePage.deleteTemplate(

				ConfigReader.getProperty("updatedCertificateTemplateName"));
	}
}