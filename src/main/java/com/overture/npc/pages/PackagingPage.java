package com.overture.npc.pages;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

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
	 
	 public By PARENT_CONTRIBUTION_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Parent Contribution')]");
	 public By STUDENT_CONTRIBUTION_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Student Contribution')]");
	 public By PELL_GRANT_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Pell Grant')]");
	 public By STUDENT_WORK_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Student Work')]");
	 
	 public By INSTITUTIONAL_GRANT_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Institutional  Grant - A')]");
	 public By STATE_GRANT_A_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'State Grant - A')]");
	 public By STUDENT_LOAN_A_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Student Loan - A')]");
	 public By PARENT_LOAN_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Parent Loan')]");
	 public By CONSOLIDATED_SELF_HELP_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Consolidated Self Help')]");
	 public By INSTITUTIONAL_SCHOLARSHIP_B_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Institutional Scholarship - B')]");
	 public By INSTITUTIONAL_SCHOLARSHIP_A_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Institutional Scholarship - A')]");
	 public By INSTITUTIONAL_GRANT_B_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Institutional  Grant - B')]");
	 
	 public By STATE_GRANT_B_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'State Grant - B')]");
	 public By STUDENT_LOAN_B_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Student Loan - B')]");
	 public By INSTITUTIONAL_SCHOLARSHIP_C_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Institutional Scholarship - C')]");
	 public By INSTITUTIONAL_GRANT_C_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Institutional  Grant - C')]");
	 public By STATE_GRANT_C_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'State Grant - C')]");
	 public By STUDENT_LOAN_C_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'Student Loan - C')]");
	 public By SCHOOL_DEFINED_FUND_1_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'School Defined Fund1')]");
	 public By SCHOOL_DEFINED_FUND_2_LINK = By.xpath("//table[@class='packageTable']//span[@class='popupLink' and contains(.,'School Defined Fund2')]");
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
	 public By FIXED_LINK = By.linkText("Fixed");
	 public By FACTOR_LINK = By.linkText("Factor of");
	 public By VALUE_TABLE_LINK = By.linkText("Value from Table");
	 public By PAGE_TITLE = By.xpath("//div[@class='pageTit']//h1");
	 public By NEW_ROW = By.xpath("//li[@id='list0']//tr//td[2]");
	 public By EDIT_PACKAGE_SAVE_BUTTON = By.xpath("//div[@class='saveButtonDiv']//input[@value='Save Changes']");
	 public By EDIT_PACKAGE_CANCEL_BUTTON = By.xpath("//div[@class='saveButtonDiv']//input[@value='Cancel']");
	 public By EDIT_PACKAGE_INPUT_FIELD = By.xpath("//table[@class='packEditTable']//tr//td[3]//input");
	 
	 private By SAVE_CHANGES_POPUP_NO = By.xpath("//button[contains(.,'No')]");
		private By SAVE_CHANGES_POPUP_YES = By.xpath("//button[contains(.,'Yes')]");
		private By SAVE_CHANGES_POPUP_TEXT = By.xpath("//div//h6");
		
		
		
		public void clickOnStateGrantALink(){
			click(STATE_GRANT_A_LINK);
			ReporterText("Clicked on State Grant A link.");
		}
		
		public void clickOnStateGrantBLink(){
			click(STATE_GRANT_B_LINK);
			ReporterText("Clicked on State Grant B link.");
		}
		
		public void clickOnStateGrantCLink(){
			click(STATE_GRANT_C_LINK);
			ReporterText("Clicked on State Grant C link.");
		}
		
		
		public void clickOnFixedLink(){
			click(FIXED_LINK);
			ReporterText("Clicked on fixed link present in the Edit  Parent Contribution page.");
		}
		
		public void typeInputPackageField(String testData){
			type(EDIT_PACKAGE_INPUT_FIELD, testData);
			ReporterText("Entering some values into the text field in Edit Packaging Parent Contribution page. :  "+testData);
		}
		
		public String getPackageFieldValue(){
			String tmp = getAttributeValue(EDIT_PACKAGE_INPUT_FIELD, "value");
			ReporterText("Getting attribute value from field Edit Package Input Field.  "+tmp);
			return tmp;
		}
		
		public String newRowGetText(){
			String tmp = getText(NEW_ROW);
			ReporterText("Extracting value from new row.  : "+tmp);
			return tmp;
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
			pause(2000);
			ReporterText("Clicked on Save Changes Popup Yes button.");
		}
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
	 
	 public void clickEditPackageSaveButton(){
		 click(EDIT_PACKAGE_SAVE_BUTTON);
		 ReporterText("Clicking on Edit Package Save Button.");
	 }
	 
	 public void clickEditPackageCancelButton(){
		 click(EDIT_PACKAGE_CANCEL_BUTTON);
		 ReporterText("Clicking on Edit Package Cancel Button.");
	 }
	 
	 public void clickOnValueTableLink(){
		 click(VALUE_TABLE_LINK);
		 ReporterText("Clicked on Value From Table link present in the Edit Packaging Parent Contribution page.");
	 }
	 
	 public void clickOnFactorLink(){
		 click(FACTOR_LINK);
		 ReporterText("Clicked on Add Factor of link present in the Edit Packaging Parent Contribution page.");
	 }
	 
	 public List<WebElement> getAssignmentPackageList(){
		 ReporterText("Getting Assignment Package List.");
		 return getElementList(ASSIGNMENT_PACKAGE_LIST);
	 }
	 
	 public void clickParentContributionLink(){
		 click(PARENT_CONTRIBUTION_LINK);
		 ReporterText("Clicking on parent contribution link.");
	 }
	 
	 public void clickStudentContributionLink(){
		 click(STUDENT_CONTRIBUTION_LINK);
		 ReporterText("Clicking on student contribution link.");
	 }
	 
	 public void clickStudentWorkLink(){
		 click(STUDENT_WORK_LINK);
		 ReporterText("Clicking on student work link.");
	 }
	 
	 public void clickInstitutionalGrantALink(){
		 click(INSTITUTIONAL_GRANT_LINK);
		 ReporterText("Clicking on Institutional Grant A link.");
	 }
	 
	 public void clickInstitutionalGrantBLink(){
		 click(INSTITUTIONAL_GRANT_B_LINK);
		 ReporterText("Clicking on Institutional Grant B link.");
	 }
	 
	 public void clickInstitutionalGrantCLink(){
		 click(INSTITUTIONAL_GRANT_C_LINK);
		 ReporterText("Clicking on Institutional Grant C link.");
	 }
	 
	 public void clickStudentLoanALink(){
		 click(STUDENT_LOAN_A_LINK);
		 ReporterText("Clicking on Student Loan A link.");
	 }
	 
	 public void clickStudentLoanBLink(){
		 click(STUDENT_LOAN_B_LINK);
		 ReporterText("Clicking on Student Loan B link.");
	 }
	 
	 public void clickStudentLoanCLink(){
		 click(STUDENT_LOAN_C_LINK);
		 ReporterText("Clicking on Student Loan C link.");
	 }
	 
	 public void clickParentLoanLink(){
		 click(PARENT_LOAN_LINK);
		 ReporterText("Clicked on Parent Loan Link in the Packaging Screen.");
	 }
	 
	 public void clickInstitutionalScholarshipALink(){
		 click(INSTITUTIONAL_SCHOLARSHIP_A_LINK);
		 ReporterText("Clicked on Institutional Scholarship A Link in the Packaging Screen.");
	 }
	 
	 public void clickInstitutionalScholarshipBLink(){
		 click(INSTITUTIONAL_SCHOLARSHIP_B_LINK);
		 ReporterText("Clicked on Institutional Scholarship B Link in the Packaging Screen.");
	 }
	 
	 public void clickInstitutionalScholarshipCLink(){
		 click(INSTITUTIONAL_SCHOLARSHIP_C_LINK);
		 ReporterText("Clicked on Institutional Scholarship C Link in the Packaging Screen.");
	 }
	 
	 public void clickConsolidatedSelfHelpLink(){
		 click(CONSOLIDATED_SELF_HELP_LINK);
		 ReporterText("Clicked on Consolidated Self Help Link in the Packaging Screen.");
	 }
	 
	 public void clickSchoolDefinedFund1Link(){
		 click(SCHOOL_DEFINED_FUND_1_LINK);
		 ReporterText("Clicked on School Defined Fund 1 Link in the Packaging Screen.");
	 }
	 
	 public void clickSchoolDefinedFund2Link(){
		 click(SCHOOL_DEFINED_FUND_2_LINK);
		 ReporterText("Clicked on School Defined Fund 2 Link in the Packaging Screen.");
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
    
	 public void deleteAssignmentPackages(){
			WebElement el=null;
			int size=getAssignmentPackageList().size();
			for(int i=0;i<size;i++){	
				el=driver.findElement(By.xpath("//li[@id='list"+i+"']//table//tr//td[2]"));
				if(el.getText().contains("Factor")){
					el=driver.findElement(By.xpath("//li[@id='list"+i+"']//table//tr//td[5]"));
					}
				else{
					el=driver.findElement(By.xpath("//li[@id='list"+i+"']//table//tr//td[4]"));
					}
				el.click();
				ReporterText("Deleting the existing list");
			}
		}
	 
	

}
