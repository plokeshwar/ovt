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

public class TS_20_Verify_PackagingPage_PackagingTable extends CommonMethods{
	
String className=this.getClass().getSimpleName();
	
	WebDriver driver = null;
	String homePageUrl;
	
	
	LoginPage loginPage = null;
	HomePage homePage = null;
	QuestionsPage questionPage=null;
	StudentInformationPage studentInfoPage=null;
	PackagingPage packagingPage;
	
	
	@Test(priority = 1)
	public void TC_01_Validate_Packages_List() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		String expectedList = "Parent Contribution, Student Contribution, Pell Grant, Institutional Scholarship - A, Institutional Grant - A, State Grant - A, Student Work, Student Loan - A, Parent Loan, Consolidated Self Help, Institutional Scholarship - B, Institutional Grant - B, State Grant - B, Student Loan - B, Institutional Scholarship - C, Institutional Grant - C, State Grant - C, Student Loan - C, School Defined Fund1, School Defined Fund2";
		TreeSet<String> expect = packagingPage.createTreeSetList(expectedList);
		TreeSet<String> actual = packagingPage.getAllLinksFromPackageTable();

		String screenshot = packagingPage.assertObjects(expect, actual);
		ReporterLink(screenshot);
		Assert.assertEquals(actual, expect,"The actual and expected list do not match.");	
			
	}
	//===========================================================================================================================

	/*
	@Test(priority = 2)
	public void TC_02_Validate_ParentContribution_StudentContribution_PellGrant_DefaultActive() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		
		Reporter.log(cm.ReporterText("Validating If Parent Contribution Active Status is Active By Default."));
		cm.captureElementScreenShot(driver, packagingPage.parentContributionActiveStatus, ScreenshotName+"_Parent", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"_Parent"));
		Assert.assertEquals(packagingPage.parentContributionActiveStatus.isEnabled(), true,"Parent Contribution Activity Status is Not Enabled.");
		
		Reporter.log(cm.ReporterText("Validating If Student Contribution Active Status is Active By Default."));
		cm.captureElementScreenShot(driver, packagingPage.studentContributionActiveStatus, ScreenshotName+"_Student", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"_Student"));
		Assert.assertEquals(packagingPage.parentContributionActiveStatus.isEnabled(), true,"Parent Contribution Activity Status is Not Enabled.");
		
		Reporter.log(cm.ReporterText("Validating If Pell Grant Active Status is Active By Default."));
		cm.captureElementScreenShot(driver, packagingPage.pellGrantActiveStatus, ScreenshotName+"_PellGrant", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"_PellGrant"));
		Assert.assertEquals(packagingPage.pellGrantActiveStatus.isEnabled(), true,"Pell Grant Activity Status is Not Enabled.");
	}
	//===========================================================================================================================

	@Test(priority = 3)
	public void TC_03_Validate_NonDefault_Packages_Checkbox_Enabled() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);
		System.out.println("Asserting the test case");
		Assert.assertEquals(co.findCheckboxEnabled(driver, packagingPage.nonDefaultPackageList), true,"One of the check boxes are disabled.");
	}
	//===========================================================================================================================

	@Test(priority = 4)
	public void TC_04_Validate_SaveChanges_Button_Action() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		String expected="Are you sure you want to save?";
		
		co.click(packagingPage.packagingTabSaveChangesButton, "Clicking Save Changes Button in Packaging Page.");

		String actual=co.alertHandler(driver).getText();
		
		co.alertHandler(driver).dismiss();
		
		Reporter.log(cm.ReporterText("Screen Shot Not Taken, as Validating Pop-up."));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
	}
	
	//============================================================================================
	*/
	
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