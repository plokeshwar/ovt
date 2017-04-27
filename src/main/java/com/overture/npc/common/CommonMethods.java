package com.overture.npc.common;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class CommonMethods extends Reporting {
	
	public void closeBrowser(){
		WebDriverManager.removeWebDriver();
	}
	
	public String generateRandomString(){
		return "Random"+String.valueOf(System.currentTimeMillis());
	}

	public ArrayList<String> getColumnHeaderByTable(WebElement table) {
		ArrayList<String> stringList=null;
		List<WebElement> anchors = table.findElements(By.tagName("th"));
		 Iterator<WebElement> i = anchors.iterator(); 
		 stringList = new ArrayList<String>();
		 while(i.hasNext()) { 
			 WebElement anchor = i.next(); 
			 stringList.add(anchor.getText());
		 }
	ReporterText("Actual Link List : "+stringList);
	return stringList;
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
