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

public class TS_09_Verify_SchoolPreviewPage_EditTestCaseScreen extends CommonMethods {

	String className = this.getClass().getName().substring(27);
	WebDriver driver = null;
	WebElement element = null;
	boolean flag = false;
	String testData, homePageUrl = null;

	LoginPage loginPage = null;
	HomePage homePage = null;
	SchoolPreviewPage schoolPreviewPage = null;

	@Test(priority = 1)
	public void TC_01_Validate_TestCaseName_Editbox_ValidData() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		testData = "BeforeTestName" + generateRandomString();
		schoolPreviewPage.enterTestCaseName(testData);
		schoolPreviewPage.clickSaveButton();

		element = driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'" + testData + "')]"));

		String expected = "true";
		String actual = String.valueOf(element.isDisplayed());

		String screenshot = schoolPreviewPage.assertText(expected, actual, element);
		ReporterLink(screenshot, " Before");

		element.click();

		testData = "AfterTestName" + generateRandomString();
		schoolPreviewPage.enterTestCaseName(testData);

		schoolPreviewPage.clickSaveButton();

		element = driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'" + testData + "')]"));

		screenshot = schoolPreviewPage.assertText(expected, actual, element);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		flag = true;
	}

	// ==================================================================================

	@Test(priority = 2)
	public void TC_02_Validate_TestCaseName_Editbox_InValidData() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		testData = "BeforeTestName" + generateRandomString();
		schoolPreviewPage.enterTestCaseName(testData);
		schoolPreviewPage.clickSaveButton();

		element = driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'" + testData + "')]"));

		String expected = "true";
		String actual = String.valueOf(element.isDisplayed());

		String screenshot = schoolPreviewPage.assertText(expected, actual, element);
		ReporterLink(screenshot, " Before");

		element.click();

		schoolPreviewPage.enterTestCaseName("");
		schoolPreviewPage.clickSaveButton();
		
		expected = "Error:Field name is required";
		actual = schoolPreviewPage.getMessageText();

		screenshot = schoolPreviewPage.assertText(expected, actual, schoolPreviewPage.ERROR_MESSAGE);
		ReporterLink(screenshot, " After");
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

	@Test(priority = 4)
	public void TC_05_Validate_DeleteButton_Action() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		testData = "TestName" + generateRandomString();
		
		schoolPreviewPage.enterTestCaseName(testData);
		schoolPreviewPage.clickSaveButton();

		element = driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'" + testData + "')]"));

		String expected = "true";
		String actual = String.valueOf(element.isDisplayed());

		String screenshot = schoolPreviewPage.assertText(expected, actual, element);
		ReporterLink(screenshot, " Before");

		element.click();
		
		schoolPreviewPage.clickDeleteButton();
		expected = "Selecting to delete will permanently remove the item from the system.\nPlease confirm that you wish to continue.";
		actual = schoolPreviewPage.getAlertPopupText();
		
		if(actual.contains("PhantomJS")){
			expected = "PhantomJS.  No Alert Text.";
		}
		
		schoolPreviewPage.dismissAlert();
		
		screenshot = schoolPreviewPage.assertText(expected, actual);
		ReporterLink(screenshot, "After");
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		flag = true;
	}

	// ==================================================================================

	@Test(priority = 5)
	public void TC_06_Validate_Delete_OK_PopUPAction() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		testData = "TestName" + generateRandomString();
		
		schoolPreviewPage.enterTestCaseName(testData);
		schoolPreviewPage.clickSaveButton();

		element = driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'" + testData + "')]"));

		String expected = "true";
		String actual = String.valueOf(element.isDisplayed());

		String screenshot = schoolPreviewPage.assertText(expected, actual, element);
		ReporterLink(screenshot, " Before");

		element.click();
		
		schoolPreviewPage.clickDeleteButton();
		expected = "false";
		schoolPreviewPage.acceptAlert();
		

		try {
			element = driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'" + testData + "')]"));
			actual = String.valueOf(element.isDisplayed());
		} catch (Exception e) {
			actual = "false";
		}
		screenshot = schoolPreviewPage.assertText(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		flag = false;
	}

	// ==================================================================================

	@Test(priority = 4)
	public void TC_07_Validate_Delete_CancelButton_PopUPAction() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		testData = "TestName" + generateRandomString();
		

		
		schoolPreviewPage.enterTestCaseName(testData);
		schoolPreviewPage.clickSaveButton();

		element = driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'" + testData + "')]"));

		String expected = "true";
		String actual = String.valueOf(element.isDisplayed());

		String screenshot = schoolPreviewPage.assertText(expected, actual, element);
		ReporterLink(screenshot, " Before");

		element.click();
		
		schoolPreviewPage.clickDeleteButton();
		expected = "Selecting to delete will permanently remove the item from the system.\nPlease confirm that you wish to continue.";
		actual = schoolPreviewPage.getAlertText();
		
		schoolPreviewPage.dismissAlert();
		
		expected = "Edit Test Case: "+testData;
		actual = schoolPreviewPage.getHeaderText();
		
		screenshot = schoolPreviewPage.assertText(expected, actual,schoolPreviewPage.HEADER_TEXT);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		flag = false;
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
			flag = false;
			ReporterText("Test Case Deleted Successfully.");
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
