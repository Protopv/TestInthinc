package com.my.report;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class AssetsTest {

	protected WebDriver driver;

	@BeforeMethod
	protected void setUp() {
		System.out.println("Creating driver");
		// Create driver
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// open the page
		String url = "https://my.inthinc.com/cas/login?service=https%3A%2F%2Fmy.inthinc.com%2Ftiwipro%2Fj_spring_cas_security_check";
		driver.get(url);
		System.out.print("Page is opened.");

		// enter username
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("tutUser");

		// enter password
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("tutPassword");

		// push log in button
		WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		logInButton.click();

		// log out button is visible
		WebElement logOutButton = driver.findElement(By.id("navigation:layout-navigationAdmin"));
		Assert.assertTrue(logOutButton.isDisplayed(), "Overview");
			
		// click Assets button
		String urlAssets = "https://my.inthinc.com/portal_admin_frontend/people";
		driver.get(urlAssets);

		
	}

	
	
}
