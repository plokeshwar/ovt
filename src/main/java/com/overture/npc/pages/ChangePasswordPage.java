package com.overture.npc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.overture.npc.common.PageControls;

public class ChangePasswordPage extends PageControls {

	private By PAGE_TITLE = By.xpath("//div[@class='pageTit']//h1");

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
	}

	public String getChangePasswordTitle() {
		System.out.println("Getting Change Password Title.");
		ReporterText("Extracting Change Password Page Title");
		return getText(PAGE_TITLE);
	}

	public String assertTitle(String expected, String actual) {
		if (expected.equalsIgnoreCase(actual)) {
			return captureElementScreenShot(PAGE_TITLE);
		} else {
			return captureDriverScreenShot();
		}
	}

}
