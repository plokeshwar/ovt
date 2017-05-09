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
import com.overture.npc.pages.ContentEditorPage;
import com.overture.npc.pages.HomePage;
import com.overture.npc.pages.LoginPage;

public class TS_39_Verify_ContentEditorPage_MyResourcesLink extends CommonMethods {

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

		String expectedList = "View Default, View Default, View Default, View Default";

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
	// ===========================================================================================================================

	@Test(priority = 2)
	public void TC_02_Validate_PopUps_ContentRegion() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String [] expectedList ={"My Resources - Worksheet Help","My Resources - Helpful Information", "My Resources - Payment Options", "My Resources - Est. Total My Resources Help"};

		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);

		for (int i = 0; i < actualList.size(); i++) {
			List<WebElement> actualListnew = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
			ReporterText("Clicking on " + actualListnew.get(i).getText());
			contentEditorPage.click(actualListnew.get(i));

			String actual = contentEditorPage.getText(contentEditorPage.POP_UP_HEADER_COMMON_APP);
			ReporterText(actual);
			String screenshot = contentEditorPage.assertText(expectedList[i], actual,
					contentEditorPage.POP_UP_HEADER_COMMON_APP);
			ReporterLink(screenshot, actual);

			homePage = new HomePage(driver);
			homePage.performMouseOverContentManagementTab();
			contentEditorPage = homePage.clickContentEditorLink();

		}

	}
	// ===========================================================================================================================

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

			boolean actual = contentEditorPage.isDisplayed(contentEditorPage.POP_UP_HEADER_COMMON_APP);
			ReporterText("Header is present.");
			String screenshot = contentEditorPage.assertBoolean(true, actual,
					contentEditorPage.POP_UP_HEADER_COMMON_APP);
			ReporterLink(screenshot, "Header Screenshot.");

			homePage = new HomePage(driver);
			homePage.performMouseOverContentManagementTab();
			contentEditorPage = homePage.clickContentEditorLink();
		}
	}
	
	// ===========================================================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverContentManagementTab();
		contentEditorPage = homePage.clickContentEditorLink();
		contentEditorPage.clickOnMyResourcesLink();

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