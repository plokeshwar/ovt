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

public class TS_08_Verify_SchoolPreviewPage_AddTestCaseScreen extends CommonMethods {

	String className = this.getClass().getName().substring(27);
	WebDriver driver = null;
	WebElement element = null;
	boolean flag = false;
	String testData, homePageUrl = null;

	LoginPage loginPage = null;
	HomePage homePage = null;
	SchoolPreviewPage schoolPreviewPage = null;
	
	boolean appstatus = false;
	
	

	@Test(priority = 1)
	public void TC_01_Validate_TestCaseName_Editbox_InvalidData() {
		
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		schoolPreviewPage.enterTestCaseName("");
		schoolPreviewPage.clickSaveButton();
		String expected = "Error:Field name is required";
		String actual = schoolPreviewPage.getMessageText();
		
		String screenshot = schoolPreviewPage.assertText(expected, actual,schoolPreviewPage.ERROR_MESSAGE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ==================================================================================

	@Test(priority = 2)
	public void TC_02_Validate_TestCaseName_Editbox_ValidData() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		testData = "TestName" + generateRandomString();
		schoolPreviewPage.enterTestCaseName(testData);
		schoolPreviewPage.clickSaveButton();
		schoolPreviewPage.pause(2000);
		element = driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'" + testData + "')]"));
		
		String expected = "true";
		String actual = String.valueOf(element.isDisplayed());
		
		String screenshot = schoolPreviewPage.assertText(expected, actual,element);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		flag = true;

	}

	// ==================================================================================

	@Test(priority = 3)
	public void TC_04_Validate_CancelButton_Action_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		testData = "TestName" + generateRandomString();
		schoolPreviewPage.enterTestCaseName(testData);
		schoolPreviewPage.clickSaveButton();
		schoolPreviewPage.pause(2000);
		element = driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'" + testData + "')]"));
		
		String expected = "true";
		String actual = String.valueOf(element.isDisplayed());
		
		String screenshot = schoolPreviewPage.assertText(expected, actual, element);
		ReporterLink(screenshot, " Before");

		element.click();

		
		schoolPreviewPage.enterTestCaseName("Selenium Testing");
		
		schoolPreviewPage.clickCancelButton();
		

		element = driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'" + testData + "')]"));
		
		screenshot = schoolPreviewPage.assertText(expected, actual,element);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		flag = true;
	}

	// ==================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		schoolPreviewPage = homePage.clickPreviewLink();
		schoolPreviewPage.clickAddTestCase();
	}

	@AfterMethod
	public void AfterMethod() {
		if (flag) {
			ReporterText("Deleting the Test Case Created");
			try {
				element.click();
			} catch (Exception e) {

			}

			schoolPreviewPage.clickDeleteButton();
			schoolPreviewPage.acceptAlert();
		appstatus = schoolPreviewPage.checkAppStatus();
		Assert.assertEquals(appstatus, false, "Application status is not valid.");
			flag = false;
			//ReporterText("Test Case Deleted Successfully.");	
			
			
		
		}
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
