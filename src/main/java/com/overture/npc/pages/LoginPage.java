package com.overture.npc.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.overture.npc.common.CommonMethods;
import com.overture.npc.common.PageControls;

public class LoginPage extends PageControls {
	
	WebDriver driver;

	private By USERNAME = By.id("username");
	private By PASSWORD = By.id("password");
	private By LOGIN_BUTTON = By.xpath("//input[@value='Log In']");
	private By ERROR_MESSAGE = By.xpath("//div[@class='errorMessage']");
	private By FORGOT_PASSWORD_LINK = By.linkText("Forgot your password?");
	// private By HEADER = By.id("header");
	private By PASSWORD_RESET_DIALOG_TITLE = By.xpath("//span[@id='ui-id-1']");
	private By RESET_USER_ID = By.id("resetUsername");
	private By RESET_USER_EMAILADD = By.id("email");
	private By RESET_BUTTON = By.xpath("//div[@class='submit']//input[@value='Reset']");
	private By CANCEL_BUTTON = By.xpath("//div[@class='submit']//input[@value='Cancel']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterUserName(String username){
		type(USERNAME, username);
		username = mask(username);
		ReporterText("Entered Username : "+username);
	}
	
	public void enterPassword(String password){
		type(PASSWORD, password);
		password = mask(password);
		ReporterText("Entered Password : "+password);
	}
	
	public void clickLogin(){
		click(LOGIN_BUTTON);
		ReporterText("Clicking on Login Button.");
	}
	
	public void enterResetUserID(String testData){
		type(RESET_USER_ID, testData);
	}
	
	public void enterResetUserEmailAddress(String testData){
		type(RESET_USER_EMAILADD, testData);
	}
	
	public void clickResetPasswordOkButton(){
		click(RESET_BUTTON);
	}
	
	public HomePage login() {
		Properties props = new CommonMethods().getProperties();
		enterUserName(props.getProperty("username"));
		enterPassword(props.getProperty("password"));
		clickLogin();
		return new HomePage(driver);
	}

	
	public HomePage login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickLogin();
		return new HomePage(driver);
	}

		public String getErrorText() {
		return getText(ERROR_MESSAGE);
	}

	public void clickForgotPasswordLink() {
		click(FORGOT_PASSWORD_LINK);
	}

	public String getPasswordResetBoxTitle() {
		return getText(PASSWORD_RESET_DIALOG_TITLE);
	}
	
	public String mask(String data){
		String tmp = "";
		
		for(int i=0;i<data.length();i++){
			
			if(i==0 || i==1){
			tmp = tmp+String.valueOf(data.charAt(i));
			}else if(i==data.length()-2 || i==data.length()-1){
				tmp = tmp+String.valueOf(data.charAt(i));
			}else{
				tmp = tmp+"x";
			}
		}
		
		return tmp;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new LoginPage(null).mask("PRAVIN"));
	}
	
	
	
	

}
