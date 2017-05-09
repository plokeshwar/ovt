package com.overture.npc.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.overture.npc.common.PageControls;

public class ContentEditorPage extends PageControls {
	private WebDriver driver;
	 public ContentEditorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	 public By CONTENT_TABLE = By.id("categoryTable");
	 public By PAGE_NAME_TABLE = By.xpath("//div[@class='col1']//ul//li//a");
	 public By LIST_PAGE_TABLE = By.xpath("//div[@class='view-table']//div//div[1]//a");
	 public By LIST_PAGE_SUBLINKS = By.xpath("//div[@class='view-table']//div//div[3]//a");
	 public By FRAME_ID = By.id("text_ifr");
	 
	 public By COMMON_ACROSS_ALL_PAGE = By.partialLinkText("Common Across All Pages");
	 public By NPC_WELCOME_PAGE = By.partialLinkText("NPC Welcome Page");
	 public By STUDENT_INFO_PAGE = By.partialLinkText("Student Information Page");
	 public By PARENT_HOUSEHOLD_INFO = By.partialLinkText("Parent Household Information");
	 public By PARENT_INCOME_INFO = By.partialLinkText("Parent Income Information");
	 public By PARENT_ASSETS_INFO = By.partialLinkText("Parent Assets Information");
	 public By STUDENT_FINANCES_INFO = By.partialLinkText("Student Finances (& Household) Information");
	 public By NEED_HELP_LINK = By.partialLinkText("Need Help");
	 public By PLEASE_READ_LINK = By.partialLinkText("Please Read");
	 public By TERMS_LINK = By.partialLinkText("Terms & Conditions");
	 public By ESTIMATED_NET_PRICE_LINK = By.partialLinkText("My Estimated Net Price");
	 public By MY_INFORMATION_LINK = By.partialLinkText("My Information");
	 public By MY_NEXT_STEPS_LINK = By.partialLinkText("My Next Steps");
	 public By MY_RESOURCES_LINK = By.partialLinkText("My Resources");
	 public By MAINTAINANCE_PAGE = By.partialLinkText("Maintenance Page");
	 
	 public By POP_UP_HEADER_COMMON_APP = By.xpath("//span[@id='ui-dialog-title-popUpArea']");
	 public By POP_UP_CLOSE_COMMON_APP = By.xpath("//span[@class='ui-icon ui-icon-closethick']");
	 public By VIEW_DEFAULT_POPUP_HEADER_COMMON_APP = By.xpath("//span[@id='ui-dialog-title-dialog']");
	 public By VIEW_DEFAULT_POPUP_CLOSE_COMMON_APP = By.xpath("//span[@class='ui-icon ui-icon-closethick']");
	 public By CONTENT_REGION_NAME_POPUP_BODY = By.xpath("//body[@id='tinymce']");
	 public By CONTENT_REGION_NAME_POPUP_PARAGRAPH = By.xpath("//body[@id='tinymce']/p");
	 public By CONTENT_REGION_NAME_POPUP_BUTTON = By.xpath("//form[@id='subscriberContent']/div/input");
	 public By SCHOOL_NAME_COMMON_APP = By.xpath("//td[@class='listPage']/table/tbody/tr[2]/td[1]/a");
	 public By NPC_URL_COMMON_APP = By.xpath("//td[@class='listPage']/table/tbody/tr[3]/td[1]/a");
	 public By POPUP_HEADER_POPULATION_CONTENT = By.xpath("//div[@id='categoryTable']/div[@class='popHeader']");
	 public By POP_UP_HEADER_COUNT = By.id("ui-dialog-title-popUpArea");
	
	 public String getParagraphContent(){
		 String tmp = getText(CONTENT_REGION_NAME_POPUP_PARAGRAPH);
		 ReporterText("Extracting text from paragraph content. "+tmp);
		 return tmp;
	 }
	 
	 public void clickOnContentRegionPopUpBody(){
		 click(CONTENT_REGION_NAME_POPUP_BODY);
		 ReporterText("Clicked on content region pop-up body.");
	 }
	 
	 public void clickOnContentRegionPopUpButton(){
		 click(CONTENT_REGION_NAME_POPUP_BUTTON);
		 ReporterText("Clicked on content region pop-up button.");
	 }
	 
	 public void enterValueInContentRegionPopUPBody(String testData){
		 type(CONTENT_REGION_NAME_POPUP_BODY, testData);
		 ReporterText("Entered value in Content Region Popup Body. "+testData);
		 
	 }
	 
	 public void clickOnPopUpCloseButton(){
		 click(POP_UP_CLOSE_COMMON_APP);
		 pause(1000);
		 ReporterText("Clicking on pop up close button.");
	 }
	 
	 public void clickOnCommonAcrossAllPageLink(){
		 click(COMMON_ACROSS_ALL_PAGE);
		 pause(2000);
		 ReporterText("Clicked on Common Across All Pages link.");
	 }
	 
