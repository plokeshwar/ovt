package com.overture.npc.testcases;

import org.testng.annotations.Test;

import com.overture.npc.common.CommonMethods;
import com.overture.npc.common.Reporting;
import com.overture.npc.common.WebDriverFactory;
import com.overture.npc.common.WebDriverManager;
import com.overture.npc.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TS_00_ValidateForgotPassword extends CommonMethods{
	
	WebDriver driver;
	LoginPage loginPage;
	String expected, actual;
	
	
	
	@Test(priority=1)
	public void TC_01_ValidateResetPasswordPopUp() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);
		
		expected = "Password Reset Request";
		loginPage.clickForgotPasswordLink();
		actual = loginPage.getPasswordResetBoxTitle();
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	
	@Test(priority=2)
	public void TC_02_ValidateSuccessfulResetPassword() {
		String testcaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : "+testcaseName);
		
		expected = "A new password has been emailed.";
		
		loginPage.enterResetUserID("seoAdmin");
		loginPage.enterResetUserEmailAddress("gseo@overturecorp.com");
		loginPage.clickResetPasswordOkButton();
		
		actual = loginPage.getErrorText();
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	@BeforeMethod
	public void beforeMethod() {
		loginPage = new LoginPage(driver);
		
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
		driver = WebDriverManager.getWebDriver();
		loginPage = new LoginPage(driver);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}


}
