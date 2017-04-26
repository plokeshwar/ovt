package com.overture.npc.testcases;

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
import com.overture.npc.common.Reporting;
import com.overture.npc.common.WebDriverManager;
import com.overture.npc.pages.AccountSettingsPage;
import com.overture.npc.pages.HomePage;
import com.overture.npc.pages.LoginPage;

public class TS_04_Verify_AccountTab_AccountSettingsPage extends CommonMethods {

	String className = this.getClass().getSimpleName();
	WebDriver driver = null;
	String homePageUrl;
	LoginPage loginPage = null;
	HomePage homePage = null;
	AccountSettingsPage accountSettingPage = null;

	@Test(priority = 1)
	public void TC_01_Validate_Save_Changes_Button() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expected = "Do you want to save the changes??";

		accountSettingPage.clickSaveChangesButton();

		String actual = accountSettingPage.getSaveChangesPopupText();

		String screenshot = accountSettingPage.assertPopUPText(expected, actual);
		ReporterLink(screenshot);
		accountSettingPage.clickSaveChangesPopupNoButton();

		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ============================================================================================

	@Test(priority = 2)
	public void TC_02_Validate_Pop_UP_OK_Function() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String tempActual = "";
		String tempExpected = "";

		String beforeScreenshot = accountSettingPage.captureElementScreenShot(accountSettingPage.AID_YEAR_DROPDOWN);
		ReporterLink(beforeScreenshot, "Before Change.");

		tempExpected = accountSettingPage.switchingAidYear();

		accountSettingPage.clickSaveChangesButton();
		accountSettingPage.clickSaveChangesPopupYesButton();
		String expected = "Settings were saved successfully";
		String actual = accountSettingPage.getMessageText();
		String screenshot = accountSettingPage.assertMessageText(expected, actual);
		ReporterLink(screenshot, "Saved Successfully.");

		tempActual = accountSettingPage.getFirstSelectedDropDown(accountSettingPage.AID_YEAR_DROPDOWN);

