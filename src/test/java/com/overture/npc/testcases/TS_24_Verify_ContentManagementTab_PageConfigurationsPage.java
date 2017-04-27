package com.overture.npc.testcases;


import java.util.ArrayList;
import java.util.List;

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
import com.overture.npc.pages.PageConfigurationsPage;

public class TS_24_Verify_ContentManagementTab_PageConfigurationsPage extends CommonMethods {
	
	String homePageUrl;

	String className = this.getClass().getSimpleName();
	WebDriver driver = null;

	LoginPage loginPage = null;
	HomePage homePage = null;
	PageConfigurationsPage pageConfigPage = null;
	
	@Test(priority = 1)
	public void TC_01_Validate_ChooseFile_Button_Action() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		boolean expected = true;
		boolean actual = pageConfigPage.verifyIsBrowseButtonDisplayed();
		
		String screenshot = pageConfigPage.assertBoolean(expected, actual, pageConfigPage.BROWSER_BUTTON);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, "Browse Button is not Enabled");
		ReporterSuccess(testcaseName);

	}
	//===========================================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Upload_Button_Action() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);		
		
		ReporterLink(pageConfigPage.captureElementScreenShot(pageConfigPage.BROWSER_BUTTON), "Before Entering New Image File.");
		
		String fileName=System.getProperty("user.dir")+"/testBrowse/actualPic.jpg";

		pageConfigPage.enterFilePath(fileName);
		ReporterLink(pageConfigPage.captureElementScreenShot(pageConfigPage.BROWSER_BUTTON), "After Entering New Image File.");
		pageConfigPage.clickUploadButton();
		
		
		ReporterLink(pageConfigPage.captureElementScreenShot(pageConfigPage.LOGO), "After Uploading The New Image File.");
		
		boolean expected = false;
		boolean actual = pageConfigPage.verifyErrorMessageDisplayed();
		
		String screenshot = pageConfigPage.assertBoolean(expected, actual, pageConfigPage.BROWSER_BUTTON);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, "The uploaded image is not in correct format");
		ReporterSuccess(testcaseName);
		
		pageConfigPage.uploadOriginalImageFile();
		
	}
	//===========================================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_Upload_Button_Action_InvalidFile() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);		
		
		String expected="Error: File must be a jpg or a gif.";
		String actual = "";
		ReporterLink(pageConfigPage.captureElementScreenShot(pageConfigPage.BROWSER_BUTTON), "Before Entering New Image File.");
		
		String fileName=System.getProperty("user.dir")+"/testBrowse/invalidFormat.png";

		pageConfigPage.enterFilePath(fileName);
		ReporterLink(pageConfigPage.captureElementScreenShot(pageConfigPage.BROWSER_BUTTON), "After Entering New Image File.");
		pageConfigPage.clickUploadButton();

		if(pageConfigPage.verifyErrorMessageDisplayed()){
			actual = pageConfigPage.getErrorMessage();
		}else{
			actual = "Error Message Did not Trigger.";
		}
		String screenshot = pageConfigPage.assertText(expected, actual, pageConfigPage.ERROR_MESSAGE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		
	}
	//===========================================================================================================================
	
	//@Test(priority = 4)
	public void TC_04_Validate_Upload_Button_Action_InvalidImageSize() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);		
		
		String expected="Error: File is too big, please ensure that it is smaller than 100kb";
		String actual = "";
		ReporterLink(pageConfigPage.captureElementScreenShot(pageConfigPage.BROWSER_BUTTON), "Before Entering New Image File.");
		
		String fileName=System.getProperty("user.dir")+"/testBrowse/highSize.png";

		pageConfigPage.enterFilePath(fileName);
		ReporterLink(pageConfigPage.captureElementScreenShot(pageConfigPage.BROWSER_BUTTON), "After Entering New Image File.");
		pageConfigPage.clickUploadButton();

		if(pageConfigPage.verifyErrorMessageDisplayed()){
			actual = pageConfigPage.getErrorMessage();
		}else{
			actual = "Error Message Did not Trigger. Check Screenshot for details.";
		}
		String screenshot = pageConfigPage.assertText(expected, actual, pageConfigPage.ERROR_MESSAGE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		
	}
	//===========================================================================================================================
	
	@Test(priority = 5)
	public void TC_05_Validate_TextBoxes_Enable() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);	
		String screenshot = "";
		boolean expected = true;
		boolean actual = false;
		
		actual = pageConfigPage.verifyTexBoxEnabled(pageConfigPage.COHORT_AID_TEXT, "Verifying The cohort Ais % Text is enabled");
		screenshot = pageConfigPage.assertBoolean(expected, actual, pageConfigPage.COHORT_AID_TEXT);
		ReporterLink(screenshot, "COHORT_AID_TEXT");
		
		
		actual = pageConfigPage.verifyTexBoxEnabled(pageConfigPage.STATE_GRANT_TEXT, "Verifying The state grant Textbox is enabled");
		screenshot = pageConfigPage.assertBoolean(expected, actual, pageConfigPage.STATE_GRANT_TEXT);
		ReporterLink(screenshot, "STATE_GRANT_TEXT");
		
		
		actual = pageConfigPage.verifyTexBoxEnabled(pageConfigPage.INSTITUTIONAL_GRANT_TEXT, "Verifying The institutional grant Textbox is enabled");
		screenshot = pageConfigPage.assertBoolean(expected, actual, pageConfigPage.INSTITUTIONAL_GRANT_TEXT);
		ReporterLink(screenshot, "INSTITUTIONAL_GRANT_TEXT");
		
		
		actual = pageConfigPage.verifyTexBoxEnabled(pageConfigPage.INST_SCHOLARSHIP_TEXT, "Verifying The institutional Scholarship Textbox is enabled");
		screenshot = pageConfigPage.assertBoolean(expected, actual, pageConfigPage.INST_SCHOLARSHIP_TEXT);
		ReporterLink(screenshot, "INST_SCHOLARSHIP_TEXT");
		
		actual = pageConfigPage.verifyTexBoxEnabled(pageConfigPage.CONSOLIDATE_SELF_HELP_TEXT, "Verifying The Consolidated Self Help Textbox is enabled");
		screenshot = pageConfigPage.assertBoolean(expected, actual, pageConfigPage.CONSOLIDATE_SELF_HELP_TEXT);
		ReporterLink(screenshot, "CONSOLIDATE_SELF_HELP_TEXT");
		
		actual = pageConfigPage.verifyTexBoxEnabled(pageConfigPage.SCHOOL_DEFINED_FUND1, "Verifying The school defined fund 1 Textbox is enabled");
		screenshot = pageConfigPage.assertBoolean(expected, actual, pageConfigPage.SCHOOL_DEFINED_FUND1);
		ReporterLink(screenshot, "SCHOOL_DEFINED_FUND1");
		
		actual = pageConfigPage.verifyTexBoxEnabled(pageConfigPage.SCHOOL_DEFINED_FUND2, "Verifying The school defined fund 2 Textbox is enabled");
		screenshot = pageConfigPage.assertBoolean(expected, actual, pageConfigPage.SCHOOL_DEFINED_FUND2);
		ReporterLink(screenshot, "SCHOOL_DEFINED_FUND2");
		
	}
	//===========================================================================================================================
	
	@Test(priority = 6)
	public void TC_06_Validate_Sections_Availabilty() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);	
		
		String expectedList = "Image Selection, Percent Grant Aid, My Net Price, EFC/Grant Aid Display";
		ArrayList<String> expect = pageConfigPage.getExpectedArrayList(expectedList);
		
		List<WebElement> actualList = pageConfigPage.getSectionHeaders();
		
		for(int i=0; i<actualList.size();i++)
		{
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			
			String screenshot = pageConfigPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}	
		
	}
	
	//===========================================================================================================================
	
	@Test(priority = 7)
	public void TC_07_Validate_SaveChangesButton_Function() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);	
		
		String testData1="Student C",testData2="Student B";
		String actual=null,expected=null;
		
		ReporterLink(pageConfigPage.captureElementScreenShot(pageConfigPage.BROWSER_BUTTON), "Before Editing.");
		
		expected=pageConfigPage.selectingPageConfigurationImageSave(testData1, testData2);
		pageConfigPage.clickSaveChangesButton();
		pageConfigPage.clickYesSaveChangesPopup();
		
		actual=pageConfigPage.getFirstSelectedDropDown(pageConfigPage.BUBBLE_IMAGE_ONE);
		
		String screenshot = pageConfigPage.assertText(expected, actual, pageConfigPage.BUBBLE_IMAGE_ONE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		
	}
	
	//===========================================================================================================================
	
	@Test(priority = 8)
	public void TC_08_Validate_CancelButton_Function() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);	
		
		String testData1="Student C",testData2="Student B";
		String actual=null,expected=null;
		
		expected=pageConfigPage.selectingPageConfigurationImageCancel(testData1, testData2);
		pageConfigPage.clickCancelButton();
		
		actual=pageConfigPage.getFirstSelectedDropDown(pageConfigPage.BUBBLE_IMAGE_ONE);
		
		String screenshot = pageConfigPage.assertText(expected, actual, pageConfigPage.BUBBLE_IMAGE_ONE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	//===========================================================================================================================
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverContentManagementTab();
		pageConfigPage = homePage.clickPageConfigurationLink();
	}

	@AfterMethod
	public void AfterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
		driver = WebDriverManager.getWebDriver();
		loginPage = new LoginPage(driver);
		homePage = loginPage.login("pravinAdmin", "Password1!");
		homePageUrl = homePage.getURL(driver);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
