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
import com.overture.npc.pages.CostOfAttendancePage;
import com.overture.npc.pages.HomePage;
import com.overture.npc.pages.LoginPage;

public class TS_46_Verify_COA_RoomNBoard extends CommonMethods {
	String className = this.getClass().getSimpleName();
	String homePageUrl;
	WebDriver driver = null;
	boolean flag = false;

	LoginPage loginPage = null;
	HomePage homePage = null;
	CostOfAttendancePage COAPage = null;

	@Test(priority = 1)
	public void TC_01_Validate_RoomNBoardLink_Navigation() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expected = "Edit Expense - Room & Board";
		String actual = COAPage.getText(COAPage.PAGE_TITLE);

		String screenshot = COAPage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ======================================================================================================

	@Test(priority = 2)
	public void TC_02_Validate_RoomNBoardLink_FixedLink() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		COAPage.clickFixedLink();

		boolean expected = true;
		boolean actual = COAPage.rowOneDisplayed();

		String screenshot = COAPage.assertBoolean(expected, actual, COAPage.ROW_ONE);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, "The Row did not generate after clicking Fixed Link.");
		ReporterSuccess(testcaseName);
	}

	// ======================================================================================================

	@Test(priority = 3)
	public void TC_03_Validate_RoomNBoardLink_CancelButton() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		COAPage.clickCancelButton();

		String expected = "Cost of Attendance - Expenses";
		String actual = COAPage.getText(COAPage.PAGE_TITLE);

		String screenshot = COAPage.assertTitle(expected, actual);
		ReporterLink(screenshot);
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ======================================================================================================

	@Test(priority = 4)
	public void TC_04_Validate_RoomNBoardLink_SaveChangesButton() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		COAPage.clickSaveChangesButton();

		String expected = "Saving will overwrite any previously saved information. Please select Yes to continue.";

		String actual = COAPage.getPopupText();

		String screenshot = COAPage.assertText(expected, actual, COAPage.POPUP_TEXT);
		ReporterLink(screenshot);
		COAPage.clickNoButtonPopUp();
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
	}

	// ======================================================================================================

	@Test(priority = 5)
	public void TC_05_Validate_RoomNBoardLink_SaveChanges_popUP_OK_function() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String testData=getRandomNumberString(4);

		COAPage.clickFixedLink();
		COAPage.enterFixedValueOne(testData);
		COAPage.clickSaveChangesButton();
		COAPage.clickYesButtonPopUp();
		
		COAPage.clickRoomBoardLink();
		
		String expected = testData;
		String actual= COAPage.getFixedValueAttribute();
		
		String screenshot = COAPage.assertText(expected, actual, COAPage.FIXED_VALUE_ONE);
		ReporterLink(screenshot, "AFTER SAVE");
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		ReporterSuccess(testcaseName);
		flag=true;
	}

	// ======================================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverNetPriceTab();

		COAPage = homePage.clickCOALink();
		COAPage.clickRoomBoardLink();

		if (COAPage.elementSize(COAPage.COA_FIXED_ROWS) > 2) {
			COAPage.deleteCOAExpense();
		}
	}

	@AfterMethod
	public void AfterMethod() {
		if (flag) {
			COAPage.deleteRowOne();
			flag = false;
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
