package com.overture.npc.testcases;

import java.util.ArrayList;
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


@Test(priority=4)
public class TS_07_Verify_AccountTab_School_PreviewPage extends CommonMethods{

	String className=this.getClass().getName().substring(27);
	WebDriver driver = null;
	String homePageUrl;
	
	LoginPage loginPage = null;
	HomePage homePage = null;
	SchoolPreviewPage schoolPreviewPage = null;
	//Add_N_Edit_TestCasePage add_N_Edit_testCasePage=null;
	
	static boolean flag=false;
	WebElement element=null;
	
	@Test(priority = 1)
	public void TC_01_Validate_AddTestCase_Button_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		String expected="Add Test Case";
		schoolPreviewPage.clickAddTestCase();
		String actual = schoolPreviewPage.getHeaderText();
		
		String screenshot = schoolPreviewPage.assertText(expected, actual,schoolPreviewPage.HEADER_TEXT);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	//============================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_TestCaseTable_Columns() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		String expectedList ="Name, Last Updated, Results, Student Experience";
		ArrayList<String> expected = schoolPreviewPage.generateArrayList(expectedList);
		ArrayList<String> actual=schoolPreviewPage.getColumnHeader();
		String screenshot = schoolPreviewPage.assertText(expected, actual,schoolPreviewPage.PREVIEW_TABLE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	//============================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_TestCaseTable_NameLink_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		String testData="TestName : "+String.valueOf(System.currentTimeMillis());
		
		schoolPreviewPage.clickAddTestCase();
		schoolPreviewPage.enterTestCaseName(testData);
		schoolPreviewPage.clickSaveButton();
		
		element=driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData+"')]"));
		
		String screenshot = schoolPreviewPage.assertText(String.valueOf(true), String.valueOf(element.isDisplayed()), element);
		ReporterLink(screenshot, "Test Case Created");
		System.out.println("Asserting test case creation");
		Assert.assertEquals(element.isDisplayed(), true);
		ReporterSuccess(testcaseName);
		
		element.click();
		
		String expected = "Edit Test Case: "+testData;
		String actual= schoolPreviewPage.getHeaderText();
		
		String screenshot1 = schoolPreviewPage.assertText(expected, actual,schoolPreviewPage.HEADER_TEXT);
		ReporterLink(screenshot1);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		flag=true;
		
	}
	//============================================================================================
	
	
	/*@Test(priority = 4)
	public void TC_04_Validate_TestCaseTable_LastUpdateDate() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		String testData="TestName : "+String.valueOf(System.currentTimeMillis());
		
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String expected=dateFormat.format(date);
		
		schoolPreviewPage.clickAddTestCase();
		schoolPreviewPage.enterTestCaseName(testData);
		schoolPreviewPage.clickSaveButton();
		
		element=driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData+"')]"));
		String screenshot = schoolPreviewPage.assertText(String.valueOf(true), String.valueOf(element.isDisplayed()), element);
		ReporterLink(screenshot, "Test Case Created");
		System.out.println("Asserting test case creation");
		Assert.assertEquals(element.isDisplayed(), true);
		ReporterSuccess(testcaseName);
		
		WebElement newElement=driver.findElement(By.xpath("//table[@id='preview-list']//tr[contains(.,'"+testData+"')]//td[2]"));
		
		
		String actual=newElement.getText();
		String screenshot1 = schoolPreviewPage.assertText(expected, actual,newElement);
		ReporterLink(screenshot1);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		
		flag=true;
		
		
	}*/
	
	//=====================================================================================================================
	@BeforeMethod
	public void BeforeMethod() {
		schoolPreviewPage = homePage.clickPreviewLink();
		
		
	}

	@AfterMethod
	public void AfterMethod() {
		
		if(flag){
			ReporterText("Deleting the Test Case Created");
			try{
				element.click();
			}catch (Exception e) {
				
			}
			
			schoolPreviewPage.clickDeleteButton();
			schoolPreviewPage.acceptAlert();
			flag=false;
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