		String afterScreenshot = accountSettingPage.assertText(tempExpected, tempActual,
				accountSettingPage.AID_YEAR_DROPDOWN);
		ReporterLink(afterScreenshot, "After Change.");
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}
	// ============================================================================================

	@Test(priority = 3)
	public void TC_03_Validate_Pop_UP_Cancel_Function() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String beforeScreenshot = accountSettingPage.captureElementScreenShot(accountSettingPage.AID_YEAR_DROPDOWN);
		ReporterLink(beforeScreenshot, "Before Change.");

		String expected = accountSettingPage.getFirstSelectedDropDown(accountSettingPage.AID_YEAR_DROPDOWN);
		accountSettingPage.switchingAidYear();

		accountSettingPage.clickSaveChangesButton();

		accountSettingPage.clickSaveChangesPopupNoButton();

		homePage.clickAccountSettingsLink();

		String actual = accountSettingPage.getFirstSelectedDropDown(accountSettingPage.AID_YEAR_DROPDOWN);

		String screenshot = accountSettingPage.assertMessageText(expected, actual);
		ReporterLink(screenshot, "After Change.");

		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);

	}
	// ============================================================================================

	@Test(priority = 4)
	public void TC_04_Validate_Cancel_Button() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String beforeScreenshot = accountSettingPage.captureElementScreenShot(accountSettingPage.AID_YEAR_DROPDOWN);
		ReporterLink(beforeScreenshot, "Before Change.");

		String expected = accountSettingPage.getFirstSelectedDropDown(accountSettingPage.AID_YEAR_DROPDOWN);
		accountSettingPage.switchingAidYear();

		accountSettingPage.clickCancelButton();

		String actual = accountSettingPage.getFirstSelectedDropDown(accountSettingPage.AID_YEAR_DROPDOWN);

		String afterScreenshot = accountSettingPage.assertText(expected, actual, accountSettingPage.AID_YEAR_DROPDOWN);
		ReporterLink(afterScreenshot, "After Change.");
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);

	}
	// ============================================================================================

	/*
	 * @Test(priority = 5) public void TC_05_Validate_Aid_Year_DropDown() {
	 * String ScreenshotName = new
	 * Object(){}.getClass().getEnclosingMethod().getName();
	 * 
	 * cm.ReporterText("TestCase : " + ScreenshotName);
	 * 
	 * String expectedList="--Select--,2015-16,2016-17";
	 * 
	 * ArrayList<String> expected = cm.createArrayList(expectedList);
	 * ArrayList<String> actual = cm.dropdownValueFinder(driver,
	 * accountSettingPage.aidYear);
	 * 
	 * co.click(accountSettingPage.aidYear,
	 * "Clicking on the Aid-Year drop down list.");
	 * 
	 * cm.captureDriverScreenShot(driver, ScreenshotName, cm.basepath());
	 * Reporter.log(cm.ReporterText(cm.ReporterLink(ScreenshotName)));
	 * System.out.println("Asserting the test case");
	 * Assert.assertEquals(actual, expected); }
	 * 
	 */

	// ============================================================================================

	@Test(priority = 6)
	public void TC_06_Validate_Calculation_Radio_Button() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		String calcRoundingIDAtrribute = null;
		List<WebElement> calcRounding = null;

		String beforeScreenshot = accountSettingPage.captureElementScreenShot(accountSettingPage.CALC_ROUNDING_RADIO_BUTTON);
		ReporterLink(beforeScreenshot, "Before Change.");
		
		calcRounding = accountSettingPage.getCalcRoundingRadioButtons();
		for (WebElement s1 : calcRounding) {
			if (s1.getAttribute("checked") == null) {
				calcRoundingIDAtrribute = s1.getAttribute("id");
				accountSettingPage.click(s1);
				break;
			}
		}

		accountSettingPage.clickSaveChangesButton();
		accountSettingPage.clickSaveChangesPopupYesButton();
		
		String expected = "Settings were saved successfully";
		String actual = accountSettingPage.getMessageText();
		String screenshot = accountSettingPage.assertMessageText(expected, actual);
		ReporterLink(screenshot, "Saved Successfully.");
		

		homePage.clickAccountSettingsLink();

		calcRounding = accountSettingPage.getCalcRoundingRadioButtons();
		for (WebElement s1 : calcRounding) {
			if (s1.getAttribute("checked") != null && s1.getAttribute("checked").equals("true")) {
				
				String afterScreenshot = accountSettingPage.assertText(calcRoundingIDAtrribute, s1.getAttribute("id"), accountSettingPage.CALC_ROUNDING_RADIO_BUTTON);
				ReporterLink(afterScreenshot, "After Change.");
				System.out.println("Asserting the test case");
				Assert.assertEquals(calcRoundingIDAtrribute, s1.getAttribute("id"),
						"Before and After CalcRounding RadioButton Not Matching");
				break;
			}

		}

	}
	// =======================================================================
	// =====================

	@Test(priority = 9)
	public void TC_09_Validate_School_Maintainance_Radio_Button() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		for (WebElement s1 : accountSettingPage.getMaintainenceRadioButtons()) {
			if (s1.getAttribute("checked") == null && s1.getAttribute("id").equalsIgnoreCase("enableSite1")) {
				accountSettingPage.click(s1);
			} else if (s1.getAttribute("checked") == null && s1.getAttribute("id").equalsIgnoreCase("enableSite2")) {
				accountSettingPage.click(s1);
				break;
			}
		}

		String expected = "You have put your Net Price Calculator on hold. Do you want be redirected to edit the Maintenance Page Content?";
		String actual = accountSettingPage.getMaintainencePopupText();

		String screenshot = accountSettingPage.assertText(expected, actual, accountSettingPage.SITE_ON_HOLD_POPUP_CONTENT);
		ReporterLink(screenshot);
		
		accountSettingPage.clickSiteMaintainenceSiteNoThanksButton();
		
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
	}

	// ============================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverAccountTab();
		accountSettingPage = homePage.clickAccountSettingsLink();
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
