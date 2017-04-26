package com.overture.npc.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverWaitUtil {
	WebDriver driver;

	public WebDriverWaitUtil(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * 
	 * This method will wait for the element to be loaded and return WebElement if found
	 *
	 * */

	public WebElement waitForElement(By by) {
		if(driver.equals(null))
			 new Exception("Driver is NULL");
		
		for (int i = 0; i < 25; i++) {
			try {
				driver.findElement(by).isDisplayed();
				driver.findElement(by).isEnabled();
				focusElement(by);
				return driver.findElement(by);

			} catch (Exception e) {
				pause(500);

			}
			if(i==25){
				try {
					throw new Exception("Element Not Found.  "+by.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return driver.findElement(by);

	}
	
	/**
	 * This method will get the focus on the element.
	 * @param by
	 */

	public void focusElement(By by) {

		try {
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(0," + driver.findElement(by).getLocation().y + ")");
		} catch (Exception e) {
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(0," + driver.findElement(by).getLocation().x + ")");
		}

	}
	
	/**
	 * This method will pause the execution based on the parameter
	 * @param msSeconds
	 */

	public void pause(int msSeconds) {
		try {
			Thread.sleep(msSeconds);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
