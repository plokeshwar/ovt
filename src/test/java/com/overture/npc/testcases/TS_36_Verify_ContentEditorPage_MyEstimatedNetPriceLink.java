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


public class TS_36_Verify_ContentEditorPage_MyEstimatedNetPriceLink extends CommonMethods {
	
	String homePageUrl;

	String className = this.getClass().getSimpleName();
	WebDriver driver = null;

	LoginPage loginPage = null;
	HomePage homePage = null;
	ContentEditorPage contentEditorPage = null;
	
	//@Test(priority = 1)
	public void TC_01_Validate_ViewDefault_Links() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expectedList = "View Default, View Default, View Default, View Default, View Default, View Default, View Default, View Default, View Default, View Default, View Default, View Default, View Default, ";
		

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
		
		String [] expectedList ={"My Estimated Net Price - Net Price Footer", "My Estimated Net Price - Transportation Help", "My Estimated Net Price - Books & Supplies Help",
				"My Estimated Net Price - Personal Expenses Help","My Estimated Net Price - Pie Chart Explanation", "My Estimated Net Price - Est. Remaining Cost Help",
				"My Estimated Net Price - Est. Self Help Quick Help", "My Estimated Net Price - Tuition Help", "My Estimated Net Price - Net Price Regulations", 
				"My Estimated Net Price - Room & Board Help","My Estimated Net Price - Est. Grant Aid Help", "My Estimated Net Price - Estimated COA Help", "My Estimated Net Price - EFC Explanation"
				,"My Estimated Net Price - Est. Net Price Help"};
		
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);

		for (int i = 0; i < actualList.size(); i++) {
			List<WebElement> actualListnew = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
			ReporterText("Clicking on " + actualListnew.get(i).getText());
			contentEditorPage.click(actualListnew.get(i));

			if(contentEditorPage.isDisplayed(contentEditorPage.POP_UP_HEADER_COUNT)){
				ReporterText("Pop Up exists: " + contentEditorPage.isDisplayed(contentEditorPage.POP_UP_HEADER_COMMON_APP));

				String actual = contentEditorPage.getText(contentEditorPage.POP_UP_HEADER_COMMON_APP);
				ReporterText(actual);

				String screenshot = contentEditorPage.assertText(expectedList[i], actual,
						contentEditorPage.POP_UP_HEADER_COMMON_APP);
				ReporterLink(screenshot, actual);

				contentEditorPage.clickOnPopUpCloseButton();
				contentEditorPage = new ContentEditorPage(driver);
				
			}else{
				String actual = contentEditorPage.getText(contentEditorPage.POPUP_HEADER_POPULATION_CONTENT);
				ReporterText(actual);

				
				String screenshot = contentEditorPage.assertText(expectedList[i], actual,
						contentEditorPage.POPUP_HEADER_POPULATION_CONTENT);
				ReporterLink(screenshot, actual);

				homePage = new HomePage(driver);
				homePage.performMouseOverContentManagementTab();
				contentEditorPage = homePage.clickContentEditorLink();
				contentEditorPage.clickOnEstimatedNetPriceLink();
				
			}
			
		}

	}
	//===========================================================================================================================
	
	//@Test(priority = 3)
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
			
			if(contentEditorPage.isDisplayed(contentEditorPage.POP_UP_HEADER_COUNT)){
				boolean actual = contentEditorPage.isEnabled(contentEditorPage.POP_UP_CLOSE_COMMON_APP);

				String screenshot = contentEditorPage.assertBoolean(expected, actual,
						contentEditorPage.POP_UP_CLOSE_COMMON_APP);
				ReporterLink(screenshot, "Content Region Pop Enabled");
				contentEditorPage.clickOnPopUpCloseButton();
				contentEditorPage = new ContentEditorPage(driver);
				
			}else{
				String actual = "Not a popup.";
				ReporterText(actual);

				
				String screenshot = contentEditorPage.assertText("Not a popup.", actual,
						contentEditorPage.POPUP_HEADER_POPULATION_CONTENT);
				ReporterLink(screenshot, actual);

				homePage = new HomePage(driver);
				homePage.performMouseOverContentManagementTab();
				contentEditorPage = homePage.clickContentEditorLink();
				contentEditorPage.clickOnEstimatedNetPriceLink();
				
			}
			
			

		}

	}

	// ===========================================================================================================================

	//@Test(priority = 6)
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
			
			if(contentEditorPage.isDisplayed(contentEditorPage.POP_UP_HEADER_COUNT)){
				contentEditorPage.clickOnContentRegionPopUpButton();
				String actual = contentEditorPage.getAlertText();
				contentEditorPage.dismissAlert();

				String screenshot = contentEditorPage.assertText(expected, actual);
				ReporterLink(screenshot, "Driver Screenshot Because of Alert Present.");

				contentEditorPage.clickOnPopUpCloseButton();
				contentEditorPage = new ContentEditorPage(driver);
				
			}else{
				String actual = "Not a popup.";
				ReporterText(actual);

				
				String screenshot = contentEditorPage.assertText("Not a popup.", actual,
						contentEditorPage.POPUP_HEADER_POPULATION_CONTENT);
				ReporterLink(screenshot, actual);

				homePage = new HomePage(driver);
				homePage.performMouseOverContentManagementTab();
				contentEditorPage = homePage.clickContentEditorLink();
				contentEditorPage.clickOnEstimatedNetPriceLink();
				
			}
		}
	}
	// ==========================================================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverContentManagementTab();
		contentEditorPage = homePage.clickContentEditorLink();
		contentEditorPage.clickOnEstimatedNetPriceLink();

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
