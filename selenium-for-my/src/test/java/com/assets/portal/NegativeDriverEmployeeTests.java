package com.assets.portal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.my.report.AssetsTest;

public class NegativeDriverEmployeeTests extends AssetsTest {

	@Test
	public void neativeDriverEmployeeTest() {

		// click +Add button
		WebElement AbbButton = driver.findElement(By.xpath("//div[@id='detail']/form/div/button"));
		AbbButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// fild First Name input vova
		WebElement firstname = driver.findElement(By.id("first"));
		firstname.sendKeys("vova");

		// fild First Last Name input putin
		WebElement lastname = driver.findElement(By.id("last"));
		lastname.sendKeys("putin");

		// fild Employee ID input PUTINLOH
		WebElement idname = driver.findElement(By.id("empid"));
		idname.sendKeys("PUTINLOH");
		WebElement lastaname = driver.findElement(By.id("last"));
		lastaname.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// check exceptions messages "Employee ID is not available"
		WebElement successEmployeeMessage = driver.findElement(By.xpath("//p[@class='ng-binding ng-scope']"));
		String expectedSuccessEmployeeMessage = "Employee ID is not available";
		String actualSuccessEmployeeMessage = successEmployeeMessage.getText();
		Assert.assertTrue(actualSuccessEmployeeMessage.contains(expectedSuccessEmployeeMessage),
				"actualSuccessEmployeeMessage does not contain expectedSuccessEmployeeMessage\nexpectedSuccessEmployeeMessage: "
						+ expectedSuccessEmployeeMessage + "\nactualSuccessEmployeeMessage: "
						+ actualSuccessEmployeeMessage);

		// click Driver Information
		driver.findElement(By.xpath("//div[@class='panel panel panel-default valFailedAccHeader']")).click();

		// Driver License input loh001
		driver.findElement(By.id("license")).sendKeys("loh001");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// check exceptions messages "Driver License is not available"
		WebElement successLicenseMessage = driver.findElement(By.xpath("//div[@class='modal-dialog ']"));
		String expectedSuccessLicenseMessage = "Warning";
		String actualSuccessLicenseMessage = successLicenseMessage.getText();
		Assert.assertTrue(actualSuccessLicenseMessage.contains(expectedSuccessLicenseMessage),
				"actualSuccessLicenseMessage does not contain expectedSuccessLicenseMessage\nexpectedSuccessLicenseMessage: "
						+ expectedSuccessLicenseMessage + "\nactualSuccessLicenseMessage: "
						+ actualSuccessEmployeeMessage);

		// check exceptions messages pop-up windows "Driver License is not available"
		WebElement successPopupMessage = driver.findElement(By.xpath("//div[@class='modal-dialog ']"));
		String expectedSuccessPopupMessage = "This driver's license number loh001 is tied to vova putin under team - Team 1 User";
		String actualSuccessPopupMessage = successPopupMessage.getText();
		Assert.assertTrue(actualSuccessPopupMessage.contains(expectedSuccessPopupMessage),
				"actualSuccessPopupMessage does not contain expectedSuccessPopupMessage\nexpectedSuccessPopupMessage: "
						+ expectedSuccessPopupMessage + "\nactualSuccessPopupMessage: " + actualSuccessPopupMessage);

		// click OK on pop-up windows
		driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary ng-binding']")).click();

		// check exceptions messages "This driver's license number is already in use.
		WebElement successLicenseUseMessage = driver.findElement(By.xpath(
				"//div[@id='detail']/form[@role='form']/uib-accordion/div/div[2]/div[@role='tabpanel']/div/div[6]/assets-validation-error[@class='ng-isolate-scope']//p[@class='ng-binding ng-scope']"));
		String expectedSuccessLicenseUseMessage = "This driver's license number is already in use. Please enter a unique driver's license number.";
		String actualSuccessLicenseUseMessage = successLicenseUseMessage.getText();
		Assert.assertTrue(actualSuccessLicenseUseMessage.contains(expectedSuccessLicenseUseMessage),
				"actualSuccessLicenseUseMessage does not contain expectedSuccessLicenseUseMessage\nexpectedSuccessLicenseUseMessage: "
						+ expectedSuccessLicenseUseMessage + "\nactualSuccessLicenseUseMessage: "
						+ actualSuccessLicenseUseMessage);

	}
}
