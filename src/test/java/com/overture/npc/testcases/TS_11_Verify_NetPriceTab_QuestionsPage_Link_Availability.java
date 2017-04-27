package com.overture.npc.testcases;

import java.util.ArrayList;
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
import com.overture.npc.pages.QuestionsPage;


public class TS_11_Verify_NetPriceTab_QuestionsPage_Link_Availability extends CommonMethods{

	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	String homePageUrl;
	
	LoginPage loginPage = null;
	HomePage homePage = null;
	QuestionsPage questionPage=null;
	
	
	@Test(priority = 1)
	public void TC_01_Validate_Link_Availability_In_Questions() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expectedList = "Student Information, Parent Household, Parent Income, Parent Assets, Student Finances";

		questionPage = homePage.clickQuestionsLink();

		TreeSet<String> expect = questionPage.createTreeSetList(expectedList);
		
		TreeSet<String> actual = questionPage.getAllQuestionTableLinks();

		ReporterLink(homePage.captureElementScreenShot(questionPage.QUESTION_TABLE));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
		ReporterSuccess(testcaseName);
	}

	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverNetPriceTab();
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
