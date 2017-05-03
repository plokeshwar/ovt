package com.overture.npc.testcases;
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
import com.overture.npc.pages.HomePage;
import com.overture.npc.pages.LoginPage;
import com.overture.npc.pages.PackagingPage;
import com.overture.npc.pages.QuestionsPage;
import com.overture.npc.pages.StudentInformationPage;



public class TS_21_Verify_PackagingPage_GlobalSettingsTable extends CommonMethods {
	
String className=this.getClass().getSimpleName();
	
	WebDriver driver = null;
	String homePageUrl;
	
	
	LoginPage loginPage = null;
	HomePage homePage = null;
	QuestionsPage questionPage=null;
	StudentInformationPage studentInfoPage=null;
	PackagingPage packagingPage;
	
	
	//@Test(priority = 1)
	public void TC_01_Validate_AvailabilityOfTwo_Tables_in_GlobalSettingsTab() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		String expectedList = "Manage Cap Limit, Manage Floor Limit";
		
		TreeSet<String> expect = packagingPage.createTreeSetList(expectedList);
		TreeSet<String> actualList = packagingPage.getAllLinksFromGlobalSettingsTable();
		
		String screenshot = packagingPage.assertObjects(expect, actualList);
		ReporterLink(screenshot);
		Assert.assertEquals(actualList, expect,"The actual and expected list do not match.");	
			
			
	}
	//===========================================================================================================================


	
	//@Test(priority = 2)
	public void TC_02_Validate_Checkbox_Enabled_CapLimit() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		System.out.println("Asserting the test case");
		
		boolean expected = true;
		boolean actual = packagingPage.validateCheckboxCapLimit();

		String screenshot = packagingPage.assertBoolean(expected, actual, packagingPage.GLOBAL_SETTINGS_GLOBAL_CAPLIST);
		ReporterLink(screenshot);
		Assert.assertEquals(actual, expected, "One of the check boxes are disabled.");
	}
	//===========================================================================================================================
	
	
	//@Test(priority = 3)
	public void TC_03_Validate_Checkbox_Enabled_FloorLimit() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		boolean expected = true;
		boolean actual = packagingPage.validateCheckboxFloorLimit();

		String screenshot = packagingPage.assertBoolean(expected, actual, packagingPage.GLOBAL_SETTINGS_GLOBAL_FLOORLIST);
		ReporterLink(screenshot);
		Assert.assertEquals(actual, expected, "One of the check boxes are disabled.");
	}
	//===========================================================================================================================
	
	//@Test(priority = 5)
	public void TC_05_Validate_CapLimitAmount_ValidData() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		System.out.println("Asserting the test case");
		packagingPage.globalSettingsTextBoxValidator_Valid(packagingPage.GLOBAL_SETTINGS_GLOBAL_CAPLIST, "123");
	}
	
	//===========================================================================================================================
	
	//@Test(priority = 6)
	public void TC_06_Validate_FloorLimitAmount_ValidData() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		ReporterText("Validating Test Boxes with Valid Data.");
		packagingPage.globalSettingsTextBoxValidator_Valid(packagingPage.GLOBAL_SETTINGS_GLOBAL_FLOORLIST, "123");
	}
	
	//===========================================================================================================================


	@Test(priority = 7)
	public void TC_07_Validate_CapLimitAmount_InvalidData() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		ReporterText("Validating Test Boxes with Valid Data.");
		boolean expected = true;
		boolean actual =	packagingPage.globalSettingsTextBoxValidator_Invalid(packagingPage.GLOBAL_SETTINGS_GLOBAL_CAPLIST, "ABC");
		String screenshot = packagingPage.assertBoolean(expected, actual, packagingPage.GLOBAL_SETTINGS_GLOBAL_CAPLIST);
		ReporterLink(screenshot);
		Assert.assertEquals(actual, expected);
	}
	
	//===========================================================================================================================

	@Test(priority = 8)
	public void TC_08_Validate_FloorLimitAmount_InvalidData() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		ReporterText("Validating Test Boxes with Valid Data.");
		boolean expected = true;
		boolean actual = packagingPage.globalSettingsTextBoxValidator_Invalid(packagingPage.GLOBAL_SETTINGS_GLOBAL_FLOORLIST, "ABC");
		String screenshot = packagingPage.assertBoolean(expected, actual, packagingPage.GLOBAL_SETTINGS_GLOBAL_FLOORLIST);
		ReporterLink(screenshot);
		Assert.assertEquals(actual, expected);

	}
	
	//===========================================================================================================================
	
	
	//@Test(priority = 9)
	public void TC_09_Validate_SaveChanges_Button_Action() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expected="Are you sure you want to save?";
		
		packagingPage.clickGlobalSettingsTabLink();
		packagingPage.clickGlobalSettingsSaveButton();
		
		String actual=packagingPage.getAlertText();
		
		packagingPage.dismissAlert();
		
		String screenshot = packagingPage.assertText(expected, actual, packagingPage.GLOBAL_SETTINGS_TAB_LINK);
		ReporterLink(screenshot, "Alert ScreenShot Not Taken as Validating PopUP Existence");
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	//============================================================================================
	
	
	//@Test(priority = 10)
	public void TC_10_Validate_Cancel_Button_Action() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		packagingPage.clickGlobalSettingsTabLink();
		packagingPage.clickGlobalSettingsCancelButton();
		
		boolean expected = true;
		boolean actual = packagingPage.isEnabled(packagingPage.PACKAGING_TAB_LINK);
		
		String screenshot = packagingPage.assertBoolean(expected, actual, packagingPage.PACKAGING_TAB_LINK);
		ReporterLink(screenshot, "Cancel Button Status");
		Assert.assertEquals(actual, expected, "One of the check boxes are disabled.");
		
	}
	
	//============================================================================================
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverNetPriceTab();
		packagingPage = homePage.clickPackagingLink();
		packagingPage.clickGlobalSettingsTabLink();
		
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