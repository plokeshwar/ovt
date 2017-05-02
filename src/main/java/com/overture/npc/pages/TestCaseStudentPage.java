package com.overture.npc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.overture.npc.common.PageControls;



public class TestCaseStudentPage extends PageControls {



	public TestCaseStudentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public By PAGE_TITLE = By.xpath("//div[@id='main']//div[@class='title']");
	public By LEAVE_CALCULATOR = By.xpath("//div[@id='navigation']//a[contains(.,'Leave Calculator')]");
	public By ENTER_AS_GUEST_LINK = By.xpath("//button[@id='next']");
	
	public By AFTER_LEAVING_GUEST_PAGE_HEADER = By.xpath("//div[@class='container']//div[@class='content']//h2");
	
	//====================================================
		//  Student Information
	
	public By STUDENT_FIRST_NAME = By.id("student.firstName");
	public By STUDENT_COMPLETING_CALCULATOR = By.id("student.completingCalculator");
	public By STUDENT_BIRTH_YEAR = By.id("student.birthYear");
	public By STUDENT_GRADE_YEAR_CODE = By.id("student.gradeYearCode");
	public By STUDENT_RESIDENCY_STATE_CODE = By.id("student.residencyStateCode");
	public By STUDENT_MARITAL_STATUS_CODE = By.id("student.maritalStatusCode");
	public By STUDENT_HOUSING_CODE = By.id("student.housingCode");
	
	
	public void enterStudentFirstName(String testData){
		type(STUDENT_FIRST_NAME, testData);
		ReporterText("Entering student first name in Student Preview Page.");
	}
	
	public void selectUserCompletingTheCalculator(String testData){
		selectDropDown(STUDENT_COMPLETING_CALCULATOR, testData);
		ReporterText("Selecting the user completing the calculator in Student Preview Page. "+testData);
	}
	
	public void selectStudentYearOfBirth(String testData){
		selectDropDown(STUDENT_BIRTH_YEAR, testData);
		ReporterText("Selecting the user year of birth in Student Preview Page. "+testData);
	}
	
	public void selectStudentCurrentGrade(String testData){
		selectDropDown(STUDENT_GRADE_YEAR_CODE, testData);
		ReporterText("Selecting the user current grade year in Student Preview Page. "+testData);
	}
	
	public void selectStudentResidenceState(String testData){
		selectDropDown(STUDENT_RESIDENCY_STATE_CODE, testData);
		ReporterText("Selecting the user residency state in Student Preview Page. "+testData);
	}
	
	public void selectStudentMaritalStatus(String testData){
		selectDropDown(STUDENT_MARITAL_STATUS_CODE, testData);
		ReporterText("Selecting the user marital status in Student Preview Page. "+testData);
	}
	
	public void selectStudentHousing(String testData){
		selectDropDown(STUDENT_HOUSING_CODE, testData);
		ReporterText("Selecting the user housing code in Student Preview Page. "+testData);
	}
	
	
	
	
//====================================================
//  Parent HouseHold Information

	public By PARENT_MARITAL_STATUS_CODE = By.id("parent.maritalStatusCode");
	public By PARENT_BIRTH_YEAR = By.id("parent.birthYear");
	public By PARENT_RESIDENCY_STATE_CODE = By.id("parent.residencyStateCode");
	public By PARENT_HOUSEHOLD_COUNT = By.id("parent.householdCount");
	public By PARENT_HOUSEHOLD_COLLEGE_COUNT = By.id("parent.householdCollegeCount");
	public By PARENT_TAX_FORM_CODE = By.id("parent.taxFormCode");
	public By PARENT_ANNUAL_GROSS_INCOME = By.id("parent.agi");
	
	public void selectParentMaritalStatus(String testData){
		selectDropDown(PARENT_MARITAL_STATUS_CODE, testData);
		ReporterText("Selecting the user marital status in Student Preview Page. "+testData);
	}
	
	public void selectParentYearOfBirth(String testData){
		selectDropDown(PARENT_BIRTH_YEAR, testData);
		ReporterText("Selecting the user year of birth in Student Preview Page. "+testData);
	}
	
