package com.overture.npc.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.overture.npc.common.PageControls;


public class PageConfigurationsPage extends PageControls {
		private WebDriver driver;;
	 public PageConfigurationsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public By BROWSER_BUTTON = By.xpath("//div[@class='outlineBox']//input[@type='file']");
	 public By UPLOAD_BUTTON = By.xpath("//div[@class='outlineBox']//input[@type='submit']");
	 public By ERROR_MESSAGE = By.xpath("//div[@class='outlineBox']//div[@class='errorMessage']");
	 public By SECTION_HEADER = By.xpath("//div//div//h2//b");
	 public By LOGO = By.xpath("//div[@id='main']//img");
	 public By COHORT_AID_TEXT = By.id("cohortAidPercent");
	 public By STATE_GRANT_TEXT = By.id("stateGrant");
	 public By INSTITUTIONAL_GRANT_TEXT = By.id("instGrant");
	 public By INST_SCHOLARSHIP_TEXT = By.id("instScholarship");
	 public By CONSOLIDATE_SELF_HELP_TEXT = By.id("consolidatedSelfHelp");
	 public By SCHOOL_DEFINED_FUND1 = By.id("schoolDefinedFund1");
	 public By SCHOOL_DEFINED_FUND2 = By.id("schoolDefinedFund2");
	 
	 public By SCHOOL_LOGO_TEXT = By.xpath("//b[contains(.,'School Logo')]");
	 public By IMAGE_SELECTION_TEXT = By.xpath("//b[contains(.,'Image Selection')]");
	 public By PERCENT_GRANT_AID_TEXT = By.xpath("//b[contains(.,'Percent Grant Aid')]");
	 public By MY_NET_PRICE_TEXT = By.xpath("//b[contains(.,'My Net Price')]");
	 public By MY_RESOURCES_TEXT = By.xpath("//b[contains(.,'My Resources')]");
	 public By GRANT_AID_DISPLAY_TEXT = By.xpath("//b[contains(.,'EFC/Grant Aid Display')]");
	 public By FORM_NAME = By.id("configurationForm");
	 public By BUBBLE_IMAGE_ONE = By.id("bubble1");
	 public By BUBBLE_ONE_IMAGE_ID = By.id("img_bubble1");
	 public By BUBLE_IMAGE_TWO = By.id("bubble2");
	 public By BUBBLE_TWO_IMAGE_ID = By.id("img_bubble2");
	 public By SAVE_CHANGES_BUTTON = By.xpath("//input[@value='Save Changes']");
	 public By CANCEL_BUTTON = By.xpath("//input[@value='Cancel']");
	 private By SAVE_CHANGES_POPUP_NO = By.xpath("//button[contains(.,'No')]");
		private By SAVE_CHANGES_POPUP_YES = By.xpath("//button[contains(.,'Yes')]");
		private By SAVE_CHANGES_POPUP_TEXT = By.xpath("//div//h6");
	 
	 public void clickSaveChangesButton(){
		 click(SAVE_CHANGES_BUTTON);
		 ReporterText("Clicked on Save Changes Button.");
	 }
	 
	 public void clickCancelButton(){
		 click(CANCEL_BUTTON);
		 ReporterText("Clicked on Cancel Button.");
	 }

	 public void clickYesSaveChangesPopup(){
		 click(SAVE_CHANGES_POPUP_YES);
		 ReporterText("Clicked on Yes Button in Save Changes Popup.");
	 }
	 
	 public void clickNoSaveChangesPopup(){
		 click(SAVE_CHANGES_POPUP_NO);
		 ReporterText("Clicked on No Button in Save Changes Popup.");
	 }
	 
	 public String getSaveChangesPopupText(){
		 return getText(SAVE_CHANGES_POPUP_TEXT);
	 }
	 
	 public boolean verifyIsBrowseButtonDisplayed(){
		 boolean flag = isDisplayed(BROWSER_BUTTON);
		 ReporterText("Verifying if Browse Button is Enabled. : "+flag);
		 return flag;
	 }
	 
	 public boolean verifyErrorMessageDisplayed(){
		 boolean flag = isDisplayed(ERROR_MESSAGE);
		 ReporterText("Verifying if Error Message is Displayed. : "+flag);
		 return flag;
	 }
	 
	 public boolean verifyTexBoxEnabled(By by, String message){
		 boolean flag = isEnabled(by);
		 ReporterText(message + " : "+flag);
		 return flag;
		 
	 }
	 
	 public String getErrorMessage(){
		 String tmp = getText(ERROR_MESSAGE);
		 ReporterText("Extracting error message from Page Configuration Page. : "+tmp);
		 return tmp;
	 }
	 
	 
	 public void enterFilePath(String filePath){
		 type(BROWSER_BUTTON, filePath);
		 ReporterText("Entered File Path to upload the image.");
	 }
	 
	 public void clickUploadButton(){
		 click(UPLOAD_BUTTON);
		 ReporterText("Clicked on Upload Button in Page Configuration Page.");
	 }
	 
	 public void uploadOriginalImageFile(){
		 String fileName=System.getProperty("user.dir")+"/testBrowse/orig.gif";
		 enterFilePath(fileName);
		 clickUploadButton();
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
	 
	 public ArrayList<String> getExpectedArrayList(String text){
			return createaArrayList(text);
	 }
	 
	 public ArrayList<String> getAllSectionHeaders(){
		 ArrayList<String> tmp = new ArrayList<>();
		 	List<WebElement> els = driver.findElements(SECTION_HEADER);
		 	for(WebElement e : els){
		 		tmp.add(e.getText());
		 	}
			
		 	return tmp;
		}

	 public List<WebElement> getSectionHeaders(){
		 return driver.findElements(SECTION_HEADER);
	 }
	 
	 public String selectingPageConfigurationImageSave(String testData1, String testData2){
			String expected=null;
			
			if(getFirstSelectedDropDown(BUBBLE_IMAGE_ONE).contains(testData1)){
				expected=testData2;
				selectDropDown(BUBBLE_IMAGE_ONE, testData2);
				//, "Selecting Image "+testData2+" as Bubble One Image.");
				}
			else{
				expected=testData1;
				selectDropDown(BUBBLE_IMAGE_ONE, testData2);
				//"Selecting Image "+testData1+" as Bubble One Image.");
				}
			return expected;
		}
	 
	 public String selectingPageConfigurationImageCancel(String testData1, String testData2){
			String expected=null;
			
			if(getFirstSelectedDropDown(BUBBLE_IMAGE_ONE).contains(testData1)){
				expected=testData1;
				selectDropDown(BUBBLE_IMAGE_ONE, testData2);
				}
			else{
				expected=testData2;
				selectDropDown(BUBBLE_IMAGE_ONE, testData1);
				
				}
			return expected;
		}
}
