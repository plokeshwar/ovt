package com.overture.npc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.overture.npc.common.PageControls;


public class AccountSettingsPage extends PageControls{

	public AccountSettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	private By PAGE_TITLE = By.xpath("//div[@class='pageTit']//h1");
	
	public By AID_YEAR_DROPDOWN = By.id("aidYear");
	private By SAVE_CHANGES_BUTTON = By.xpath("//input[@value='Save Changes']");
	private By CANCEL_BUTTON = By.xpath("//input[@value='Cancel']");
	private By ERROR_MESSAGE = By.xpath("//div[@class='errorMessage']");

	// List<WebElement>
	public By CALC_ROUNDING_RADIO_BUTTON = By.name("calcRounding");
	private By CALCULATOR_ROUNDING = By
			.xpath("//table[@class='widePlainTable']//td[contains(.,'Calculation Rounding')]");

	// List<WebElement>
	public By SCHOOL_MAINTAINENCE = By.name("enableSite");

	private By ENABLE_SITE = By.id("enableSite1");
	private By PUT_SITE_ON_HOLD = By.id("enableSite2");
	public By SITE_ON_HOLD_POPUP_CONTENT = By.id("defaultContent");
	private By SITE_ON_HOLD_POP_NO_BUTTON = By
			.xpath("//div[@class='submit-btns']//input[@value='No thanks, close the window']");
	private By SITE_ON_HOLD_POPUP_REDIRECT = By.id("redirect");
	private By SAVE_CHANGES_POPUP_NO = By.xpath("//button[contains(.,'No')]");
	private By SAVE_CHANGES_POPUP_YES = By.xpath("//button[contains(.,'Yes')]");
	private By SAVE_CHANGES_POPUP_TEXT = By.xpath("//div//h6");
	
	
	public List<WebElement> getCalcRoundingRadioButtons(){
		return getElementList(CALC_ROUNDING_RADIO_BUTTON);
	}
	
	public List<WebElement> getMaintainenceRadioButtons(){
		return getElementList(SCHOOL_MAINTAINENCE);
	}
	
	public String getMaintainencePopupText(){
		String temp = getText(SITE_ON_HOLD_POPUP_CONTENT);
		ReporterText("Extracting Text from Maintainence Popup : "+temp);
		return temp;
	}
	public void clickSiteMaintainenceSiteNoThanksButton(){
		click(SITE_ON_HOLD_POP_NO_BUTTON);
		ReporterText("Clicked on Site on Hold No PopUP button.");
	}
	
	public void clickSaveChangesButton(){
		click(SAVE_CHANGES_BUTTON);
		ReporterText("Clicked on save changes button.");
	}
	
	public void clickCancelButton(){
		click(CANCEL_BUTTON);
		ReporterText("Clicked on Cancel button.");
	}
	
	public String getSaveChangesPopupText(){
		String temp = getText(SAVE_CHANGES_POPUP_TEXT);
		ReporterText("Extracting Text from Save Changes Popup : "+temp);
		return temp;
	}
	
	public void clickSaveChangesPopupNoButton(){
		click(SAVE_CHANGES_POPUP_NO);
		ReporterText("Clicked on Save Changes Popup No button.");
	}
	
	public void clickSaveChangesPopupYesButton(){
		click(SAVE_CHANGES_POPUP_YES);
		ReporterText("Clicked on Save Changes Popup Yes button.");
	}
	
	public String getMessageText(){
		System.out.println("Getting Message Text.");
		ReporterText("Extracting Message Text");
		return getText(ERROR_MESSAGE);
	}
	
	
	public String getAccountSettingPageTitle() {
		System.out.println("Getting Account Settings Page Title.");
		ReporterText("Extracting Account Settings Page Title");
		return getText(PAGE_TITLE);
	}
	
	public String assertPopUPText(String expected, String actual) {
		ReporterTextBold("Actual ["+actual+"] : Expected ["+expected+"]");
		if (expected.equalsIgnoreCase(actual)) {
			return captureElementScreenShot(SAVE_CHANGES_POPUP_TEXT);
		} else {
			return captureDriverScreenShot();
		}
	}
	
	public String assertMessageText(String expected, String actual) {
		ReporterTextBold("Actual ["+actual+"] : Expected ["+expected+"]");
		if (expected.equalsIgnoreCase(actual)) {
			return captureElementScreenShot(ERROR_MESSAGE);
		} else {
			return captureDriverScreenShot();
		}
	}
	
	public String assertText(String expected, String actual, By by) {
		ReporterTextBold("Actual ["+actual+"] : Expected ["+expected+"]");
		if (expected.equalsIgnoreCase(actual)) {
			return captureElementScreenShot(by);
		} else {
			return captureDriverScreenShot();
		}
	}
	
	public String switchingAidYear() {
		String testData=null;
		String aidYearText = getFirstSelectedDropDown(AID_YEAR_DROPDOWN);
		
		List<WebElement> aidYearOptions = getAllOptions(AID_YEAR_DROPDOWN);
		for(WebElement el : aidYearOptions){
			if(!el.getText().equalsIgnoreCase(aidYearText) && !el.getText().equalsIgnoreCase("--Select--")){
				selectDropDown(AID_YEAR_DROPDOWN, el.getText());
				testData = el.getText();
			}
		}
		return testData;
	}
	

}
