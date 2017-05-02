package com.overture.npc.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.overture.npc.pages.SchoolPreviewPage;
import com.overture.npc.pages.TestCaseStudentPage;



public class TS_70_Verify_GO_Link extends CommonMethods{
	
	String className = this.getClass().getSimpleName();

	WebDriver driver = null;
	String homePageUrl;

	LoginPage loginPage = null;
	HomePage homePage = null;
	SchoolPreviewPage schoolPreviewPage = null;
	
	WebElement element=null;
	String originalDriver =null, subDriver=null, testData=null;
	boolean flag=false;
	String actual=null,expected=null;
	
	TestCaseStudentPage tcStudentPage=null;
	
	

	@Test(priority = 1)
	public void TC_01_Validate_Go_Link_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		expected="Net Price Calculator - Welcome to the Net Price Calculator";
		actual=driver.getTitle();
		String screenshot = tcStudentPage.assertText(expected, actual, tcStudentPage.PAGE_TITLE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ==================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_EnterAsGuestLink_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		tcStudentPage.clickEnterAsGuestLink();
		expected="Student Information";
		actual=tcStudentPage.getPageHeaderTitle();
		String screenshot = tcStudentPage.assertText(expected, actual, tcStudentPage.PAGE_TITLE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ==================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_NextLink_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		tcStudentPage.enterStudentFirstName("SeleniumTesting");
		tcStudentPage.selectUserCompletingTheCalculator("Student");
		tcStudentPage.selectStudentYearOfBirth("1995");
		tcStudentPage.selectStudentCurrentGrade("2nd yr college");
		tcStudentPage.selectStudentResidenceState("Alabama");
		tcStudentPage.selectStudentMaritalStatus("Single");
		tcStudentPage.selectStudentHousing("On campus");
		tcStudentPage.clickNextButton();
		expected="Parent Household";
		actual=tcStudentPage.getPageHeaderTitle();
		String screenshot = tcStudentPage.assertText(expected, actual, tcStudentPage.PAGE_TITLE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}


	// ==================================================================================
	
	@Test(priority = 4)
	public void TC_04_Validate_BackLink_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		ReporterLink(tcStudentPage.captureElementScreenShot(tcStudentPage.PAGE_TITLE), "After Clicking Next Button");
		tcStudentPage.clickBackButton();
		expected="Student Information";
		actual=tcStudentPage.getPageHeaderTitle();
		String screenshot = tcStudentPage.assertText(expected, actual, tcStudentPage.PAGE_TITLE);
		ReporterLink(screenshot, "After Clicking Back Button");
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ==================================================================================
	
	@Test(priority = 5)
	public void TC_05_Validate_LeaveCalculatorLink_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		tcStudentPage.clickLeaveCalculator();
		expected="Net Price Calculator – Financial Aid | Education Professionals – The College Board";
		
		actual=driver.getTitle();
		String screenshot = tcStudentPage.assertText(expected, actual, tcStudentPage.AFTER_LEAVING_GUEST_PAGE_HEADER);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ==================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		tcStudentPage = new TestCaseStudentPage(driver);
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
		
		schoolPreviewPage = homePage.clickPreviewLink();
		schoolPreviewPage.clickAddTestCase();
		
		testData = "TestName" + getRandomNumberString(5);
		schoolPreviewPage.enterTestCaseName(testData);
		schoolPreviewPage.clickSaveButton();
		
		originalDriver = schoolPreviewPage.controlOfMainDriver();
		element=driver.findElement(By.xpath("//table[@id='preview-list']//tr[contains(.,'"+testData+"')]//a[contains(.,'GO')]"));
		element.click();
		subDriver = schoolPreviewPage.controlOfSubDriver();
		schoolPreviewPage.driverSwitch(subDriver);
		
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		tcStudentPage.driverSwitch(originalDriver);
		closeBrowser();
	}
}