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

public class TS_01_ValidateLogin extends CommonMethods{
	String homePageUrl;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	String actual, expected;
	
	@Test(priority=1)
	public void TC_01_ValidLoginCredentials() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);
		
		expected = "Account Settings | NPC School Admin";
		homePage = loginPage.login("pravinAdmin", "Password1!");
		actual = driver.getTitle();

		homePage.clickSignout();
		homePage.navigateToLoginPage();
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	@Test(priority=2)
	public void TC_02_InvalidLoginCredentials() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);
		expected = "Error: Invalid Login";
		loginPage.login("pravinAdmin", "Password1!!");
		actual = loginPage.getErrorText();
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}


	@BeforeMethod
	public void beforeMethod() {
		
		
	}

	@AfterMethod
	public void afterMethod() {
		actual = null;
		expected = null;
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
