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

public class TS_26_Verify_ContentEditorPage_CommonAcrossAllPagesLink extends CommonMethods {

	String homePageUrl;

	String className = this.getClass().getSimpleName();
	WebDriver driver = null;

	LoginPage loginPage = null;
	HomePage homePage = null;
	ContentEditorPage contentEditorPage = null;

	// @Test(priority = 1)
	public void TC_01_Validate_ViewDefault_Link_Availabilty() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);

		String expectedList = "View Default, View Default";

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

	// @Test(priority = 2)
	public void TC_02_Validate_PopUps_ContentRegion() {

		String[] expectedList = { "Common Across All Pages - School Name", "Common Across All Pages - NPC Exit Url" };

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
	// ===========================================================================================================================

	//@Test(priority = 3)
	public void TC_03_Validate_PopUps_DefaultContent() {

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

	// ===========================================================================================================================

	@Test(priority = 4)
	public void TC_04_Validate_PopUpBody_ContentRegion() {
		String mainDriver = contentEditorPage.controlOfMainDriver();
		List<WebElement> actualList = contentEditorPage.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);

		for (int i = 0; i < actualList.size(); i++) {
			List<WebElement> actualListnew = contentEditorPage
					.getAllLinksInSection(contentEditorPage.LIST_PAGE_TABLE);
			ReporterText("Clicking on " + actualListnew.get(i).getText());
			contentEditorPage.click(actualListnew.get(i));
			
			
			driver.switchTo().frame(driver.findElement(By.id("text_ifr")));
			contentEditorPage.clickOnContentRegionPopUpBody();
			contentEditorPage.enterValueInContentRegionPopUPBody("Pravin University Selenium Testing");
			boolean expected = true;
			boolean actual = contentEditorPage.isEnabled(contentEditorPage.CONTENT_REGION_NAME_POPUP_BODY);
			
			ReporterText("Pop Up Body is Enabled: "+actual );
			
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

	/*
	 * * @Test(priority = 5) public void
	 * TC_05_Validate_PopUps_ContentRegion_CloseFunction() {
	 * 
	 * ArrayList<String> stringList=cm.linkFinder(driver,
	 * contentEditorPage.listPageTable); for(int i=0; i<stringList.size();i++) {
	 * WebElement element=
	 * driver.findElement(By.xpath("//td[@class='listPage']//a[contains(.,'"+
	 * stringList.get(i)+"')]")) ; co.click(element, "Clicking on "
	 * +stringList.get(i)); Reporter.log(cm.ReporterText(
	 * "Pop Up Close Button is Enabled: "
	 * )+contentEditorPage.popUpCloseCommonAAP.isEnabled());
	 * Assert.assertEquals(contentEditorPage.popUpCloseCommonAAP.isEnabled(),
	 * true, "The Close Button of Pop Up is not enabled");
	 * 
	 * co.click(contentEditorPage.popUpCloseCommonAAP, "Closing Pop Up");
	 * contentEditorPage=new ContentEditorPage().contentEditorInit(driver); }
	 * 
	 * }
	 * //=======================================================================
	 * ====================================================
	 * 
	 * @Test(priority = 6) public void
	 * TC_06_Validate_PopUps_DefaultContent_CloseFunction() {
	 * 
	 * List<WebElement> paragraphs =
	 * contentEditorPage.listPageTable.findElements(By.tagName("p"));
	 * Iterator<WebElement> i = paragraphs.iterator(); while(i.hasNext()) {
	 * WebElement viewDefault = i.next(); co.click(viewDefault,
	 * "Clicking on View Default Link"); Reporter.log(cm.ReporterText(
	 * "View Default Pop Up Close Button is Enabled: "
	 * )+contentEditorPage.viewDefaultPopUpCloseCommonAAP.isEnabled());
	 * Assert.assertEquals(contentEditorPage.viewDefaultPopUpCloseCommonAAP.
	 * isEnabled(), true, "The Close Button of Pop up is not Enabled");
	 * co.click(contentEditorPage.viewDefaultPopUpCloseCommonAAP,
	 * "Closing View Default Pop Up"); contentEditorPage=new
	 * ContentEditorPage().contentEditorInit(driver); } }
	 * //=======================================================================
	 * ====================================================
	 * 
	 * 
	 * @Test(priority = 7) public void
	 * TC_07_Validate_PopUps_DefaultContent_SaveChangesFunction() {
	 * 
	 * String expected=
	 * "Selecting to save will overwrite any previous information saved. Please select OK to continue"
	 * ;
	 * 
	 * ArrayList<String> stringList=cm.linkFinder(driver,
	 * contentEditorPage.listPageTable); for(int i=0; i<stringList.size();i++) {
	 * WebElement element=
	 * driver.findElement(By.xpath("//td[@class='listPage']//a[contains(.,'"+
	 * stringList.get(i)+"')]")) ; co.click(element, "Clicking on "
	 * +stringList.get(i));
	 * co.click(contentEditorPage.contentRegionNamePopUpButton,
	 * "Clicking on Save Changes Button"); String
	 * actual=co.alertHandler(driver).getText();
	 * co.alertHandler(driver).dismiss();
	 * 
	 * Reporter.log(cm.ReporterText(
	 * "Screen Shot Not Taken, as Validating Pop-up.")); System.out.println(
	 * "Asserting the test case"); Assert.assertEquals(actual, expected);
	 * 
	 * co.click(contentEditorPage.popUpCloseCommonAAP, "Closing Pop Up");
	 * contentEditorPage=new ContentEditorPage().contentEditorInit(driver); } }
	 * //=======================================================================
	 * ====================================================
	 * 
	 * @Test(priority = 8) public void
	 * TC_08_Validate_ContentRegionPopUp_SaveChanges_Alert_OKFunction() {
	 * WebElement element=null; mainDriver=co.controlOfMainDriver(driver);
	 * String text="Pravin University Testing Number "
	 * +cm.randomNumberGenerator(); String actualText=null;
	 * 
	 * ArrayList<String> stringList=cm.linkFinder(driver,
	 * contentEditorPage.listPageTable); for(int i=0; i<stringList.size();i++) {
	 * contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
	 * element=
	 * driver.findElement(By.xpath("//td[@class='listPage']//a[contains(.,'"+
	 * stringList.get(i)+"')]")) ; co.click(element, "Clicking on "
	 * +stringList.get(i)); driver.switchTo().frame(contentEditorPage.frameID);
	 * co.click(contentEditorPage.contentRegionNamePopUpBody,
	 * "Clicking on the Body"); co.type
	 * (contentEditorPage.contentRegionNamePopUpBody, text,
	 * "Typing inside the body"); subDriver=co.controlOfSubDriver(driver);
	 * co.driverSwitch(driver, subDriver,
	 * "Driver Control Passing to sub Driver.");
	 * 
	 * co.click(contentEditorPage.contentRegionNamePopUpButton,
	 * "Clicking on Save Changes Button"); co.alertHandler(driver).accept(); try
	 * { Thread.sleep(3500); } catch (InterruptedException e) { }
	 * contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
	 * element=
	 * driver.findElement(By.xpath("//td[@class='listPage']//a[contains(.,'"+
	 * stringList.get(i)+"')]")) ; co.click(element, "Clicking on "
	 * +stringList.get(i)); driver.switchTo().frame(contentEditorPage.frameID);
	 * co.click(contentEditorPage.contentRegionNamePopUpBody,
	 * "Clicking on the Body");
	 * actualText=contentEditorPage.contentRegionNamePopUpParagraph.getText();
	 * 
	 * co.driverSwitch(driver, mainDriver,
	 * "Driver Control Passing to Main Driver.");
	 * 
	 * contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
	 * co.click(contentEditorPage.popUpCloseCommonAAP, "Closing Pop Up");
	 * Reporter.log(cm.ReporterTextBold("Expected : "+text));
	 * Reporter.log(cm.ReporterTextBold("Actual : "+actualText));
	 * Assert.assertEquals(actualText, text, "Tested text is not Saved For "
	 * +stringList.get(i)); } }
	 */

	// ===========================================================================================================================
	@BeforeMethod
	public void BeforeMethod() {
		homePage.performMouseOverContentManagementTab();
		contentEditorPage = homePage.clickContentEditorLink();
		contentEditorPage.clickOnCommonAcrossAllPageLink();

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
