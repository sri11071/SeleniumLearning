package com.wavelabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeDriverDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
	//Chrome Driver
	
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://stg3:RfxdLT6i@intl-stg3.care.com/en-gb/");
		System.out.println("title is "+driver.getTitle());
		
	
		System.out.println("Current url  :"+driver.getCurrentUrl());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/en-gb/login']")));
		WebElement Loginlink=driver.findElement(By.xpath("//a[@href='/en-gb/login']"));
		Loginlink.click();
		
		WebElement csremail=driver.findElement(By.xpath("//input[@id='j_username']"));
		csremail.sendKeys("csradmin1@care.com");
		WebElement csrPassword=driver.findElement(By.xpath("//input[@id='j_password']"));
		csrPassword.sendKeys("letmein1");
		WebElement but_Login=driver.findElement(By.xpath("//button[@type='submit']"));
		but_Login.click();
				
		//System.out.println(driver.getPageSource());
		
		WebElement mem_ser_link= driver.findElement(By.partialLinkText("Member Search"));
		mem_ser_link.click();
		
		int memberid;
		driver.findElement(By.cssSelector("#globalId")).sendKeys("1234");
		WebElement firstname=driver.findElement(By.xpath("//input[@name='globalId']/parent::td/parent::tr/following-sibling::tr[2]/td[2]/input"));
		firstname.sendKeys("L");
		firstname.clear();
		driver.findElement(By.xpath("//input[contains(@id,'sear')]")).click();
		
		
		//driver.close();
		
	}

}
