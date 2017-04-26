package com.overture.npc.common;

import java.io.FileInputStream;
import java.util.Properties;

public class CommonMethods extends Reporting {

	public void closeBrowser() {
		WebDriverManager.removeWebDriver();
	}

	public Properties getProperties() {
		Properties CONFIG = new Properties();
		try {
			FileInputStream fs = new FileInputStream("src/main/java/com/overture/npc/configs/config.properties");
			CONFIG.load(fs);
		} catch (Exception e) {

		}
		return CONFIG;	
	}

}
