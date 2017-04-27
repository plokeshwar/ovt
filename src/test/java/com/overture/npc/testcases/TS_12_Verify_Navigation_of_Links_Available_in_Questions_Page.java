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
import com.overture.npc.pages.QuestionsPage;

public class TS_12_Verify_Navigation_of_Links_Available_in_Questions_Page extends CommonMethods {

	String className = this.getClass().getName().substring(27);

	WebDriver driver = null;
	String homePageUrl;

	LoginPage loginPage = null;
	HomePage homePage = null;
	QuestionsPage questionPage = null;

	@Test(priority = 1)
	public void TC_01_Validate_Manage_Custom_Button_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		questionPage.clickManageCustomButton();

		String expected = "Questions - Manage Custom Lists";
		String actual = homePage.getPageTitle("Questions Manage Custom Page");

		String screenshot = questionPage.assertText(expected, actual, homePage.PAGE_TITLE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ============================================================================================

	@Test(priority = 2)
	public void TC_02_Validate_Parent_Assets_Link_Navigation() {
		
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		questionPage.clickParentAssetLink();

		String expected = "Questions - Parent Assets Screen";
		String actual = homePage.getPageTitle("Questions Parent Assets Page");

		String screenshot = questionPage.assertText(expected, actual, homePage.PAGE_TITLE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);

	}

	// ============================================================================================

	@Test(priority = 3)
	public void TC_03_Validate_Parent_Household_Link_Navigation() {
		
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		questionPage.clickParentHouseholdLink();

		String expected = "Questions - Parent Household Screen";
		String actual = homePage.getPageTitle("Questions Parent Household Page");

		String screenshot = questionPage.assertText(expected, actual, homePage.PAGE_TITLE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);

	}

	// ============================================================================================

	@Test(priority = 4)
	public void TC_04_Validate_Parent_Income_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		questionPage.clickParentIncomeLink();

		String expected = "Questions - Parent Income Screen";
		String actual = homePage.getPageTitle("Questions Parent Income Page");

		String screenshot = questionPage.assertText(expected, actual, homePage.PAGE_TITLE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);

	}

	// ============================================================================================

	@Test(priority = 5)
	public void TC_05_Validate_Student_Finances_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		questionPage.clickStudentFinancesLink();

		String expected = "Questions - Student Finances Screen";
		String actual = homePage.getPageTitle("Questions Student Finances Page");

		String screenshot = questionPage.assertText(expected, actual, homePage.PAGE_TITLE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);

	}

	// ============================================================================================

	@Test(priority = 6)
	public void TC_06_Validate_Student_Information_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		questionPage.clickStudentInformationLink();

		String expected = "Questions - Student Information Screen";
		String actual = homePage.getPageTitle("Questions Student Information Page");

		String screenshot = questionPage.assertText(expected, actual, homePage.PAGE_TITLE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		
	}

	// ============================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverNetPriceTab();
		questionPage = homePage.clickQuestionsLink();
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
