package com.report.inthinc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.my.report.TenTest;

public class KyleDriverTest extends TenTest {

	@Test
	public void driverKyleTest() {
		System.out.println("Starting driver KyleT Test");
		// choose driver Kyle Jones
		driver.findElement(By.id("hosReports_form:hosReports-groupDriverParam")).click();
		driver.findElement(By.xpath("//option[@value='70703']")).click();

		// click HTML BUTTON
		WebElement HtmlButton = driver.findElement(By.xpath("//a[@id='hosReports_form:hosReports_htmlIcon']"));
		HtmlButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// check fields TopBody - ELD RECORD OF DUTY STATUS
		WebElement successTopBody = driver
				.findElement(By.xpath("//span[@id='hosReports_htmlText']/table/tbody/tr[3]/td[4]/p/span"));
		String expectedTopBody = "ELD RECORD OF DUTY STATUS";
		String actualTopBody = successTopBody.getText();
		Assert.assertTrue(actualTopBody.contains(expectedTopBody),
				"actualTopBody does not contain expectedTopBody\nexpectedSuccessTopBody: " + expectedTopBody
						+ "\nexpectedSuccessTopBody: " + actualTopBody);

		// check fields Top2 - ONE CALENDAR DAY - 24 HOURS
		WebElement successOneCalendarDay = driver
				.findElement(By.xpath("//span[@id='hosReports_htmlText']/table/tbody/tr[3]/td[4]/p/span"));
		String expectedOneCalendarDay = "ELD RECORD OF DUTY STATUS";
		String actualOneCalendarDay = successOneCalendarDay.getText();
		Assert.assertTrue(actualOneCalendarDay.contains(expectedOneCalendarDay),
				"actualOneCalendarDay does not contain expectedOneCalendarDay\nexpectedSuccessTopBody: "
						+ expectedOneCalendarDay + "\nexpectedSuccessTopBody: " + actualOneCalendarDay);

		// check fields Driver: Jones, Kyle
		WebElement successDriverMessage = driver.findElement(
				By.xpath("//span[@id='hosReports_htmlText']/table/tbody/tr[16]/td[2]/table/tbody/tr[2]/td[3]/p/span"));
		String expectedSuccessDriverMessage = "Jones, Kyle";
		String actualSuccessDriverMessage = successDriverMessage.getText();
		Assert.assertTrue(actualSuccessDriverMessage.contains(expectedSuccessDriverMessage),
				"actualSuccessDriverMessage does not contain expectedSuccessDriverMessage\nexpectedSuccessDriverMessage: "
						+ expectedSuccessDriverMessage + "\nactualSuccessDriverMessage: " + actualSuccessDriverMessage);

		// check fields Driver ID: 413048
		WebElement successIdMessage = driver.findElement(
				By.xpath("//span[@id='hosReports_htmlText']/table/tbody/tr[20]/td[2]/table/tbody/tr[2]/td[3]/p/span"));
		String expectedSuccessIdMessage = "413048";
		String actualSuccessIdMessage = successIdMessage.getText();
		Assert.assertTrue(actualSuccessIdMessage.contains(expectedSuccessIdMessage),
				"actualSuccessIdMessage does not contain expectedSuccessIdMessage\nexpectedSuccessIdMessage: "
						+ expectedSuccessIdMessage + "\nactualSuccessIdMessage: " + actualSuccessIdMessage);

		// check fields Driver's LicenseState: TX
		WebElement successLicenseState = driver.findElement(
				By.xpath("//span[@id='hosReports_htmlText']/table/tbody/tr[28]/td[2]/table/tbody/tr[2]/td[3]/p/span"));
		String expectedLicenseStateMessage = "TX";
		String actualLicenseStateMessage = successLicenseState.getText();
		Assert.assertTrue(actualLicenseStateMessage.contains(expectedLicenseStateMessage),
				"actualLicenseStateMessage does not contain expectedLicenseStateMessage\nexpectedLicenseStateMessage: "
						+ expectedLicenseStateMessage + "\nexpectedLicenseStateMessage: " + actualLicenseStateMessage);

		// check FieldsCarrier: Complete Energy Services Inc.
		WebElement successFieldsCarrier = driver.findElement(
				By.xpath("//span[@id='hosReports_htmlText']/table/tbody/tr[40]/td[2]/table/tbody/tr[2]/td[3]/p/span"));
		String expectedFieldsCarrierMessage = "Complete Energy Services Inc.";
		String actualFieldsCarrierMessage = successFieldsCarrier.getText();
		Assert.assertTrue(actualFieldsCarrierMessage.contains(expectedFieldsCarrierMessage),
				"actualFieldsCarrierMessage does not contain expectedFieldsCarrierMessage\nexpectedFieldsCarrierMessage: "
						+ expectedFieldsCarrierMessage + "\nexpectedFieldsCarrierMessage: "
						+ actualFieldsCarrierMessage);

		// check Fields US DOT Number:1316458
		WebElement successFieldsDOT = driver.findElement(
				By.xpath("//span[@id='hosReports_htmlText']/table/tbody/tr[44]/td[2]/table/tbody/tr[2]/td[3]/p/span"));
		String expectedFieldsDOTMessage = "1316458";
		String actualFieldsDOTMessage = successFieldsDOT.getText();
		Assert.assertTrue(actualFieldsDOTMessage.contains(expectedFieldsDOTMessage),
				"actualFieldsDOTMessage does not contain expectedFieldsDOTMessage\nexpectedFieldsDOTMessage: "
						+ expectedFieldsDOTMessage + "\nexpectedFieldsCarrierMessage: " + actualFieldsDOTMessage);
		System.out.println("Finished driver KyleT Test");

	}

}
