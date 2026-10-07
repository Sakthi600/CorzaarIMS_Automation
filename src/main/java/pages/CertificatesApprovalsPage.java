package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CertificatesApprovalsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public CertificatesApprovalsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	private By certificatesApprovalsMenu = By.xpath("//span[text()='Certificates & Approvals']");

	private By pageTitle = By.xpath("//*[normalize-space()='Certificates & Approvals']");

	private By pendingApprovals = By.xpath("//*[normalize-space()='Pending Approvals']");

	private By templatesStudio = By.xpath("//*[normalize-space()='Templates Studio']");

	private By learnerProgram = By
			.xpath("//*[normalize-space()='LEARNER & PROGRAM']" + " | //*[normalize-space()='Learner & Program']");

	private By certificateId = By.xpath("//th[normalize-space()='Certificate ID']");

	private By completedOn = By.xpath("//th[normalize-space()='Completed On']");

	private By reviewDecision = By.xpath("//th[text()='Review & Decision']");

	private By noPendingMessage = By.xpath("//td[text()='No student credentials awaiting manual sign-off.']");

	private By templateStudio = By.xpath("//span[normalize-space()='Templates Studio']");
	private By newTemplateButton = By.xpath("//span[normalize-space()='New Template']");

	private By templateNameField = By.xpath("//input[@id='template-name']");

	private By brandingColorField = By.xpath("//input[@id='branding-accent-color']");

	private By signatoryField = By.xpath("(//input[@id='signatory-title-&-name'])[1]");

	private By saveTemplateButton = By.xpath("//span[normalize-space()='Save Template']");

	private By templateCreatedMessage = By.xpath(
			"(//div[@class='fixed bottom-5 right-5 z-50 flex flex-col gap-2 max-w-sm w-full pointer-events-none'])[1]");

	public void openCertificatesApprovals() {

		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(certificatesApprovalsMenu));

		menu.click();
	}

	public boolean isCertificatesApprovalsPageDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
	}

	public boolean isPendingApprovalsDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(pendingApprovals)).isDisplayed();
	}

	public boolean isTemplatesStudioDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(templatesStudio)).isDisplayed();
	}

	public boolean isLearnerProgramDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(learnerProgram)).isDisplayed();
	}

	public boolean isCertificateIdDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(certificateId)).isDisplayed();
	}

	public boolean isCompletedOnDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(completedOn)).isDisplayed();
	}

	public boolean isReviewDecisionDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(reviewDecision)).isDisplayed();
	}

	public boolean isNoPendingMessageDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(noPendingMessage)).isDisplayed();
	}

	public void clickTemplateStudio() {

		wait.until(ExpectedConditions.elementToBeClickable(templateStudio)).click();
	}

	public void clickNewTemplate() {

		wait.until(ExpectedConditions.elementToBeClickable(newTemplateButton)).click();
	}

	public void enterTemplateName(String templateName) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(templateNameField));

		element.clear();
		element.sendKeys(templateName);
	}

	public void selectBrandingAccentColor() {

		WebElement colorField = wait.until(ExpectedConditions.presenceOfElementLocated(brandingColorField));

		colorField.click();
	}

	public void enterSignatory(String signatory) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(signatoryField));

		element.click();
		element.clear();
		element.sendKeys(signatory);
	}

	public void clickSaveTemplate() {

		wait.until(ExpectedConditions.elementToBeClickable(saveTemplateButton)).click();
	}

	public boolean isTemplateCreatedSuccessfully() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(templateCreatedMessage)).isDisplayed();
	}

}
