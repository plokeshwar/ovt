package com.overture.npc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.overture.npc.common.PageControls;

public class StudentInformationPage extends PageControls{
	
	
	public StudentInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	public By QUESTION_TABLE = By.id("categoryTable");
	
	 // Accordion
	/*WebElements for Header Links */
	
	 public By GENERAL_HEADER_LINK = By.xpath("//table[@id='questionTable']//span[contains(.,'General')]");
	 public By ACADEMICS_HEADER_LINK = By.xpath("//table[@id='questionTable']//span[contains(.,'Academics')]");
	 public By ACTIVITIES_HEADER_LINK = By.xpath("//table[@id='questionTable']//span[contains(.,'Activities')]");
	 public By FAITH_HEADER_LINK = By.xpath("//table[@id='questionTable']//span[contains(.,'Faith')]");
	 public By FAMILY_HEADER_LINK = By.xpath("//table[@id='questionTable']//span[contains(.,'Family')]");
	 public By CAMPUSES_HEADER_LINK = By.xpath("//table[@id='questionTable']//span[contains(.,'Campuses and Schools')]");
	 public By UPPER_CLASS_HEADER_LINK = By.xpath("//table[@id='questionTable']//span[contains(.,'Upperclass and Transfer Students')]");
	 public By OTHER_SCHOOL_SPECIFIC_HEADER_LINK = By.xpath("//table[@id='questionTable']//span[contains(.,'Other School Specific')]");
	
	 
	 
	 /*WebElements of Tables in Accordion */
	 
	 public By GENERAL_TABLE = By.xpath("//table[@id='content_default']");
	 public By ACADEMICS_TABLE = By.xpath("//table[@id='content_academics']");
	 public By ACTIVITIES_TABLE = By.xpath("//table[@id='content_activities']");
	 public By FAITH_TABLE = By.xpath("//table[@id='content_faith']");
	 public By FAMILY_TABLE = By.xpath("//table[@id='content_family']");
	 public By CAMPUSES_TABLE = By.xpath("//table[@id='content_campuses_and_schools']");
	
	 public By UPPER_CLASS_TABLE = By.xpath("//table[@id='content_upperclass_and_transfer_students']");
	 public By OTHER_SCHOOL_SPECIFIC_TABLE = By.xpath("//table[@id='content_other_school_specific']");
	 
	 public void clickOnGeneralAccordian(){
		 click(GENERAL_TABLE);
		 ReporterText("Clicked on General Accordian.");
	 }
	 
	 public void clickOnAcademicsHeaderLink(){
		 click(ACADEMICS_HEADER_LINK);
		 ReporterText("Clicked on Academics Header Link.");
	 }
	 
	 public void clickOnActivitiesHeaderLink(){
		 click(ACTIVITIES_HEADER_LINK);
		 ReporterText("Clicked on Activities Header Link.");
	 }
	 
	 public void clickOnFaithHeaderLink(){
		 click(FAITH_HEADER_LINK);
		 ReporterText("Clicked on Faith Header Link.");
	 }
	 
	 public void clickOnFamilyHeaderLink(){
		 click(FAMILY_HEADER_LINK);
		 ReporterText("Clicked on Family Header Link.");
	 }
	 
	 public void clickOnCampusesHeaderLink(){
		 click(CAMPUSES_HEADER_LINK);
		 ReporterText("Clicked on Campuses Header Link.");
	 }
	 
	 public void clickOnUpperClassHeaderLink(){
		 click(UPPER_CLASS_HEADER_LINK);
		 ReporterText("Clicked on Upper Class Header Link.");
	 }
	 
	 public void clickOnOtherSpecificHeaderLink(){
		 click(OTHER_SCHOOL_SPECIFIC_HEADER_LINK);
		 ReporterText("Clicked on Other Specific Header Link.");
	 }
	 
	 /* Misc WebElements */
	 public By CANCEL_BUTTON = By.xpath("//form[@id='questionData']/p/input[@value='Cancel']");
	 public By SAVE_BUTTON = By.xpath("//form[@id='questionData']/p/input[@value='Save Changes']");
	
	 public By FORM_PARAGRAPH = By.xpath("//form[@id='questionData']/p");
	  
	 
	 public void performMouseOverSaveButton(){
			ReporterText("Performing Mouse Over Operation on Save Button.");
			mouseOver(SAVE_BUTTON);
		}
	 
    

}
