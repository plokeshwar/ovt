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
import com.overture.npc.pages.StudentInformationPage;

public class TS_19_Verify_NetPriceTab_PackagingPage extends CommonMethods {
	

	String className=this.getClass().getSimpleName();
	
	WebDriver driver = null;
	String homePageUrl;
	
	
	LoginPage loginPage = null;
	HomePage homePage = null;
	QuestionsPage questionPage=null;
	StudentInformationPage studentInfoPage=null;
	PackagingPage packagingPage;
	
	
	@Test(priority = 1)
	public void TC_01_Validate_Tabs_Availability_Packaging_N_Global() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		String expected = "Packaging";
		
		packagingPage.clickPackagingTabLink();
		
		String screenshot = packagingPage.captureElementScreenShot(packagingPage.PACKAGING_TAB_LINK);
		ReporterLink(screenshot, "PACKAGING TAB.");
		packagingPage.assertText(expected, packagingPage.getPackagingTabText(), packagingPage.PACKAGING_TAB_LINK);
		
		packagingPage.clickGlobalSettingsTabLink();

		screenshot = packagingPage.captureElementScreenShot(packagingPage.GLOBAL_SETTINGS_TAB_LINK);
		ReporterLink(screenshot, "GLOBAL SETTINGS TAB.");
		
		expected = "Global Settings";
		packagingPage.assertText(expected, packagingPage.getGlobalSettingsTabText(), packagingPage.GLOBAL_SETTINGS_TAB_LINK);
		
		Assert.assertEquals(packagingPage.getGlobalSettingsTabText(), expected, "Global Settings Tab Not Available");
		
	}
	//===========================================================================================================================

	
	
	@Test(priority = 2)
	public void TC_02_Validate_Packaging_Tab_Enabled_On_Clicking() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		packagingPage.clickPackagingTabLink();
		
		String screenshot = packagingPage.captureElementScreenShot(packagingPage.PACKAGING_TABLE);
		ReporterLink(screenshot, "PACKAGING TABLE.");
		boolean actual = packagingPage.isDisplayed(packagingPage.PACKAGING_TABLE);
		packagingPage.assertBoolean(true, actual , packagingPage.PACKAGING_TABLE);
		Assert.assertEquals(packagingPage.isDisplayed(packagingPage.PACKAGING_TABLE), true, "Packaging Table is Not Enabled");
		
	}
	//===========================================================================================================================

	
	@Test(priority = 3)
	public void TC_03_Validate_Account_Settings_Tab_Enabled_On_Clicking() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		packagingPage.clickGlobalSettingsTabLink();
		
		String screenshot = packagingPage.captureElementScreenShot(packagingPage.GLOBAL_SETTINGS_TABLE);
		ReporterLink(screenshot, "GLOBAL SETTINGS TABLE.");
		boolean actual = packagingPage.isDisplayed(packagingPage.GLOBAL_SETTINGS_TABLE);
		packagingPage.assertBoolean(true, actual , packagingPage.GLOBAL_SETTINGS_TABLE);
		Assert.assertEquals(packagingPage.isDisplayed(packagingPage.GLOBAL_SETTINGS_TABLE), true, "Global Settings Table is Not Enabled");
	}
	//===========================================================================================================================

	
	

	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverNetPriceTab();
		packagingPage = homePage.clickPackagingLink();
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
