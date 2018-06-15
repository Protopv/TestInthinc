package com.assets.portal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.my.report.AssetsTest;

public class DriverCreateTests extends AssetsTest {

	@Test
	public void driverCreateTest() {

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

		// tIME zONE choose

		driver.findElement(By.id("tzID")).click();
		new Select(driver.findElement(By.id("tzID"))).selectByVisibleText("Africa/Dakar");
		driver.findElement(By.xpath("//option[@value='number:18']")).click();

		// Measurement Type choose
		driver.findElement(By.id("measureType")).click();
		new Select(driver.findElement(By.id("measureType"))).selectByVisibleText("English");

		// click Driver Information
		driver.findElement(By.xpath("//div[@class='panel panel panel-default valFailedAccHeader']")).click();

		// Driver License input loh001

		driver.findElement(By.id("license")).sendKeys("loh001");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Driver Team choose
		driver.findElement(By.id("driverGroupID")).click();
		new Select(driver.findElement(By.id("driverGroupID")))
				.selectByVisibleText("General Testing and Junk/Test Aggregation/Team 1 User");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// click Save button
		driver.findElement(By.xpath("//button[@class='btn btn-sm btn-inthinc ng-binding']")).click();

	}
}
