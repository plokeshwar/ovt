package com.overture.npc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.overture.npc.common.PageControls;

public class SchoolReportPage extends PageControls {
	
	WebDriver driver;
	
	 public By DATE_PICKER_YEAR = By.xpath("//span[@class='ui-datepicker-year']");
	 private By FROM_DATE_FIELD = By.xpath("//input[@id='fromDate']");
	 private By TO_DATE_FIELD = By.xpath("//input[@id='toDate']");
	 public By MESSAGE_AREA = By.xpath("//div[@id='messageArea']");
	 public By SEARCH_FORM = By.id("searchForm");
	 
	 private By RUN_REPORT_BUTTON = By.xpath("//input[@value='Run Report']");
	 private By CALENDAR_DATE_2 = By.xpath("//div[@id='ui-datepicker-div']//a[contains(.,'2')]");
	 private By CALENDAR_DATE_5 = By.xpath("//div[@id='ui-datepicker-div']//a[contains(.,'5')]");
	
	 public SchoolReportPage(WebDriver driver) {
		 super(driver);
		 this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	 
	 public void clickFromDate(){
		 click(FROM_DATE_FIELD);
		 ReporterText("Clicked on From Date Field.");
	 }
	 
	 public void clickToDate(){
		 click(TO_DATE_FIELD);
		 ReporterText("Clicked on To Date Field.");
	 }
	 
	 public void clickCalendarDate2(){
		 click(CALENDAR_DATE_2);
		 ReporterText("Clicked on Calendar Date 2.");
	 }
	 
	 public void clickCalendarDate5(){
		 click(CALENDAR_DATE_5);
		 ReporterText("Clicked on Calendar Date 5.");
	 }
	 
	 public void clickRunReport(){
		 click(RUN_REPORT_BUTTON);
		 ReporterText("Clicked on Run Report Button.");
	 }
	 
	 public String getMessageText(){
		 String tmp = getText(MESSAGE_AREA);
		 ReporterText("Getting MEssage Area Text = "+tmp);
		 return tmp;
	 }
	 
	 public String getDateYearText(){
		 String tmp = getText(DATE_PICKER_YEAR);
		 ReporterText("Getting Year Text from Date Picker. : "+tmp);
		 return tmp;
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
}
