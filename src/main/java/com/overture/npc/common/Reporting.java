package com.overture.npc.common;

import org.testng.Reporter;

public class Reporting {
	
	public void ReporterText(String message) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Reporting Text : "+message);
		Reporter.log("<br><span>" + message + "</span>");
	}
	
	public void ReporterTextBold(String message) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Reporting Bold Text : "+message);
		Reporter.log("<br><span><b>" + message + "</b></span>");
	}
	
	
	
	public void ReporterError(String message) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.err.println("Reporting Error : "+message);
		Reporter.log("<br><span style='color: red;'><b>" + message + "</b></span>");
	}
	
	public void ReporterSuccess(String message) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Reporting Success : "+message);
		Reporter.log("<br><span style='color: green;'><b>" + message + "</b></span>");
	}
	
	
	public void ReporterLink(String screenshotFile) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Reporting Link : "+screenshotFile);
		Reporter.log("<a href=\""+screenshotFile
				+ "\"><p align=\"left\"><h4>Screenshot</h4></p></a>");
	}

	public void ReporterLink(String screenshotFile, String message) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Reporting Link : "+screenshotFile);
		Reporter.log("<a href=\""+screenshotFile
				+ "\"><p align=\"left\"><h4>Screenshot : "+message+"</h4></p></a>");
	}
	
	public void ReporterLinkError(String screenshotFile, String message) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Reporting Link : "+screenshotFile);
		Reporter.log("<a href=\""+screenshotFile
				+ "\"><p align=\"left\"><h4 style='color: red;'>Screenshot : "+message+"</h4></p></a>");
	}
}
