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



public class TS_13_Verify_QuestionsPage_StudentInformationScreen extends CommonMethods{

	String className=this.getClass().getSimpleName();
	
	WebDriver driver = null;
	String homePageUrl;
	
	LoginPage loginPage = null;
	HomePage homePage = null;
	QuestionsPage questionPage=null;
	StudentInformationPage studentInfoPage=null;
	
	

	@Test(priority = 1)
	public void TC_01_Validate_Accordion_Availability() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		ReporterText("General Header Accordion Link  exists: "+studentInfoPage.isDisplayed(studentInfoPage.GENERAL_HEADER_LINK));
		ReporterText("Academics Header Accordion Link  exists: "+studentInfoPage.isDisplayed(studentInfoPage.ACADEMICS_HEADER_LINK));
		ReporterText("Activities Header Accordion Link  exists: "+studentInfoPage.isDisplayed(studentInfoPage.ACTIVITIES_HEADER_LINK));
		ReporterText("Faith Header Accordion Link  exists: "+studentInfoPage.isDisplayed(studentInfoPage.FAITH_HEADER_LINK));
		ReporterText("Family Header Accordion Link  exists: "+studentInfoPage.isDisplayed(studentInfoPage.FAMILY_HEADER_LINK));
		ReporterText("Campuses and Schools Header Accordion Link  exists: "+studentInfoPage.isDisplayed(studentInfoPage.CAMPUSES_HEADER_LINK));
		ReporterText("Upper Class and Transfer Students Header Accordion Link  exists: "+studentInfoPage.isDisplayed(studentInfoPage.UPPER_CLASS_HEADER_LINK));
		
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.GENERAL_HEADER_LINK), true,"General Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.ACADEMICS_HEADER_LINK), true,"Academics Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.ACTIVITIES_HEADER_LINK), true,"Activities Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.FAITH_HEADER_LINK), true,"Faith Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.FAMILY_HEADER_LINK), true,"Family Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.CAMPUSES_HEADER_LINK), true,"Campuses and Schools Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.UPPER_CLASS_HEADER_LINK), true,"Upper Class and Transfer Students Header Accordion Link is not Displayed");
		
		
	}
	//=======================================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Buttons_Availability() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		ReporterText("Cancel Button exists: "+studentInfoPage.isDisplayed(studentInfoPage.CANCEL_BUTTON));
		ReporterText("Save Changes Button exists: "+studentInfoPage.isDisplayed(studentInfoPage.SAVE_BUTTON));
		studentInfoPage.performMouseOverSaveButton();
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.CANCEL_BUTTON), true,"Cancel Button is not Displayed");
		Assert.assertEquals(studentInfoPage.isDisplayed(studentInfoPage.SAVE_BUTTON), true,"Save Changes Button is not Displayed");
		
		String screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.FORM_PARAGRAPH);
		ReporterLink(screenshot);
		
	}
	
	//=======================================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_Accordion_Functionality() {
		String ScreenshotName1 = "Validate_Accordion_Functionality1";
		String ScreenshotName2 = "Validate_Accordion_Functionality2";
		String ScreenshotName3 = "Validate_Accordion_Functionality3";
		String ScreenshotName4 = "Validate_Accordion_Functionality4";
		String ScreenshotName5 = "Validate_Accordion_Functionality5";
		String ScreenshotName6 = "Validate_Accordion_Functionality6";
		String ScreenshotName7 = "Validate_Accordion_Functionality7";
		String ScreenshotName8 = "Validate_Accordion_Functionality8";
		
		ReporterText("TestCase : " + ScreenshotName1);
		ReporterText("TestCase : " + ScreenshotName2);
		ReporterText("TestCase : " + ScreenshotName3);
		ReporterText("TestCase : " + ScreenshotName4);
		ReporterText("TestCase : " + ScreenshotName5);
		ReporterText("TestCase : " + ScreenshotName6);
		ReporterText("TestCase : " + ScreenshotName7);
		ReporterText("TestCase : " + ScreenshotName8);
		
		ReporterText("General Table Exists: "+studentInfoPage.isDisplayed(studentInfoPage.GENERAL_TABLE));
		String screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.GENERAL_TABLE);
		ReporterLink(screenshot, "General Table.");
				
		studentInfoPage.clickOnAcademicsHeaderLink();
		ReporterText("Academic Table Exists: "+studentInfoPage.isDisplayed(studentInfoPage.ACADEMICS_TABLE));
		screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.ACADEMICS_TABLE);
		ReporterLink(screenshot, "Academics Table.");
		
		studentInfoPage.clickOnActivitiesHeaderLink();
		ReporterText("Activities Table Exists: "+studentInfoPage.isDisplayed(studentInfoPage.ACTIVITIES_TABLE));
		screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.ACTIVITIES_TABLE);
		ReporterLink(screenshot, "Activities Table.");
		
		studentInfoPage.clickOnFaithHeaderLink();
		ReporterText("Faith Table Exists: "+studentInfoPage.isDisplayed(studentInfoPage.FAITH_TABLE));
		screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.FAITH_TABLE);
		ReporterLink(screenshot, "Faith Table.");
		
		studentInfoPage.clickOnFamilyHeaderLink();
		ReporterText("Family Table Exists: "+studentInfoPage.isDisplayed(studentInfoPage.FAMILY_TABLE));
		screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.FAMILY_TABLE);
		ReporterLink(screenshot, "Family Table.");
		
		studentInfoPage.clickOnCampusesHeaderLink();
		ReporterText("Campuses & Schools Table Exists: "+studentInfoPage.isDisplayed(studentInfoPage.CAMPUSES_TABLE));
		screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.CAMPUSES_TABLE);
		ReporterLink(screenshot, "Campuses Table.");
		
		studentInfoPage.clickOnUpperClassHeaderLink();
		ReporterText("Upper Class and Transfer Students Table Exists: "+studentInfoPage.isDisplayed(studentInfoPage.UPPER_CLASS_TABLE));
		screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.UPPER_CLASS_TABLE);
		ReporterLink(screenshot, "Upper Class Table.");
		
		studentInfoPage.clickOnOtherSpecificHeaderLink();
		ReporterText("Other School Specific Table Exists: "+studentInfoPage.isDisplayed(studentInfoPage.OTHER_SCHOOL_SPECIFIC_TABLE));
		
		screenshot = studentInfoPage.captureElementScreenShot(studentInfoPage.OTHER_SCHOOL_SPECIFIC_TABLE);
		ReporterLink(screenshot, "Other Specific Table.");
		
	}
	//=========================================================================================================================
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverNetPriceTab();
		questionPage = homePage.clickQuestionsLink();
		studentInfoPage = questionPage.clickStudentInformationLink();
	
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
