package com.wavelabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutosuggestDropDownExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://stg3:RfxdLT6i@intl-stg3.care.com/en-gb/");
		System.out.println("title is "+driver.getTitle());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='geoRegionSearch']")));
		WebElement postCode= driver.findElement(By.xpath("//input[@id='geoRegionSearch']"));
		postCode.clear();
		postCode.sendKeys("EN4"); 
		Thread.sleep(1000);
		postCode.sendKeys(Keys.ARROW_DOWN);
		postCode.sendKeys(Keys.ENTER);
		
		System.out.println("Postcode value is :  "+postCode.getText());
		//Enrollment
		
		
		
		
	}

}

