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
	
	public String getRandomNumberString(int size){
		String tmp = String.valueOf(System.currentTimeMillis());
		tmp = tmp.substring(tmp.length()-size, tmp.length());
		if(tmp.startsWith("0")){
			tmp="1"+tmp.substring(1,tmp.length());
		}
		return tmp;
	}

}
