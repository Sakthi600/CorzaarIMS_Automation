package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunnelInsightsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public FunnelInsightsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	private By funnelInsightsMenu = By.xpath("//span[normalize-space()='Funnel Insights']");

	private By pageTitle = By.xpath("//h1[normalize-space()='Learner Retention & Funnel Insights']");

	private By topPerformingPrograms = By.xpath("//h2[normalize-space()='Top Performing Programs']");

	private By rankOne = By.xpath("//span[normalize-space()='Rank #1']");

	private By rankTwo = By.xpath("//span[normalize-space()='Rank #2']");

	private By seleniumAutomationTesting = By.xpath("(//h3[text()='Selenium Automation Testing'])[1]");

	private By curriculumCompletion = By.xpath("//*[normalize-space()='Curriculum Completion & Drop-Off Matrix']");

	private By noDropOffData = By.xpath(
			"(//div[@class='p-8 text-center bg-white dark:bg-dark-surface rounded-2xl border border-border text-ink-muted'])[1]");

	public void openFunnelInsights() {

		wait.until(ExpectedConditions.elementToBeClickable(funnelInsightsMenu)).click();
	}

	public boolean isFunnelInsightsPageDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
	}

	public boolean isTopPerformingProgramsDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(topPerformingPrograms)).isDisplayed();
	}

	public boolean isRankOneDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(rankOne)).isDisplayed();
	}

	public boolean isRankTwoDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(rankTwo)).isDisplayed();
	}

	public boolean isSeleniumAutomationTestingDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(seleniumAutomationTesting)).isDisplayed();
	}

	public boolean isCurriculumCompletionDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(curriculumCompletion)).isDisplayed();
	}

	public boolean isNoDropOffDataDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(noDropOffData)).isDisplayed();
	}
}