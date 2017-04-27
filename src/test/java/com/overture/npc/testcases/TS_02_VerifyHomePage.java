package com.overture.npc.testcases;

import java.util.ArrayList;
import java.util.TreeSet;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.overture.npc.common.CommonMethods;
import com.overture.npc.common.WebDriverManager;
import com.overture.npc.pages.ChangePasswordPage;
import com.overture.npc.pages.HomePage;
import com.overture.npc.pages.LoginPage;

public class TS_02_VerifyHomePage extends CommonMethods {
	
	String homePageUrl;

	String actual, expected, msg;
	WebDriver driver = null;

	LoginPage loginPage = null;
	HomePage homePage = null;
	ChangePasswordPage passwordPage = null;

	@Test(priority = 1)
	public void TC_01_Validate_Change_Password_Link() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);

		passwordPage = homePage.clickChangePasswordLink();

		actual = passwordPage.getChangePasswordTitle();
		expected = "Change Password";

		String screenshot = passwordPage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);

	}

	// =============================================================================================================

	@Test(priority = 2)
	public void TC_02_Validate_Account_Tab() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);
		
		String expectedList = "Account Settings, Calculation Report, Traffic Summary, Preview";

		homePage.performMouseOverAccountTab();

		TreeSet<String> expect = homePage.getExpectedArrayList(expectedList);
		TreeSet<String> actual = homePage.getAccountTabSubMenu();
		
		ReporterLink(homePage.captureElementScreenShot(homePage.ACCOUNTS_MENU));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
		ReporterSuccess(testcaseName);
	}

	// =============================================================================================================

	@Test(priority = 3)
	public void TC_03_Validate_NetPrice_Tab() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);
		String expectedList = "Questions, Populations, Tables, COA, Packaging, School Computed Values";
		homePage.performMouseOverNetPriceTab();

		TreeSet<String> expect = homePage.getExpectedArrayList(expectedList);
		TreeSet<String> actual = homePage.getNetPriceSubMenu();

		ReporterLink(homePage.captureElementScreenShot(homePage.NET_PRICE_MENU));
		System.out.println("Asserting the test case");
		Assert.assertEquals(expect, actual);
		ReporterSuccess(testcaseName);
	}

	// =============================================================================================================

	@Test(priority = 4)
	public void TC_04_Validate_Content_Manangement_Tab() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);
		String expectedList = "Page Configurations, Content Editor, Next Steps";

		homePage.performMouseOverContentManagementTab();

		TreeSet<String> expect = homePage.getExpectedArrayList(expectedList);
		TreeSet<String> actual = homePage.getContentManagementSubMenu();

		ReporterLink(homePage.captureElementScreenShot(homePage.CONTENT_MANAGEMENT_MENU));
		System.out.println("Asserting the test case");
		Assert.assertEquals(expect, actual);
		ReporterSuccess(testcaseName);
	}

	// =============================================================================================================

	/*@Test(priority = 5)
	public void TC_05_Validate_SignOut_Link() {
		String ScreenshotName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.click(homePage.SignOutLink, "Clicking on the SignOut Link");
		co.pause(2500);
		globalPage = new GlobalElements().globalElementsInit(driver);

		actual = globalPage.LogoutMessage.getText();
		expected = "You have successfully been logged out. Please go here to log back in.";
		msg = "User Not Logout Succefully";

		cm.captureElementScreenShot(driver, globalPage.LogoutMessage, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, msg);
	}*/
	// =============================================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		driver.navigate().to(homePageUrl);
		homePage = new HomePage(driver);
		
	}

	@AfterMethod
	public void AfterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
		driver = WebDriverManager.getWebDriver();
		loginPage = new LoginPage(driver);
		homePage = loginPage.login();
		homePageUrl = homePage.getURL(driver);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
