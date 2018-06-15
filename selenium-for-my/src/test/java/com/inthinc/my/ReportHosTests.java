package com.inthinc.my;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.my.report.MyTest;

public class ReportHosTests extends MyTest {

	@Test
	public void reportHosTest() {

		// choose HOS Record Report
		new Select(driver.findElement(By.id("hosReports_form:hosReports-report")))
				.selectByVisibleText("HOS Record of Duty Status Report");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// choose Report On - Driver
		driver.findElement(By.id("hosReports_form:grouporDriverSelection")).click();
		new Select(driver.findElement(By.id("hosReports_form:grouporDriverSelection"))).selectByVisibleText("Driver");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// choose driver Mark E Krier
		driver.findElement(By.id("hosReports_form:hosReports-groupDriverParam")).click();
		new Select(driver.findElement(By.id("hosReports_form:hosReports-groupDriverParam")))
				.selectByVisibleText("Mark E Krier");
		driver.findElement(By.xpath("//option[@value='66870']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// click HTML BUTTON
		WebElement HtmlButton = driver.findElement(By.xpath("//a[@id='hosReports_form:hosReports_htmlIcon']"));
		HtmlButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// check fields TopBody - HOS Record of Duty Status
		WebElement successTopBody = driver
				.findElement(By.xpath("//span[@id='hosReports_htmlText']/table/tbody/tr[5]/td[2]/p/span"));
		String expectedTopBody = "HOS Record of Duty Status";
		String actualTopBody = successTopBody.getText();
		Assert.assertTrue(actualTopBody.contains(expectedTopBody),
				"actualTopBody does not contain expectedTopBody\nexpectedSuccessTopBody: " + expectedTopBody
						+ "\nexpectedSuccessTopBody: " + actualTopBody);

		// check fields Top2 - ONE CALENDAR DAY - 24 HOURS
		WebElement successOneCalendarDay = driver
				.findElement(By.xpath("//span[@id='hosReports_htmlText']/table/tbody/tr[6]/td[2]"));
		String expectedOneCalendarDay = "(ONE CALENDAR DAY - 24 HOURS)";
		String actualOneCalendarDay = successOneCalendarDay.getText();
		Assert.assertTrue(actualOneCalendarDay.contains(expectedOneCalendarDay),
				"actualOneCalendarDay does not contain expectedOneCalendarDay\nexpectedSuccessTopBody: "
						+ expectedOneCalendarDay + "\nexpectedSuccessTopBody: " + actualOneCalendarDay);

		// check fields Driver: Krier, Mark E
		WebElement successDriverMessage = driver
				.findElement(By.xpath("//span[@id='hosReports_htmlText']/table/tbody/tr[14]/td[2]/p/span"));
		String expectedSuccessDriverMessage = "Mark E Krier";
		String actualSuccessDriverMessage = successDriverMessage.getText();
		Assert.assertTrue(actualSuccessDriverMessage.contains(expectedSuccessDriverMessage),
				"actualSuccessDriverMessage does not contain expectedSuccessDriverMessage\nexpectedSuccessDriverMessage: "
						+ expectedSuccessDriverMessage + "\nactualSuccessDriverMessage: " + actualSuccessDriverMessage);

		// check fields Driver ID: 115874
		WebElement successIdMessage = driver
				.findElement(By.xpath("//span[@id='hosReports_htmlText']/table/tbody/tr[14]/td[4]/p/span"));
		String expectedSuccessIdMessage = "115874";
		String actualSuccessIdMessage = successIdMessage.getText();
		Assert.assertTrue(actualSuccessIdMessage.contains(expectedSuccessIdMessage),
				"actualSuccessIdMessage does not contain expectedSuccessIdMessage\nexpectedSuccessIdMessage: "
						+ expectedSuccessIdMessage + "\nactualSuccessIdMessage: " + actualSuccessIdMessage);

	}

}
