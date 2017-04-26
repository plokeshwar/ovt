package com.overture.npc.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Select;

public class PageControls extends Reporting{

	WebDriver driver;

	public PageControls(WebDriver driver) {
		this.driver = driver;
	}

	
	
	public void click(By by) {
		waitForElement(by).click();
	}
	
	public void click(WebElement element){
		element.click();
	}
	
	public List<WebElement> getElementList(By by){
		return driver.findElements(by);
		}

	public void pageScrollDown(By by) {
		waitForElement(by).sendKeys(Keys.PAGE_DOWN);

	}

	
	public void alertOk(String browserName) {
		PhantomJSDriver phantomJSdriver = null;
		if (browserName.equalsIgnoreCase("phantomjs")) {
			phantomJSdriver = (PhantomJSDriver) driver;
			phantomJSdriver.executeScript("window.confirm = function(){return true;}");
		} else {
			alertHandler().accept();
		}

	}

	public void controlBackToDriver() {
		String parentWindowHandler = driver.getWindowHandle();
		driver.switchTo().window(parentWindowHandler);
	}

	public void clear(By by) {
		waitForElement(by).clear();
	}

	public void type(By by, String testData) {
		clear(by);
		waitForElement(by).sendKeys(testData);
	}

	public void selectDropDown(By by, String testData) {
		Select menu = new Select(waitForElement(by));
		try {
			menu.selectByVisibleText(testData);
		} catch (Exception e) {
			menu.selectByValue(testData);
		}

	}

	public String getText(By by) {
		String temp = waitForElement(by).getText();
		return temp;
	}

	public String getFirstSelectedDropDown(By by) {
		String txt = null;
		Select select = new Select(waitForElement(by));
		txt = select.getFirstSelectedOption().getText();
		return txt;

	}

	public List<WebElement> getAllOptions(By by){
		Select select = new Select(waitForElement(by));
		return select.getOptions(); 
	}
	
	public void browserClose(WebDriver driver) {
		driver.quit();
	}

	public Alert alertHandler() {
		return driver.switchTo().alert();
	}

	public String controlOfSubDriver() {
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		return subWindowHandler;

	}

	public String controlOfMainDriver() {
		String parentWindowHandler = driver.getWindowHandle();
		return parentWindowHandler;
	}

	public void driverSwitch(String Controller) {
		// Reporter.log(cm.ReporterText(msg));
		driver.switchTo().window(Controller);
	}

	public boolean isDisplayed(By by) {
		try {
			return waitForElement(by).isDisplayed();

		} catch (Exception e) {
			// Reporter.log(cm.ReporterTextError(e));
		}
		return false;
	}

	public boolean isEnabled(By by) {
		try {
			return waitForElement(by).isEnabled();
		} catch (Exception e) {
			// Reporter.log(cm.ReporterTextError(e));
		}
		return false;
	}

	public String getAttributeValue(By by, String attribute) {
		String temp = null;
		if (attribute.equalsIgnoreCase("href")) {
			temp = waitForElement(by).getAttribute("href");
		} else if (attribute.equalsIgnoreCase("value")) {
			temp = waitForElement(by).getAttribute("value");
		}
		return temp;
	}

	public String getURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String captureElementScreenShot(By by) {
		String fileName = String.valueOf(System.currentTimeMillis());

		String filePath = System.getProperty("user.dir") + "/Reports/Screenshot/" + fileName + ".jpg";

		WebElement el = waitForElement(by);
		ReporterText("Capturing Element ScreenShot.");

		if (el.isDisplayed() && el.isEnabled()) {
			for (int i = 0; i < 3; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", el,
						"color: red; border: 2px solid red;");

				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(scrFile, new File(filePath));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", el, "");
			}
			return filePath;
		} else {
			return captureDriverScreenShot();
		}
	}

	public String captureDriverScreenShot() {
		String fileName = String.valueOf(System.currentTimeMillis());
		String filePath = System.getProperty("user.dir") + "/Reports/Screenshot/" + fileName + ".jpg";

		ReporterText("Capturing Driver ScreenShot.");
		try {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(filePath));
			return filePath;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return filePath;

	}

	public void mouseOver(By by) {
		WebElement el = waitForElement(by);
		if (el.isDisplayed()) {
			Actions builder = new Actions(driver);
			builder.moveToElement(el).perform();
		} else {
			ReporterError("Performing Mouse Over Operation on element " + by.toString() + " Failed");
		}

	}

	public ArrayList<String> createArrayList(String text) {
		String[] st = text.split(",");
		ArrayList<String> str = new ArrayList<String>();
		for (int i = 0; i < st.length; i++) {
			str.add(st[i].trim());
		}
		ReporterText("Expected Link List : " + str);
		return str;
	}

	public ArrayList<String> getAllLinksByClass(By by) {
		WebElement table = waitForElement(by);
		ArrayList<String> stringList = new ArrayList<String>();
		List<WebElement> anchors = table.findElements(By.tagName("a"));
		for (WebElement e : anchors) {
			stringList.add(e.getText());
		}
		ReporterText("Actual Link List : " + stringList);
		return stringList;
	}

	
	public WebElement waitForElement(By by) {
		if(driver == null){
			try {
				throw  new Exception("Driver is NULL");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
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
	
	public void focusElement(By by) {

		try {
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(0," + driver.findElement(by).getLocation().y + ")");
		} catch (Exception e) {
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(0," + driver.findElement(by).getLocation().x + ")");
		}

	}
	
	public void pause(int msSeconds) {
		try {
			Thread.sleep(msSeconds);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
