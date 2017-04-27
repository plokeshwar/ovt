package com.overture.npc.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.overture.npc.common.PageControls;

public class PackagingPage extends PageControls {
	
	 public PackagingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//======= Packaging Tab Elements
	 
	 public By PACKAGING_TAB_LINK = By.xpath("//div[@id='packagingtabs']//a[contains(.,'Packaging')]");;
	 public By PACKAGING_TABLE = By.xpath("//div[@id='menuTabs-11']");
	 public By PACKAGING_TABLE_LINKS = By.xpath("//div[@id='menuTabs-11']//li//table//tbody//tr//td//span");
	 public By NON_DEFAULT_PACKAGE_LIST = By.xpath("//ul[@id='packageList']//input[@name='activeStatuses']");;
	 public By DEFAULT_PACKAGE_LIST = By.id("unsortableList");;
	 public By PACKAGING_TAB_SAVE_CHANGES_BUTTON = By.xpath("//div[@id='menuTabs-11']//input[@value='Save Changes']");;
	 public By PACKAGING_TAB_CANCEL_BUTTON = By.xpath("//div[@id='menuTabs-11']//input[@value='Cancel']");;
	 public By PARENT_CONTRIBUTION_ACTIVE_STATUS = By.xpath("//ul[@id='unsortableList']/li[contains(.,'Parent Contribution')]/table/tbody/tr/td[4]");;
	 public By STUDENT_CONTRIBUTION_ACTIVE_STATUS = By.xpath("//ul[@id='unsortableList']/li[contains(.,'Student Contribution')]/table/tbody/tr/td[4]");;
	 public By PELL_GRANT_ACTIVE_STATUS = By.xpath("//ul[@id='unsortableList']/li[contains(.,'Pell Grant')]/table/tbody/tr/td[4]");;
	 
	 public By PARENT_CONTRIBUTION_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Parent Contribution')]");
	 public By STUDENT_CONTRIBUTION_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Student Contribution')]");
	 public By PELL_GRANT_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Pell Grant')]");
	 public By STUDENT_WORK_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Student Work')]");
	 