	public void selectParentResidenceState(String testData){
		selectDropDown(PARENT_RESIDENCY_STATE_CODE, testData);
		ReporterText("Selecting the user residency state in Student Preview Page. "+testData);
	}
	
	public void selectParentHouseholdCount(String testData){
		selectDropDown(PARENT_HOUSEHOLD_COUNT, testData);
		ReporterText("Selecting the user household count in Student Preview Page. "+testData);
	}
	
	public void selectParentHouseholdCollegeCount(String testData){
		selectDropDown(PARENT_HOUSEHOLD_COLLEGE_COUNT, testData);
		ReporterText("Selecting the user household college count in Student Preview Page. "+testData);
	}
	
	public void selectParentTaxFormCode(String testData){
		selectDropDown(PARENT_TAX_FORM_CODE, testData);
		ReporterText("Selecting the user tax form code in Student Preview Page. "+testData);
	}
	
	public void enterParentGrossIncome(String testData){
		type(PARENT_ANNUAL_GROSS_INCOME, testData);
		ReporterText("Entering Parent gross annual income in Student Preview Page.");
	}
	
	
	
	
	
//====================================================
//  Parent Income Information
	
	public By PARENT_INCOME = By.id("parent.wageIncome");
	public By PARENT_ONE_WORK_INCOME = By.id("parent.parent1WorkIncome");
	public By PARENT_TWO_WORK_INCOME = By.id("parent.parent2WorkIncome");
	public By PARENT_INTEREST_INCOME = By.id("parent.InterestIncome");
	public By PARENT_BUSSINESS_INCOME = By.id("parent.businessIncome");
	public By PARENT_OTHER_INCOME = By.id("parent.otherIncome");
	public By PARENT_ADJUSTMENT_TO_INCOME = By.id("parent.adjustmentToIncome");
	public By PARENT_EDUCATION_TAX_CREDIT_AMOUNT = By.id("parent.educationTaxCreditAmount");
	public By PARENT_UNTAXED_INCOME = By.id("parent.untaxedIncome");
	public By PARENT_TAX_EXEMPTION_COUNT = By.id("parent.taxExemptionCount");
	
//====================================================
//  Parent Assets Information
	
	public By PARENT_ASSET_CASH_AMOUNT = By.id("parent.cashAmount");
	public By PARENT_ASSET_CHILD_SUPPORT_PAID_AMOUNT = By.id("parent.childSupportPaidAmount");
	
//====================================================
//  Student Finances Information
	
	public By STUDENT_WORK_INCOME = By.id("student.workIncome");
	public By STUDENT_UNTAXED_INCOME = By.id("student.untaxedIncome");
	public By STUDENT_CASHOUT_AMOUNT = By.id("student.cashAmount");
	
	
//====================================================
//  Common Elements
	
	public By BACK_BUTTON = By.xpath("//button[@id='back']");
	public  By NEXT_BUTTON = By.className("btn-next");
	public By CALCULATE_BUTTON = By.xpath("//div[@class='submit-btns']//button[contains(.,'CALCULATE')]");
	
	
	public void clickBackButton(){
		click(BACK_BUTTON);
		pause(2000);
		ReporterText("Clicking on Back Button on Student Preview Page.");
	}
	
	public void clickNextButton(){
		click(NEXT_BUTTON);
		pause(2000);
		ReporterText("Clicking on Next Button on Student Preview Page.");
	}
	
	public void clickLeaveCalculator(){
		click(LEAVE_CALCULATOR);
		pause(5000);
		ReporterText("Clicking on Leave Calculator on Student Preview Page.");
	}
	
	public void clickEnterAsGuestLink(){
		click(ENTER_AS_GUEST_LINK);
		pause(2000);
		ReporterText("Clicking on Enter as Guest Link on Student Preview Page.");
	}
	
	public String getPageHeaderTitle(){
		String tmp = getText(PAGE_TITLE);
		ReporterText("Extracting page title from the Student Preview Page.  : "+tmp);
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
