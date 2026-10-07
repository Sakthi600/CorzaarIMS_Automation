package base;

import org.openqa.selenium.WebDriver;

import utils.DriverFactory;

public class BaseClass {

	protected WebDriver driver;

	public void initialize() {

		DriverFactory.initializeDriver();

		driver = DriverFactory.getDriver();
	}

	public void navigateToApplication(String url) {

		driver.get(url);
	}

	public void closeBrowser() {

		DriverFactory.quitDriver();
	}
}
