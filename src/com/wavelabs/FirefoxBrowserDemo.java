package com.wavelabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Firefox Driver
		
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://stg3:RfxdLT6i@intl-stg3.care.com/en-gb/");
		System.out.println("Title is :"+driver.getTitle());
		
		

	}

}
