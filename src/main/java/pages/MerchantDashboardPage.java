package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MerchantDashboardPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public MerchantDashboardPage(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	private By overviewMenu = By.xpath("//span[text()='Overview']");

	private By merchantStudioText = By.xpath("//span[text()='Merchant Studio']");

	private By myInstituteText = By.xpath("//h1[text()='My Institute']");

	private By totalRevenue = By.xpath("//span[text()='Total Revenue']");

	private By studentEnrollments = By.xpath("//*[contains(.,'STUDENT ENROLLMENTS')]");

	private By publishedCourses = By.xpath("//*[contains(.,'PUBLISHED COURSES')]");

	private By cohortBatches = By.xpath("//*[contains(.,'COHORT BATCHES')]");

	public boolean isDashboardDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(merchantStudioText)).isDisplayed();
	}

	public boolean isOverviewDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(overviewMenu)).isDisplayed();
	}

	public boolean isMyInstituteDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(myInstituteText)).isDisplayed();
	}

	public boolean isDashboardDataDisplayed() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(totalRevenue)).isDisplayed();
	}

	public void clickOverview() {

		wait.until(ExpectedConditions.elementToBeClickable(overviewMenu)).click();
	}
}
