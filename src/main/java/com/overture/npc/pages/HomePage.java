package com.overture.npc.pages;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.overture.npc.common.PageControls;

public class HomePage extends PageControls {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	/*Account Tab and related links*/
		
	public By ACCOUNT_TAB = By.id("ui-id-1");

	private By PAGE_TITLE = By.xpath("//div[@class='pageTit']//h1");
	public By ACCOUNT_SETTINGS_LINK = By.xpath("//a[@href='/schooladmin/app/account']");
	public By CALCULATION_REPORT_LINK = By.linkText("Calculation Report");
	public By TRAFFIC_SUMMARY_LINK = By.linkText("Traffic Summary");
	public By PREVIEW_LINK = By.linkText("Preview");
	public By ACCOUNTS_MENU = By.xpath("//div[@id='menuTabs-1']");
	
	/*Net Price Tab and related links*/
	
	public By NET_PRICE_TAB = By.id("ui-id-2");

	public By QUESTIONS_LINK = By.linkText("Questions");
	public By POPULATIONS_LINK = By.linkText("Populations");
	public By TABLES_LINK = By.linkText("Tables");
	public By COA_LINK = By.linkText("COA");
	public By PACKAGING_LINK = By.linkText("Packaging");
	public By SCHOOL_COMPUTED_VALUES_LINK = By.linkText("School Computed Values");
	
	public By NET_PRICE_MENU = By.xpath("//div[@id='menuTabs-2']");
	
	
	public CostOfAttendancePage clickCOALink(){
		click(COA_LINK);
		ReporterText("Clicking on COA link Under Net Price Tab.");
		return new CostOfAttendancePage(driver);
		
	}
	
	/*Content Management Tab and related links*/
	
	public By CONTENT_MANAGEMENT_TAB = By.linkText("Content Management");
	public By PAGE_CONFIGURATIONS_LINK = By.linkText("Page Configurations");
	public By CONTENT_EDITOR_LINK = By.linkText("Content Editor");
	public By NEXT_STEPS_LINK = By.linkText("Next Steps");

	public By CONTENT_MANAGEMENT_MENU = By.xpath("//div[@id='menuTabs-3']");
	
	
	public ContentEditorPage clickContentEditorLink(){
		click(CONTENT_EDITOR_LINK);
		ReporterText("Clicked on Content Editor Link in Content Managment Page.");
		return new ContentEditorPage(driver);
	}
	
	public void clickNextStepsLink(){
		click(NEXT_STEPS_LINK);
		ReporterText("Clicked on Next Step Link in Content Managment Page.");
	}
	
	public PageConfigurationsPage clickPageConfigurationLink(){
		click(PAGE_CONFIGURATIONS_LINK);
		ReporterText("Clicked on Page Configurations Link in Content Managment Page.");
		return new PageConfigurationsPage(driver);
	}
	/**
	 * Other locators
	 */
	public By SIGN_OUT_LINK = By.linkText("Sign Out");
	public By CHANGE_PASSWORD_LINK = By.linkText("Change Password");
	public By NEED_HELP_LINK = By.linkText("I Need Help");
	public By REDIRECT_LOGIN = By.linkText("here");
	
	public By PAGE_SUBTITLE = By.xpath("//div[@class='pageTit']//h1");
	
	
	public void clickSignout(){
		click(SIGN_OUT_LINK);
	}
	
	public ChangePasswordPage clickChangePasswordLink(){
		click(CHANGE_PASSWORD_LINK);
		ReporterText("Clicking on Change Password Link.");
		return new ChangePasswordPage(driver);
	}
	
	public void clickNeedHelpLink(){
		ReporterText("Clicking on Need Help Link.");
		click(NEED_HELP_LINK);
	}
	
	public void navigateToLoginPage(){
		ReporterText("Redirecting to Login Page.");
		click(REDIRECT_LOGIN);
	}
	
	public String getPageSubtitle(){
		return getText(PAGE_SUBTITLE);
	}
	
	public void performMouseOverAccountTab(){
		ReporterText("Performing Mouse Over Operation on Account Tab.");
		mouseOver(ACCOUNT_TAB);
	}
	
	public void performMouseOverNetPriceTab(){
		ReporterText("Performing Mouse Over Operation on Net Price Tab.");
		mouseOver(NET_PRICE_TAB);
	}
	
	public void performMouseOverContentManagementTab(){
		ReporterText("Performing Mouse Over Operation on Content Managment Tab.");
		mouseOver(CONTENT_MANAGEMENT_TAB);
	}
	
	public ArrayList<String> getExpectedArrayList(String text){
		return createArrayList(text);
	}
	
	public void clickAccountsTab(){
		click(ACCOUNT_TAB);
	}
	
	public String getPageTitle(String pageName) {
		System.out.println("Getting "+pageName+" Page Title.");
		ReporterText("Extracting "+pageName+" Page Title");
		pause(2000);
		return getText(PAGE_TITLE);
	}
	
	public String assertTitle(String expected, String actual) {
		if (expected.equalsIgnoreCase(actual)) {
			ReporterSuccess("Expected [ "+expected+" ]");
			ReporterSuccess("Actual [ "+actual+" ]");
			return captureElementScreenShot(PAGE_TITLE);
		} else {
			ReporterError("Expected [ "+expected+" ]");
			ReporterError("Actual [ "+actual+" ]");
			return captureDriverScreenShot();
		}
	}
	
	public AccountSettingsPage clickAccountSettingsLink(){
		click(ACCOUNT_SETTINGS_LINK);
		return new AccountSettingsPage(this.driver);
	}
	
	public void clickCalculationReportLink(){
		click(CALCULATION_REPORT_LINK);
		ReporterText("Clicked on Calculation report link.");
	}
	
	public void clickTrafficSummaryLink(){
		click(TRAFFIC_SUMMARY_LINK);
		ReporterText("Clicked on Traffic Summary link.");
	}
	
	public void clickPreviewLink(){
		click(PREVIEW_LINK);
		pause(2000);
		ReporterText("Clicked on Preview link.");
	}
	
	public ArrayList<String> getAccountTabSubMenu(){
		return getAllLinksByClass(ACCOUNTS_MENU);
	}
	
	public ArrayList<String> getNetPriceSubMenu(){
		return getAllLinksByClass(NET_PRICE_MENU);
	}
	
	public ArrayList<String> getContentManagementSubMenu(){
		return getAllLinksByClass(CONTENT_MANAGEMENT_MENU);
	}
	
	
}
