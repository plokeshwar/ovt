package com.overture.npc.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.overture.npc.common.CommonMethods;
import com.overture.npc.common.WebDriverManager;
import com.overture.npc.pages.HomePage;
import com.overture.npc.pages.LoginPage;

public class TS_23_Validate_ContentManagement_SubLinks_Navigation extends CommonMethods {

	String homePageUrl;

	String className = this.getClass().getSimpleName();
	String actual, expected;
	WebDriver driver = null;

	LoginPage loginPage = null;
	HomePage homePage = null;

	@Test(priority = 1)
	public void TC_01_Validate_ContentEditor_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		expected = "Content Editor";
		homePage.clickContentEditorLink();
		actual = homePage.getPageTitle(expected);
		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot, expected);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ===========================================================================================================================

	@Test(priority = 2)
	public void TC_02_Validate_NextSteps_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);


		expected = "My Next Steps";
		homePage.clickNextStepsLink();
		actual = homePage.getPageTitle(expected);
		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot, expected);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);

	}

	// ===========================================================================================================================
	@Test(priority = 3)
	public void TC_03_Validate_PageConfigurations_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);


		expected = "Page Configurations";
		homePage.clickPageConfigurationLink();
		actual = homePage.getPageTitle(expected);
		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot, expected);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);

	}

	// ===========================================================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverContentManagementTab();
	}

	@AfterMethod
	public void AfterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
		driver = WebDriverManager.getWebDriver();
		loginPage = new LoginPage(driver);
		homePage = loginPage.login("pravinAdmin", "Password1!");
		homePageUrl = homePage.getURL(driver);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