	 public void clickOnMaintainancePageLink(){
		 click(MAINTAINANCE_PAGE);
		 pause(2000);
		 ReporterText("Clicked on Maintainance Page link.");
	 }
	 
	 public void clickOnEstimatedNetPriceLink(){
		 click(ESTIMATED_NET_PRICE_LINK);
		 pause(2000);
		 ReporterText("Clicked on Estimated Net Price link.");
	 }
	 
	 public void clickOnMyInformationLink(){
		 click(MY_INFORMATION_LINK);
		 pause(2000);
		 ReporterText("Clicked on My Information link.");
	 }
	 
	 public void clickOnMyNextStepLink(){
		 click(MY_NEXT_STEPS_LINK);
		 pause(2000);
		 ReporterText("Clicked on My Next Step link.");
	 }
	 
	 public void clickOnMyResourcesLink(){
		 click(MY_RESOURCES_LINK);
		 pause(2000);
		 ReporterText("Clicked on My Resources link.");
	 }
	 
	 public void clickOnNeedHelpLink(){
		 click(NEED_HELP_LINK);
		 pause(2000);
		 ReporterText("Clicked on Need Help link.");
	 }
	 
	 public void clickOnNpcWelcomePageLink(){
		 click(NPC_WELCOME_PAGE);
		 pause(4000);
		 ReporterText("Clicked on NPC Welcome Link.");
	 }
	 
	 public void clickOnTermsAndCoditionsLink(){
		 click(TERMS_LINK);
		 pause(2000);
		 ReporterText("Clicked on Terms and Condition Link.");
	 }
	 
	 public void clickOnParentAssetInfoLink(){
		 click(PARENT_ASSETS_INFO);
		 pause(2000);
		 ReporterText("Clicked on Parent Asset Info Link.");
	 }
	 
	 public void clickOnStudentInfoLink(){
		 click(STUDENT_INFO_PAGE);
		 pause(2000);
		 ReporterText("Clicked on Student Info Link.");
	 }
	 
	 public void clickOnPleaseReadLink(){
		 click(PLEASE_READ_LINK);
		 pause(2000);
		 ReporterText("Clicked on Please Read Link.");
	 }
	 
	 public void clickOnParentIncomeInformationLink(){
		 click(PARENT_INCOME_INFO);
		 pause(2000);
		 ReporterText("Clicked on Parent Income Info Link.");
	 }
	 
	 public void clickOnParentHouseholdInformationLink(){
		 click(PARENT_HOUSEHOLD_INFO);
		 pause(2000);
		 ReporterText("Clicked on Parent Household Info Link.");
		 
	 }
	 
	 public void clickOnStudentFinancesInfoLink(){
		 click(STUDENT_FINANCES_INFO);
		 pause(2000);
		 ReporterText("Clicked on Student Finances Info Link.");
	 }
	 
	 public ArrayList<String> getExpectedArrayList(String text){
			return createaArrayList(text);
	 }
    
	 public List<WebElement> getAllLinksInSection(By by){
		 return driver.findElements(by);
	 }
	 
	
	 
	 public String assertBoolean(boolean expected, boolean actual, By by) {
			if (expected == actual) {
				ReporterSuccess("Expected [ "+expected+" ]");
				ReporterSuccess("Actual [ "+actual+" ]");
				return captureElementScreenShot(by);
			} else {
				ReporterError("Expected [ "+expected+" ]");
				ReporterError("Actual [ "+actual+" ]");
				return captureDriverScreenShot();
			}
		}
 
	 public String assertText(String expected, String actual, By by) {
			
			if (expected.equalsIgnoreCase(actual)) {
				ReporterSuccess("Expected [ "+expected+" ]");
				ReporterSuccess("Actual [ "+actual+" ]");
				return captureElementScreenShot(by);
			} else {
				ReporterError("Expected [ "+expected+" ]");
				ReporterError("Actual [ "+actual+" ]");
				return captureDriverScreenShot();
			}
		}
	 
	 public String assertText(String expected, String actual, WebElement el) {
			
			if (expected.equalsIgnoreCase(actual)) {
				ReporterSuccess("Expected [ "+expected+" ]");
				ReporterSuccess("Actual [ "+actual+" ]");
				return captureElementScreenShot(el);
			} else {
				ReporterError("Expected [ "+expected+" ]");
				ReporterError("Actual [ "+actual+" ]");
				return captureDriverScreenShot();
			}
		}
	 
	 public String assertText(String expected, String actual) {
			
			if (expected.equalsIgnoreCase(actual)) {
				ReporterSuccess("Expected [ "+expected+" ]");
				ReporterSuccess("Actual [ "+actual+" ]");
				return captureDriverScreenShot();
			} else {
				ReporterError("Expected [ "+expected+" ]");
				ReporterError("Actual [ "+actual+" ]");
				return captureDriverScreenShot();
			}
		}

}
