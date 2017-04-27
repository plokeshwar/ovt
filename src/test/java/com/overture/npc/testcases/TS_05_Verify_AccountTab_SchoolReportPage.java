package com.overture.npc.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.overture.npc.pages.SchoolReportPage;


public class TS_05_Verify_AccountTab_SchoolReportPage extends CommonMethods{

	String className=this.getClass().getName().substring(27);
	WebDriver driver = null;
	String homePageUrl;
	LoginPage loginPage = null;
	HomePage homePage = null;
	SchoolReportPage schoolReportPage=null;
	
	
	
	@Test(priority = 1)
	public void TC_01_Validate_FromDate_Field() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date date = new Date();
		String expected=dateFormat.format(date);
		schoolReportPage.clickFromDate();
		String actual=schoolReportPage.getDateYearText();
		
		String screenshot = schoolReportPage.assertText(expected, actual,schoolReportPage.DATE_PICKER_YEAR);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	//============================================================================================
	
	
	@Test(priority = 2)
	public void TC_02_Validate_ToDate_Field() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date date = new Date();
		String expected=dateFormat.format(date);
		schoolReportPage.clickToDate();
		String actual=schoolReportPage.getDateYearText();
		
		String screenshot = schoolReportPage.assertText(expected, actual,schoolReportPage.DATE_PICKER_YEAR);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	//============================================================================================
	
	@Test(priority = 3)
	public void TC_03_Run_Report_Button_ValidData() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		schoolReportPage.clickFromDate();
		schoolReportPage.clickCalendarDate2();
		schoolReportPage.clickToDate();
		schoolReportPage.clickCalendarDate5();
		schoolReportPage.clickRunReport();
		
		String screenshot = schoolReportPage.captureElementScreenShot(schoolReportPage.SEARCH_FORM);
		ReporterLink(screenshot);
		ReporterSuccess(testcaseName);
		}
	
	//============================================================================================

	@Test(priority = 4)
	public void TC_04_Run_Report_Button_InvalidData() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		schoolReportPage.clickRunReport();
		String expected="Error: Please pick two date values.";
		String actual = schoolReportPage.getMessageText();
		String screenshot = schoolReportPage.assertText(expected, actual,schoolReportPage.MESSAGE_AREA);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	//============================================================================================
	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverAccountTab();
		schoolReportPage = homePage.clickCalculationReportLink();
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
