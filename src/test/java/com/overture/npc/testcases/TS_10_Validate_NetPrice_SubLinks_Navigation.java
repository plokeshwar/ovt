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

public class TS_10_Validate_NetPrice_SubLinks_Navigation extends CommonMethods {

	String className = this.getClass().getName().substring(27);
	WebDriver driver = null;
	String homePageUrl;
	LoginPage loginPage = null;
	HomePage homePage = null;

	@Test(priority = 1)
	public void TC_01_Validate_COA_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expected = "Cost of Attendance - Expenses";
		homePage.clickCOALink();

		String actual = homePage.getPageTitle("COA");

		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ===========================================================================================================================

	@Test(priority = 2)
	public void TC_02_Validate_Packaging_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expected = "Packaging";
		homePage.clickPackagingLink();

		String actual = homePage.getPageTitle("Packaging");

		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ===========================================================================================================================

	@Test(priority = 3)
	public void TC_03_Validate_Populations_Link_Navigation() {
		

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expected = "Populations";
		homePage.clickPopulationsLink();

		String actual = homePage.getPageTitle("Populations");

		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ===========================================================================================================================

	@Test(priority = 4)
	public void TC_04_Validate_Questions_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expected = "Questions";
		homePage.clickQuestionsLink();

		String actual = homePage.getPageTitle("Questions");

		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ===========================================================================================================================

	/**
	 * This test case will validate if clicking on School Computed Values link,
	 * user navigates to Computed Values Page.
	 * <p>
	 * Step1 : Click on School Computed Values link visible under the Net Price
	 * Tab in home page.
	 * <p>
	 * Expected Result : Computed Values Page should show up.
	 */
	@Test(priority = 5)
	public void TC_05_Validate_SchoolComputedValues_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expected = "Computed Values";
		homePage.clickSchoolComputedLink();

		String actual = homePage.getPageTitle("Computed Values");

		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ===========================================================================================================================

	@Test(priority = 6)
	public void TC_06_Validate_Tables_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expected = "Tables";
		homePage.clickTablesLink();

		String actual = homePage.getPageTitle("Tables");

		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverNetPriceTab();
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
