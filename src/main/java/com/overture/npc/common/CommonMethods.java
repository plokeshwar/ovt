package com.overture.npc.common;

public class CommonMethods extends Reporting {
	
	public void closeBrowser(){
		WebDriverManager.removeWebDriver();
	}

}
