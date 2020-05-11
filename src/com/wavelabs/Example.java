package com.wavelabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example {
	static WebDriver driver;
	static WebDriverWait wait ;
	
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		wait= new WebDriverWait(driver,30);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
	  driver.findElement(By.xpath("//div[contains(@class,'RNN')]/div/div[2]/input")).sendKeys("search");
	  
	driver.close();
	 practice();
	}

	
	public static void practice() {
		
		driver=new ChromeDriver();
		
		driver.get("http://www.qaclickacademy.com/interview.php");
		WebElement sele_link=driver.findElement(By.xpath("//div[contains(@class,'interview')]/div/div/ul/li[2]"));
		sele_link.click();
		System.out.println(sele_link.getText());

}
}
