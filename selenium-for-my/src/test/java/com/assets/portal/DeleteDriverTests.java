package com.assets.portal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.my.report.AssetsTest;

public class DeleteDriverTests extends AssetsTest {

	@Test
	public void delDriverTest() {

		// click Assets button
		String urlAssets = "https://my.inthinc.com/portal_admin_frontend/people";
		driver.get(urlAssets);

	}
}
