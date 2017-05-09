package com.overture.npc.testcases;

import java.util.ArrayList;
import java.util.List;

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
import com.overture.npc.pages.ContentEditorPage;
import com.overture.npc.pages.HomePage;
import com.overture.npc.pages.LoginPage;

public class TS_31_Verify_ContentEditorPage_ParentAssetsInformationLink extends CommonMethods {
	
	String homePageUrl;

	String className = this.getClass().getSimpleName();
	WebDriver driver = null;

	LoginPage loginPage = null;
	HomePage homePage = null;
	ContentEditorPage contentEditorPage = null;
	
	@Test(priority = 1)
	public void TC_01_Validate_ViewDefault_Links() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expectedList = "View Default";
		

		ArrayList<String> expect = contentEditorPage.getExpectedArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_SUBLINKS);

		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();

			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}

		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	//===========================================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_PopUps_ContentRegion() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		
		String [] expectedList ={"Parent Assets Information - Helpful Information"};
		
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);

		for (int i = 0; i < actualList.size(); i++) {
			List<WebElement> actualListnew = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
			ReporterText("Clicking on " + actualListnew.get(i).getText());
			contentEditorPage.click(actualListnew.get(i));

			ReporterText("Pop Up exists: " + contentEditorPage.isDisplayed(contentEditorPage.POP_UP_HEADER_COMMON_APP));

			String actual = contentEditorPage.getText(contentEditorPage.POP_UP_HEADER_COMMON_APP);
			ReporterText(actual);

			String screenshot = contentEditorPage.assertText(expectedList[i], actual,
					contentEditorPage.POP_UP_HEADER_COMMON_APP);
			ReporterLink(screenshot, actual);

			contentEditorPage.clickOnPopUpCloseButton();
			contentEditorPage = new ContentEditorPage(driver);
		}

	}
	//===========================================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_PopUps_DefaultContent() {
		
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_SUBLINKS);

		for (int i = 0; i < actualList.size(); i++) {
			List<WebElement> actualListnew = contentEditorPage
					.getAllLinksInSection(contentEditorPage.LIST_PAGE_SUBLINKS);
			ReporterText("Clicking on " + actualListnew.get(i).getText());
			contentEditorPage.click(actualListnew.get(i));

			ReporterText("Pop Up exists: " + contentEditorPage.isDisplayed(contentEditorPage.POP_UP_HEADER_COMMON_APP));
			boolean expected = true;
			boolean actual = contentEditorPage.isDisplayed(contentEditorPage.VIEW_DEFAULT_POPUP_CLOSE_COMMON_APP);

			String screenshot = contentEditorPage.assertBoolean(expected, actual,
					contentEditorPage.VIEW_DEFAULT_POPUP_HEADER_COMMON_APP);
			ReporterLink(screenshot, "Pop Displayed");

			contentEditorPage.clickOnPopUpCloseButton();
			contentEditorPage = new ContentEditorPage(driver);
		}
	}
	//===========================================================================================================================
	
	@Test(priority = 4)
	public void TC_04_Validate_PopUpBody_ContentRegion() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String mainDriver = contentEditorPage.controlOfMainDriver();
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);

		for (int i = 0; i < actualList.size(); i++) {
			List<WebElement> actualListnew = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
			ReporterText("Clicking on " + actualListnew.get(i).getText());
			contentEditorPage.click(actualListnew.get(i));

			driver.switchTo().frame(driver.findElement(By.id("text_ifr")));
			contentEditorPage.clickOnContentRegionPopUpBody();
			contentEditorPage.enterValueInContentRegionPopUPBody("Pravin University Selenium Testing");
			boolean expected = true;
			boolean actual = contentEditorPage.isEnabled(contentEditorPage.CONTENT_REGION_NAME_POPUP_BODY);

			ReporterText("Pop Up Body is Enabled: " + actual);

			String screenshot = contentEditorPage.assertBoolean(expected, actual,
					contentEditorPage.CONTENT_REGION_NAME_POPUP_BODY);
			ReporterLink(screenshot, "Content Region Pop Enabled");

			String subDriver = contentEditorPage.controlOfSubDriver();
			contentEditorPage.driverSwitch(subDriver);

			contentEditorPage.clickOnContentRegionPopUpButton();
			contentEditorPage.acceptAlert();
			contentEditorPage.clickOnPopUpCloseButton();
			contentEditorPage.driverSwitch(mainDriver);

			contentEditorPage = new ContentEditorPage(driver);
		}
	}
	// =======================================================================
	// ====================================================

	@Test(priority = 5)
	public void TC_05_Validate_PopUps_ContentRegion_CloseFunction() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		boolean expected = true;
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);

		for (int i = 0; i < actualList.size(); i++) {
			List<WebElement> actualListnew = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
			ReporterText("Clicking on " + actualListnew.get(i).getText());
			contentEditorPage.click(actualListnew.get(i));
			boolean actual = contentEditorPage.isEnabled(contentEditorPage.POP_UP_CLOSE_COMMON_APP);

			String screenshot = contentEditorPage.assertBoolean(expected, actual,
					contentEditorPage.POP_UP_CLOSE_COMMON_APP);
			ReporterLink(screenshot, "Content Region Pop Enabled");
			contentEditorPage.clickOnPopUpCloseButton();
			contentEditorPage = new ContentEditorPage(driver);

		}

	}

	// ===========================================================================================================================

	@Test(priority = 6)
	public void TC_06_Validate_PopUps_DefaultContent_CloseFunction() {

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		boolean expected = true;
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_SUBLINKS);

		for (int i = 0; i < actualList.size(); i++) {
			List<WebElement> actualListnew = contentEditorPage
					.getAllLinksInSection(contentEditorPage.LIST_PAGE_SUBLINKS);
			ReporterText("Clicking on " + actualListnew.get(i).getText());
			contentEditorPage.click(actualListnew.get(i));
			boolean actual = contentEditorPage.isEnabled(contentEditorPage.POP_UP_CLOSE_COMMON_APP);

			String screenshot = contentEditorPage.assertBoolean(expected, actual,
					contentEditorPage.POP_UP_CLOSE_COMMON_APP);
			ReporterLink(screenshot, "Content Region Pop Enabled");
			contentEditorPage.clickOnPopUpCloseButton();
			contentEditorPage = new ContentEditorPage(driver);

		}
	}
	// ===========================================================================================================================

	@Test(priority = 7)
	public void TC_07_Validate_PopUps_DefaultContent_SaveChangesFunction() {

		String expected = "Selecting to save will overwrite any previous information saved. Please select OK to continue";

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);

		for (int i = 0; i < actualList.size(); i++) {
			List<WebElement> actualListnew = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
			ReporterText("Clicking on " + actualListnew.get(i).getText());
			contentEditorPage.click(actualListnew.get(i));
			contentEditorPage.clickOnContentRegionPopUpButton();

			String actual = contentEditorPage.getAlertText();
			contentEditorPage.dismissAlert();

			String screenshot = contentEditorPage.assertText(expected, actual);
			ReporterLink(screenshot, "Driver Screenshot Because of Alert Present.");

			contentEditorPage.clickOnPopUpCloseButton();
			contentEditorPage = new ContentEditorPage(driver);

		}
	}
	// ==========================================================================================================================

	@Test(priority = 8)
	public void TC_08_Validate_ContentRegionPopUp_SaveChanges_Alert_OKFunction() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		String mainDriver = contentEditorPage.controlOfMainDriver();
		String text = "Pravin University Testing Number " + contentEditorPage.getRandomNumberString(10);
		String actualText = null;

		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);

		for (int i = 0; i < actualList.size(); i++) {
			List<WebElement> actualListnew = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
			ReporterText("Clicking on " + actualListnew.get(i).getText());
			contentEditorPage.click(actualListnew.get(i));
			
			driver.switchTo().frame(contentEditorPage.waitForElement(contentEditorPage.FRAME_ID));
			contentEditorPage.clickOnContentRegionPopUpBody();
			contentEditorPage.enterValueInContentRegionPopUPBody(text);
			String subDriver = contentEditorPage.controlOfSubDriver();
			contentEditorPage.driverSwitch(subDriver);
			contentEditorPage.clickOnContentRegionPopUpButton();
			contentEditorPage.acceptAlert();
			try {
				Thread.sleep(3500);
			} catch (InterruptedException e) {
			}
			contentEditorPage = new ContentEditorPage(driver);
			actualListnew = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
			contentEditorPage.click(actualListnew.get(i));
			driver.switchTo().frame(contentEditorPage.waitForElement(contentEditorPage.FRAME_ID));
			contentEditorPage.clickOnContentRegionPopUpBody();
			actualText = contentEditorPage.getParagraphContent();
			
			
			String screenshot = contentEditorPage.assertText(text, actualText, contentEditorPage.CONTENT_REGION_NAME_POPUP_PARAGRAPH);
			ReporterLink(screenshot, "Driver Screenshot Because of Alert Present.");

			contentEditorPage.clickOnPopUpCloseButton();
			contentEditorPage.driverSwitch(mainDriver);
			
			contentEditorPage = new ContentEditorPage(driver);
			contentEditorPage.clickOnPopUpCloseButton();
			
			
		}
	}
	//===========================================================================================================================
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverContentManagementTab();
		contentEditorPage = homePage.clickContentEditorLink();
		contentEditorPage.clickOnParentHouseholdInformationLink();

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