package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtils;

public class CertificatesApprovalsPage {

	private WebDriver driver;

	private ElementUtils elementUtils;

	public CertificatesApprovalsPage(WebDriver driver) {

		this.driver = driver;

		this.elementUtils = new ElementUtils(driver);

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Certificates & Approvals']")
	private WebElement certificatesApprovalsMenu;

	@FindBy(xpath = "//*[normalize-space()='Certificates & Approvals']")
	private WebElement pageTitle;

	@FindBy(xpath = "//*[normalize-space()='Pending Approvals']")
	private WebElement pendingApprovals;

	@FindBy(xpath = "//*[normalize-space()='Templates Studio']")
	private WebElement templatesStudio;

	@FindBy(xpath = "//*[normalize-space()='LEARNER & PROGRAM']" + " | //*[normalize-space()='Learner & Program']")
	private WebElement learnerProgram;

	@FindBy(xpath = "//th[normalize-space()='Certificate ID']")
	private WebElement certificateId;

	@FindBy(xpath = "//th[normalize-space()='Completed On']")
	private WebElement completedOn;

	@FindBy(xpath = "//th[normalize-space()='Review & Decision']")
	private WebElement reviewDecision;

	@FindBy(xpath = "//td[text()='No student credentials awaiting manual sign-off.']")
	private WebElement noPendingMessage;

	@FindBy(xpath = "//span[normalize-space()='Templates Studio']")
	private WebElement templateStudio;

	@FindBy(xpath = "//span[normalize-space()='New Template']")
	private WebElement newTemplateButton;

	@FindBy(xpath = "//input[@id='template-name']")
	private WebElement templateNameField;

	@FindBy(xpath = "//input[@id='branding-accent-color']")
	private WebElement brandingAccentColorField;

	@FindBy(xpath = "(//input[@id='signatory-title-&-name'])[1]")
	private WebElement signatoryField;

	@FindBy(xpath = "//span[normalize-space()='Save Template']")
	private WebElement saveTemplateButton;

	@FindBy(xpath = "(//span[normalize-space()='Cancel'])[1]")
	private WebElement cancelButton;

	public void openCertificatesApprovals() {

		elementUtils.click(certificatesApprovalsMenu);
	}

	public boolean isCertificatesApprovalsPageDisplayed() {

		return elementUtils.isDisplayed(pageTitle);
	}

	public boolean isPendingApprovalsDisplayed() {

		return elementUtils.isDisplayed(pendingApprovals);
	}

	public boolean isTemplatesStudioDisplayed() {

		return elementUtils.isDisplayed(templatesStudio);
	}

	public boolean isLearnerProgramDisplayed() {

		return elementUtils.isDisplayed(learnerProgram);
	}

	public boolean isCertificateIdDisplayed() {

		return elementUtils.isDisplayed(certificateId);
	}

	public boolean isCompletedOnDisplayed() {

		return elementUtils.isDisplayed(completedOn);
	}

	public boolean isReviewDecisionDisplayed() {

		return elementUtils.isDisplayed(reviewDecision);
	}

	public boolean isNoPendingMessageDisplayed() {

		return elementUtils.isDisplayed(noPendingMessage);
	}

	public void clickTemplateStudio() {

		elementUtils.click(templateStudio);
	}

	public void clickNewTemplate() {

		elementUtils.click(newTemplateButton);
	}

	public void enterTemplateName(String templateName) {

		elementUtils.fillValue(templateNameField, templateName);
	}

	public void enterBrandingAccentColor(String color) {

		elementUtils.fillValue(brandingAccentColorField, color);
	}

	public void enterSignatory(String signatory) {

		elementUtils.fillValue(signatoryField, signatory);
	}

	public void clickSaveTemplate() {

		elementUtils.click(saveTemplateButton);
	}

	public void clickCancel() {
		elementUtils.click(cancelButton);
	}

	@FindBy(xpath = "(//h4[normalize-space()='Template Created'])[1]")
	private WebElement templateSuccessMessage;

	public boolean isTemplateCreatedSuccessfully() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			return wait.until(ExpectedConditions.visibilityOf(templateSuccessMessage)).isDisplayed();

		} catch (TimeoutException e) {
			return false;
		}
	}

	public void editTemplate(String existingTemplateName, String updatedTemplateName, String updatedSignatory) {

		By templateRowLocator = By.xpath("//*[normalize-space()='" + existingTemplateName + "']/ancestor::tr[1]");

		WebElement templateRow = driver.findElement(templateRowLocator);

		WebElement editButton = templateRow.findElement(By.xpath(".//button[@title='Edit Template']"));

		elementUtils.click(editButton);

		elementUtils.fillValue(templateNameField, updatedTemplateName);

		elementUtils.fillValue(signatoryField, updatedSignatory);

		WebElement saveButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));

		elementUtils.click(saveButton);
	}

	public void deleteTemplate(String templateName) {

		By templateRowLocator = By.xpath("//*[normalize-space()='" + templateName + "']/ancestor::tr[1]");

		WebElement templateRow = driver.findElement(templateRowLocator);

		WebElement deleteButton = templateRow.findElement(By.xpath(".//button[@title='Delete Template']"));

		elementUtils.click(deleteButton);

		WebElement confirmDelete = driver.findElement(By.xpath("//span[normalize-space()='Yes, Delete Template']"));

		elementUtils.click(confirmDelete);
	}
}