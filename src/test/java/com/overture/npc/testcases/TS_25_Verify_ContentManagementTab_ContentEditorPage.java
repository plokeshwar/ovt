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

public class TS_25_Verify_ContentManagementTab_ContentEditorPage extends CommonMethods {

	String homePageUrl;

	String className = this.getClass().getSimpleName();
	WebDriver driver = null;

	LoginPage loginPage = null;
	HomePage homePage = null;
	ContentEditorPage contentEditorPage = null;

	/**
	 * This test case will validate "Common Across All Pages" link
	 * <p>
	 * Steps : Click on the "Common Across All Pages" link in the Content Editor
	 * Page.
	 * <p>
	 * Expected Result : It will display a table with "School Name" and
	 * "NPC Exit URL" in "Content Region Name"
	 */

	@Test(priority = 1)
	public void TC_01_Validate_CommonAcrossAllPages_Link() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnCommonAcrossAllPageLink();

		String expectedList = "School Name, NPC Exit Url";

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);

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
	public void TC_02_Validate_MaintainancePage_Link() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnMaintainancePageLink();
		String expectedList = "Title, Content";
		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@Test(priority = 3)
	public void TC_03_Validate_MyEstimatedNetPrice_Link() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnEstimatedNetPriceLink();

		String expectedList = "Net Price Footer, Transportation Help, Books & Supplies Help, Personal Expenses Help, Pie Chart Explanation, Est. Remaining Cost Help, "
				+ "Est. Self Help Quick Help, Tuition Help, Net Price Regulations, Room & Board Help, Est. Grant Aid Help, Estimated COA Help, EFC Explanation, Est. Net Price Help";

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@Test(priority = 4)
	public void TC_04_Validate_MyInformation_Link() {
		String expectedList = "Helpful Information";

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnMyInformationLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@Test(priority = 5)
	public void TC_05_Validate_MyNextSteps_Link() {
		String expectedList = "Helpful Information";

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnMyNextStepLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@Test(priority = 6)
	public void TC_06_Validate_MyResources_Link() {
		String expectedList = "Worksheet Help, Helpful Information, Payment Options, Est. Total My Resources Help";

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnMyResourcesLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@Test(priority = 7)
	public void TC_07_Validate_NeedHelp_Link() {
		String expectedList = "";

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnNeedHelpLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@Test(priority = 8)
	public void TC_08_Validate_NPCWelcomePage_Link() {
		String expectedList = "Bubble 1, Main Text, NPC Introduction";
		
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnNpcWelcomePageLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@Test(priority = 9)
	public void TC_09_Validate_PageNameTable_Links() {
		String expectedList = "Common Across All Pages, NPC Welcome Page, Student Information Page, Parent Household Information, Parent Income Information, Parent Assets Information, Student Finances (& Household) Information, Need Help, Please Read, Terms & Conditions, My Estimated Net Price, My Information, My Next Steps, My Resources, Maintenance Page";
	
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

	
		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.PAGE_NAME_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	/**
	 * This test case will validate "Parent Assets Information" link
	 * <p>
	 * Steps : Click on the "Parent Assets Information" link in the Content
	 * Editor Page.
	 * <p>
	 * Expected Result : It will display a table with "Helpful Information" link
	 * in"Content Region Name"
	 */

	@Test(priority = 10)
	public void TC_10_Validate_ParentAssetsInformation_Link() {
		String expectedList = "Helpful Information";

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnParentAssetInfoLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}

	// ===========================================================================================================================

	@Test(priority = 11)
	public void TC_11_Validate_ParentHouseholdInformation_Link() {
		String expectedList = "Helpful Information";

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnParentHouseholdInformationLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@Test(priority = 12)
	public void TC_12_Validate_ParentIncomeInformation_Link() {
		String expectedList = "Helpful Information";

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnParentIncomeInformationLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	//@Test(priority = 13)
	public void TC_13_Validate_PleaseRead_Link() {
		String expectedList = "";

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnPleaseReadLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@Test(priority = 14)
	public void TC_14_Validate_StudentFinancesInfo_Link() {
		String expectedList = "Helpful Information";

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnStudentFinancesInfoLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@Test(priority = 15)
	public void TC_15_Validate_StudentInfoPage_Link() {
		String expectedList = "Helpful Information";

		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnStudentInfoLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@Test(priority = 16)
	public void TC_16_Validate_TermsAndConditions_Link() {
		String expectedList = "School T&C Link";
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		contentEditorPage.clickOnTermsAndCoditionsLink();

		ArrayList<String> expect = contentEditorPage.createArrayList(expectedList);
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
		for (int i = 0; i < actualList.size(); i++) {
			String expected = expect.get(i);
			String actual = actualList.get(i).getText();
			String screenshot = contentEditorPage.assertText(expected, actual, actualList.get(i));
			ReporterLink(screenshot, actual);
		}
		Assert.assertEquals(actualList.size(), expect.size(), "The list size did not match");
	}
	// ===========================================================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverContentManagementTab();
		contentEditorPage = homePage.clickContentEditorLink();

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
