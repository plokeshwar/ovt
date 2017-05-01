package com.overture.npc.common;

import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory extends Reporting {

	
	public static Properties CONFIG = null;
	public static URL remoteAddress;
	public static String browser;
	public static String url;
	
	
	public enum selectDriver {
		CHROME, FIREFOX, IE, PHANTOMJS
	}
	
	static WebDriver createInstance() {
		WebDriver driver = null;

		CONFIG = new Properties();
		try {
			FileInputStream fs = new FileInputStream("src/main/java/com/overture/npc/configs/config.properties");
			CONFIG.load(fs);
			if(CONFIG.getProperty("remoteAddress") != null){
			remoteAddress = new URL(CONFIG.getProperty("remoteAddress"));
			}
		
			browser = CONFIG.getProperty("browser");
			url = CONFIG.getProperty("url");
		} catch (Exception e) {
		
		}
		
		driver = intantiateDriver(browser);
		driver.get(url);
		return driver;
	}
	
	

	public static WebDriver intantiateDriver(String driverType) {
		WebDriver driver = null;
		selectDriver driverName = selectDriver.valueOf(driverType.toUpperCase());

		switch (driverName) {

		case CHROME:
			System.out.println("Chrome Driver Initiated");
			driver = getChromeDriver();
			break;

		case FIREFOX:
			System.out.println("Firefox Driver Initiated");
			driver = getFirefoxDriver();
			break;

		case IE:
			System.out.println("IE Driver Initiated");
			driver = getIE();
			break;
			
		case PHANTOMJS:
			System.out.println("Phantomjs Driver Initiated");
			driver = getPhantomJS();
			break;

		}
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver getChromeDriver() {
		Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.setExperimentalOption("prefs", prefs);
		
		if (MacPlatform()) {
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/drivers/windows/chromedriver.exe");
		}

		System.out.println("STARTING CHROME DRIVER");

		return new ChromeDriver(options);
	}

	public static WebDriver getIE() {

		DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
		capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		System.setProperty("webdriver.ie.driver",
				System.getProperty("usr.dir") + "/drivers/windows/IEDriverServer.exe");
		
		return new InternetExplorerDriver(capab);
	}

	public static WebDriver getFirefoxDriver() {
		
		System.out.println(" HELLO FIREFOX DRIVER");
		return new FirefoxDriver();
	}
	
	public static WebDriver getPhantomJS(){
		System.out.println("Starting Phantom JS Ghost Browser");
		DesiredCapabilities dCaps = new DesiredCapabilities();
		if (MacPlatform()) {
			dCaps.setCapability("phantomjs.binary.path", "/usr/bin/phantomjs");
		} else {
			dCaps.setCapability("phantomjs.binary.path",
						System.getProperty("user.dir")  + "/drivers/windows/phantomjs.exe");
		}
			
		
		dCaps.setJavascriptEnabled(true);
		dCaps.setCapability("takesScreenshot", true);
		return new PhantomJSDriver(dCaps);
	}

	public static boolean MacPlatform() {
		Platform current = Platform.getCurrent();
		return Platform.MAC.is(current);
	}
}
