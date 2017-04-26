package com.overture.npc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.overture.npc.common.PageControls;

public class CostOfAttendancePage extends PageControls {
	WebDriver driver;
	public CostOfAttendancePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public By COA_TABLE = By.id("coaTable");;
	public By TUITION_FEE_LINK = By.xpath("//table[@id='coaTable']//a[contains(.,'Tuition & Fees')]");
	public By ROOM_BOARD_LINK = By.xpath("//table[@id='coaTable']//a[contains(.,'Room & Board')]");
	public By BOOK_SUPPLIES_LINK = By.xpath("//table[@id='coaTable']//a[contains(.,'Books & Supplies')]");
	public By TRANSPORTATION_LINK = By.xpath("//table[@id='coaTable']//a[contains(.,'Transportation')]");
	public By PERSONAL_EXPENSES_LINK = By.xpath("//table[@id='coaTable']//a[contains(.,'Personal Expenses')]");
	public By PAGE_TITLE = By.xpath("//div[@class='pageTit']");
	public By FIXED_LINK = By.name("addFixedRow");
	public By ROW_ONE = By.id("rowId1");
	public By FIXED_VALUE_ONE = By.id("fixedValue1");
	public By DELETE_ROW_ONE = By.xpath("//table[@id='myRuleTable']//tr[3]//td[5]");
	public By CANCEL_BUTTON = By.xpath("//form[@id='expenseRuleForm']//input[@value='Cancel']");
	public By SAVE_CHANGES_BUTTON = By.xpath("//form[@id='expenseRuleForm']//input[@value='Save Changes']");
	
	public By COA_FIXED_ROWS = By.xpath("//table[@id='myRuleTable']//tr");
	public By POPUP_YES_BUTTON = By.xpath("//button[@type='button']/span[.='Yes']");
	public By POPUP_NO_BUTTON = By.xpath("//button[@type='button']/span[.='No']");
	public By POPUP_TEXT = By.xpath("//h6");
	
	
	public void enterFixedValueOne(String testdata){
		type(FIXED_VALUE_ONE, testdata);
		ReporterText("Entered Value in Edit Expense page. "+testdata);
	}
	//public List<WebElement> coaFixedRows;

	public String getFixedValueAttribute(){
		String tmp = getAttributeValue(FIXED_VALUE_ONE, "value");
		ReporterText("Extracting attribute value from field Fixed Value.  : "+tmp);
		return tmp;
	}
	
	public void clickTuitionFeeLink(){
		click(TUITION_FEE_LINK);
		pause(2000);
		ReporterText("Clicked on Tuition Fee Link");
	}
	
	public void clickRoomBoardLink(){
		click(ROOM_BOARD_LINK);
		pause(2000);
		ReporterText("Clicked on Room Board Link");
	}
	
	public void clickTransportationLink(){
		click(TRANSPORTATION_LINK);
		pause(2000);
		ReporterText("Clicked on Transportation Link");
	}
	
	public void clickPersonalExpensesLink(){
		click(PERSONAL_EXPENSES_LINK);
		pause(2000);
		ReporterText("Clicked on Personal Expenses Link");
	}
	
	public void clickBookAndSuppliesLink(){
		click(BOOK_SUPPLIES_LINK);
		pause(2000);
		ReporterText("Clicked on Book And Supplies Link");
	}
	
	
	public void clickFixedLink(){
		click(FIXED_LINK);
		ReporterText("Clicking on Fixed Link in Edit Expense page.");
	}
	
	public boolean rowOneDisplayed(){
		ReporterText("Validating Row One is Displayed.  : "+isDisplayed(ROW_ONE));
		return isDisplayed(ROW_ONE);
	}
	
	public void clickYesButtonPopUp(){
		click(POPUP_YES_BUTTON);
		ReporterText("Clicking on Yes Button in the Save Changes Popup");
	}
	
	public void clickNoButtonPopUp(){
		click(POPUP_NO_BUTTON);
		ReporterText("Clicking on No Button in the Save Changes Popup");
	}
	
	public String getPopupText(){
		String tmp = getText(POPUP_TEXT);
		ReporterText("Extracting Popup Text : "+tmp);
		return tmp;
	}
	
	public void clickSaveChangesButton(){
		click(SAVE_CHANGES_BUTTON);
		ReporterText("Clicking on Save Changes button in Edit Expense page.");
	}
	
	public void clickCancelButton(){
		click(CANCEL_BUTTON);
		ReporterText("Clicking on Cancel button in Edit Expense page.");
	}
	
	public void deleteCOAExpense(){
			for(int i=2;i<waitForElements(COA_FIXED_ROWS).size();i++){
					WebElement el=driver.findElement(By.xpath("//table[@id='myRuleTable']//tr["+i+"]//td[5]"));
					click(el);
					ReporterText("Clicking On Delete Image in Edit Expense Page.");
			}
		
		clickSaveChangesButton();
		clickYesButtonPopUp();
		
	}
	
	public void deleteRowOne(){
		click(DELETE_ROW_ONE);
		ReporterText("Clicking On Delete Image in Edit Expense Page.");
		clickSaveChangesButton();
		clickYesButtonPopUp();
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
}
