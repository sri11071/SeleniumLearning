package com.wavelabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowserDemo {

	public static void main(String[] args) {

	//Firefox Driver
		
		System.setProperty("webdriver.ie.driver","D:\\Selenium\\drivers\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.get("https://www.google.com/");
		//driver.get("https://stg3:RfxdLT6i@intl-stg3.care.com/en-gb/");
		System.out.println("Title is :"+driver.getTitle());
	}

}
