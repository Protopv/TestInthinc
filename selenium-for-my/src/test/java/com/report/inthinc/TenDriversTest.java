package com.report.inthinc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.my.report.TenTest;

public class TenDriversTest extends TenTest {

	WebDriver driver;

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1, groups = { "smokeTests", "negativeTests" })
	public void tenDriversTest(String username, String password, String expectedErrorMessage) {
		System.out.println("Starting negativeTest");

		// choose driver Mark E Krier
		driver.findElement(By.id("hosReports_form:hosReports-groupDriverParam")).click();
		new Select(driver.findElement(By.id("hosReports_form:hosReports-groupDriverParam")))
				.selectByVisibleText("Mark E Krier");
		driver.findElement(By.xpath("//option[@value='66870']")).click();

		// click HTML BUTTON
		WebElement HtmlButton = driver.findElement(By.xpath("//a[@id='hosReports_form:hosReports_htmlIcon']"));
		HtmlButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		new Select(driver.findElement(By.id("hosReports_form:hosReports-report")))
				.selectByVisibleText("ELD Record of Duty Status Report");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
}
