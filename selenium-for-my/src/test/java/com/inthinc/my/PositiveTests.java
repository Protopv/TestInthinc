package com.inthinc.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test
	public void logInTest() {
		System.out.print("Starting logIn test.");
		// Create driver
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		WebDriver driver = new FirefoxDriver();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// open the page
		String url = "https://my.inthinc.com/cas/login?service=https%3A%2F%2Fmy.inthinc.com%2Ftiwipro%2Fj_spring_cas_security_check";
		driver.get(url);
		System.out.print("Page is opened.");

		// enter username
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("TutUsername");

		// enter password
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("tutPassword");

		// push log in button
		WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		logInButton.click();

		// log out button is visible
		WebElement logOutButton = driver.findElement(By.id("navigation:layout-navigationAdmin"));
		Assert.assertTrue(logOutButton.isDisplayed(), "Overview");

		// Successful log in message
		WebElement successMessage = driver.findElement(By.xpath("//ul[@id='grid_nav']"));
		String expectedSuccessMessage = "Overview";
		String actualSuccessMessage = successMessage.getText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
		// Close browser
		driver.quit();

	}

}
