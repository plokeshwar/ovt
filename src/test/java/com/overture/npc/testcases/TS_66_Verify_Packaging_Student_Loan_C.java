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
import com.overture.npc.pages.PackagingPage;
import com.overture.npc.pages.QuestionsPage;

public class TS_66_Verify_Packaging_Student_Loan_C extends CommonMethods {
	
	String className = this.getClass().getSimpleName();

	WebDriver driver = null;
	String homePageUrl;

	LoginPage loginPage = null;
	HomePage homePage = null;
	QuestionsPage questionPage = null;
	PackagingPage packagingPage;

	private boolean flag;
	
	
	
	@Test(priority = 1)
	public void TC_01_Validate_Assignment_Table() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		
		String expected = "Edit Packaging - Student Loan - C";
		
		String actual = homePage.getPageTitle(expected);
		
		String screenshot = homePage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		
		
	}
	
	//===========================================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Fixed_Link() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		packagingPage.clickOnFixedLink();
		
		String expected = "Add Fixed Value of:";
		String actual = packagingPage.newRowGetText();

		String screenshot = packagingPage.assertText(expected, actual, packagingPage.NEW_ROW);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	//===========================================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_Save_Button() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		packagingPage.clickOnFixedLink();
		
		String testData = getRandomNumberString(4);

		packagingPage.typeInputPackageField(testData);
		packagingPage.clickEditPackageSaveButton();
		packagingPage.clickSaveChangesPopupYesButton();
		packagingPage.clickStudentLoanCLink();

		String actual = packagingPage.getPackageFieldValue();
		
		String screenshot = packagingPage.assertText(testData, actual, packagingPage.EDIT_PACKAGE_INPUT_FIELD);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, testData);
		ReporterSuccess(testcaseName);
		flag = Boolean.TRUE;
		
	}
	
	//===========================================================================================================================
	
	
	@Test(priority = 4)
	public void TC_04_Validate_Cancel_Button() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		packagingPage.clickOnFixedLink();
		
		String testData = getRandomNumberString(4);
		String expected = "Packaging";
		
		packagingPage.typeInputPackageField(testData);
		packagingPage.clickEditPackageCancelButton();
		
		String actual = homePage.getPageTitle(expected);
		
		String screenshot = packagingPage.assertText(expected, actual, packagingPage.PAGE_TITLE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	//===========================================================================================================================
	

	@Test(priority = 5)
	public void TC_05_Validate_Factor_Link() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		packagingPage.clickOnFactorLink();
		String expected = "Add Factor Of:";
		String actual = packagingPage.newRowGetText();

		String screenshot = packagingPage.assertText(expected, actual, packagingPage.NEW_ROW);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	//===========================================================================================================================
	
	
	@Test(priority = 6)
	public void TC_06_Validate_ValueTable_Link() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		packagingPage.clickOnValueTableLink();

		String expected = "Add Value From Table:";
		String actual = packagingPage.newRowGetText();

		String screenshot = packagingPage.assertText(expected, actual, packagingPage.NEW_ROW);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	//===========================================================================================================================
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverNetPriceTab();
		packagingPage = homePage.clickPackagingLink();
		packagingPage.clickPackagingTabLink();
		packagingPage.clickStudentLoanCLink();
		
		if (packagingPage.getAssignmentPackageList().size() > 0) {
			packagingPage.deleteAssignmentPackages();
			packagingPage.clickEditPackageSaveButton();
			packagingPage.clickSaveChangesPopupYesButton();
			packagingPage.clickStudentLoanCLink();
		}
		

	}

	@AfterMethod
	public void AfterMethod() {
		if (flag) {
			if (packagingPage.getAssignmentPackageList().size() > 0) {
				packagingPage.deleteAssignmentPackages();
				packagingPage.clickEditPackageSaveButton();
				packagingPage.clickSaveChangesPopupYesButton();
			
			}
			
			flag = Boolean.FALSE;
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
