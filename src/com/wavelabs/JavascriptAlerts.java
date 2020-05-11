package com.wavelabs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavascriptAlerts {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");


		String text = "Srinivas";

		driver.findElement(By.id("name")).sendKeys(text);

		driver.findElement(By.cssSelector("[id='alertbtn']")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().dismiss();
		System.out.println("Driver parentframe ......."+ driver.switchTo().parentFrame().getTitle());
		
		Select sels=new Select(driver.findElement(By.id("dropdown-class-example")));
		sels.selectByIndex(1);
		
		// Radio buttons example
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));

		System.out.println("Checkboxes" + checkbox.size());
		
		for(WebElement ell:checkbox) {
			ell.click();
		}

		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@type='radio']")));

		List<WebElement> radiobutn = driver.findElements(By.xpath("//input[@type='radio']"));
		driver.findElement(By.xpath("//div[@id='radio-btn-example'] //input[@value='radio1']")).click();
		System.out.println("radio boxes" + radiobutn.size());
		
		
	

	}

}