	 public By INSTITUTIONAL_GRANT_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional  Grant - A')]");
	 public By STATE_GRANT_A_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'State Grant - A')]");
	 public By STUDENT_LOAN_A_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Student Loan - A')]");
	 public By PARENT_LOAN_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Parent Loan')]");
	 public By CONSOLIDATED_SELF_HELP_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Consolidated Self Help')]");
	 public By INSTITUTIONAL_SCHOLARSHIP_B_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional Scholarship - B')]");
	 public By INSTITUTIONAL_SCHOLARSHIP_A_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional Scholarship - A')]");
	 public By INSTITUTIONAL_GRANT_B_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional  Grant - B')]");
	 
	 public By STATE_GRANT_B_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'State Grant - B')]");
	 public By STUDENT_LOAN_B_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Student Loan - B')]");
	 public By INSTITUTIONAL_SCHOLARSHIP_C_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional Scholarship - C')]");
	 public By INSTITUTIONAL_GRANT_C_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional  Grant - C')]");
	 public By STATE_GRANT_C_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'State Grant - C')]");
	 public By STUDENT_LOAN_C_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Student Loan - C')]");
	 public By SCHOOL_DEFINED_FUND_1_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'School Defined Fund1')]");
	 public By SCHOOL_DEFINED_FUND_2_LINK = By.xpath("//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'School Defined Fund2')]");
	 public By ASSIGNMENT_PACKAGE_LIST = By.xpath("//div[@class='packageCategory']//li");
	 
	 //public List<WebElement> assignmentPackageList;
	 
	 //======= Global Settings Tab Elements
	 
	 public By VALIDATION_ERROR = By.xpath("//div[@id='jsValidationArea']");
	 public By GLOBAL_SETTINGS_TAB_LINK = By.xpath("//div[@id='packagingtabs']//a[contains(.,'Global Settings')]");
	 public By GLOBAL_SETTINGS_TABLE = By.xpath("//div[@id='menuTabs-12']");
	 public By GLOBAL_SETTINGS_TABLE_LINKS = By.xpath("//div[@id='menuTabs-12']//div[@class='pageTit']");
	 public By GLOBAL_SETTINGS_SAVE_CHANGES_BUTTON = By.xpath("//div[@id='menuTabs-12']//input[@value='Save Changes']");
	 public By GLOBAL_SETTINGS_CANCEL_BUTTON = By.xpath("//div[@id='menuTabs-12']//input[@value='Cancel']");
	 public By GLOBAL_SETTINGS_SAVE_PAGE_TITLE = By.xpath("//div[@id='menuTabs-12']//div[@class='pageTit']");
	 public By GLOBAL_SETTINGS_GLOBAL_CAPLIST = By.name("globalCapStatus");
	 //public List<WebElement> globalSettingsGlobalCapList;
	 
	 public By GLOBAL_SETTINGS_GLOBAL_FLOORLIST = By.name("globalFloorStatus");
	 //public List<WebElement> globalSettingsGlobalFloorList;
	  
	 //Edit Packaging
	 public By FIXED_LINK = By.xpath("//span[@class='packageAdder' and contains(.,'Fixed')]");
	 public By FACTOR_LINK = By.xpath("//span[@class='packageAdder' and contains(.,'Factor of')]");
	 public By VALUE_TABLE_LINK = By.xpath("//span[@class='packageAdder' and contains(.,'Value from Table')]");
	 public By PAGE_TITLE = By.xpath("//div[@class='pageTitle' and contains(.,'Edit Packaging')]//span[@id='packageName']");
	 public By NEW_ROW = By.xpath("//li[@id='list0']//tr//td[2]");
	 public By EDIT_PACKAGE_SAVE_BUTTON = By.xpath("//div[@class='saveButtonDiv']//input[@value='Save Changes']");
	 public By EDIT_PACKAGE_CANCEL_BUTTON = By.xpath("//div[@class='saveButtonDiv']//input[@value='Cancel']");
	 public By EDIT_PACKAGE_INPUT_FIELD = By.xpath("//table[@class='packEditTable']//tr//td[3]//input");
	 
	 public TreeSet<String> getAllLinksFromPackageTable(){
		 return getAllLinksInTag(PACKAGING_TABLE, PACKAGING_TABLE_LINKS);
	 }
	 
	 public TreeSet<String> getAllLinksFromGlobalSettingsTable(){
		 return getAllLinksInTag(GLOBAL_SETTINGS_TABLE, GLOBAL_SETTINGS_TABLE_LINKS);
	 }
	 
	 public void clickPackagingTabLink(){
		 click(PACKAGING_TAB_LINK);
		 ReporterText("Clicked on Packaging Tab in the Packaging Screen.");
	 }
	 
	 public void clickGlobalSettingsSaveButton(){
		 click(GLOBAL_SETTINGS_SAVE_CHANGES_BUTTON);
		 ReporterText("Clicked on Global Settings Save Button in the Packaging Screen.");
	 }
	 
	 public String getPackagingTabText(){
		 return getText(PACKAGING_TAB_LINK);
	 }
	 
	 public String getGlobalSettingsTabText(){
		 return getText(GLOBAL_SETTINGS_TAB_LINK);
	 }
	 
	 public void clickGlobalSettingsTabLink(){
		 click(GLOBAL_SETTINGS_TAB_LINK);
		 ReporterText("Clicked on the Global Settings Tab in the Packaging Screen");
		 
	 }
	 
	 public boolean elementIsDisplayed(By by){
		 return isDisplayed(by);
	 }
	 
	 public TreeSet<String> getExpectedArrayList(String text){
			return createTreeSetList(text);
		}
	 public boolean validateCheckboxCapLimit(){
		 return findCheckboxEnabled(GLOBAL_SETTINGS_GLOBAL_CAPLIST);
	 }
	 
	 public boolean validateCheckboxFloorLimit(){
		 return findCheckboxEnabled(GLOBAL_SETTINGS_GLOBAL_FLOORLIST);
	 }
	 
	 public TreeSet<String> getPackagingTabSubMenu(){
			return getAllLinksByClass(PACKAGING_TABLE);
		}
	 
	
	 
	 public String assertObjects(Object expected, Object actual) {
			if (expected == actual) {
				ReporterSuccess("Expected [ "+expected+" ]");
				ReporterSuccess("Actual [ "+actual+" ]");
				return captureDriverScreenShot();
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
	 
	 public void globalSettingsTextBoxValidator_Valid(By by, String txt) {
			List<WebElement> element = driver.findElements(by);
			String expected="Are you sure you want to save?";
			String actual=null;
			Iterator<WebElement> i = element.iterator(); 
			 while(i.hasNext()) { 
				WebElement anchor = i.next(); 
				if(anchor.isDisplayed()){
					
					String name=anchor.getAttribute("name");
					String value=anchor.getAttribute("value");
						if(!anchor.isSelected())
						{
						anchor.click();
						}
					WebElement el=driver.findElement(By.name(name.substring(0,name.indexOf("Status"))+"Value["+value+"]"));
					type(el, txt);
					clickGlobalSettingsSaveButton();
					 actual = getAlertText();
					dismissAlert();
					ReporterTextBold("ScreenShot Not Taken as Validating PopUP Existence");
					Assert.assertEquals(actual, expected);
					el.clear();
					anchor.click();
				 }	 
			 } 
				
	}
    

}
