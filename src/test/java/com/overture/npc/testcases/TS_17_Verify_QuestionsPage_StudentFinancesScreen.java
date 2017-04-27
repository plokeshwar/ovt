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
import com.overture.npc.pages.StudentInformationPage;


public class TS_17_Verify_QuestionsPage_StudentFinancesScreen extends CommonMethods {

	String className=this.getClass().getSimpleName();
	
	WebDriver driver = null;
	String homePageUrl;
	
	
	LoginPage loginPage = null;
	HomePage homePage = null;
	QuestionsPage questionPage=null;
	StudentInformationPage studentInfoPage=null;
	
	
	
	//==================================================================================================================
	@Test(priority = 1)
	public void TC_01_Validate_Accordion_Availability() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		ReporterText("General Header Accordion Link  exists: "+studentInfoPage.isDisplayed(studentInfoPage.GENERAL_HEADER_LINK));
		
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.GENERAL_HEADER_LINK), true,"General Header Accordion Link is not Displayed");
		
		String screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.GENERAL_HEADER_LINK);
		ReporterLink(screenshot, "General Accordion Availability.");
				
	}
	
	//==================================================================================================================
	@Test(priority = 2)
	public void TC_02_Validate_Buttons_Availability() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		ReporterText("Cancel Button exists: "+studentInfoPage.isDisplayed(studentInfoPage.CANCEL_BUTTON));
		ReporterText("Save Changes Button exists: "+studentInfoPage.isDisplayed(studentInfoPage.SAVE_BUTTON));
		studentInfoPage.performMouseOverSaveButton();
		
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.CANCEL_BUTTON), true,"Cancel Button is not Displayed");
		String screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.CANCEL_BUTTON);
		ReporterLink(screenshot, "Cancel Button Availability.");
		
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.SAVE_BUTTON), true,"Save Changes Button is not Displayed");
	
		screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.SAVE_BUTTON);
		ReporterLink(screenshot, "Save Button Availability.");
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverNetPriceTab();
		questionPage = homePage.clickQuestionsLink();
		studentInfoPage = questionPage.clickStudentFinancesLink();
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
