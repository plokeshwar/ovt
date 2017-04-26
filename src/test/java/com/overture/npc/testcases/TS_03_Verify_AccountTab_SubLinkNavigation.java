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
import com.overture.npc.pages.AccountSettingsPage;
import com.overture.npc.pages.GlobalElements;
import com.overture.npc.pages.HomePage;
import com.overture.npc.pages.LoginPage;



public class TS_03_Verify_AccountTab_SubLinkNavigation extends CommonMethods{
	String homePageUrl;
	
	String className = this.getClass().getName().substring(27);
	String actual, expected;
	WebDriver driver = null;

	LoginPage loginPage = null;
	HomePage homePage = null;
	GlobalElements globalPage = null;
	AccountSettingsPage accountSettingPage=null;

		
	@Test(priority = 1)
	public void TC_01_Validate_Account_Settings_Link() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);
		
		expected = "Account Settings";
		homePage.clickAccountSettingsLink();
		actual = homePage.getPageTitle("Accounts Settings");
		
		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);

	}

	// ==================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Calculation_Report_Link() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);
		
		expected = "School Report";
		homePage.clickCalculationReportLink();
		actual = homePage.getPageTitle("Calculations Report");
		
		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ==================================================================================

	
	@Test(priority = 3)
	public void TC_03_Validate_Traffic_Summary_Link() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);
		
		expected = "Traffic Report";
		homePage.clickTrafficSummaryLink();
		actual = homePage.getPageTitle("Traffic Summary");
		
		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ==================================================================================

	
	@Test(priority = 4)
	public void TC_04_Validate_Preview_Link() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);
		
		expected = "School Preview";
		homePage.clickPreviewLink();;
		actual = homePage.getPageTitle("School Preview");
		
		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);		
	}

	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverAccountTab();
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
