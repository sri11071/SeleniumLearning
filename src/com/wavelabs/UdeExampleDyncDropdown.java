package com.wavelabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class UdeExampleDyncDropdown {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
WebDriver driver =new ChromeDriver();

WebDriverWait wait = new WebDriverWait(driver,30);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

driver.get("http://spicejet.com"); //URL in the browser

//  //a[@value='MAA']  - Xpath for chennai

//  //a[@value='BLR']

driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

driver.findElement(By.xpath("//a[@value='BLR']")).click();

Thread.sleep(2000);

//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();


wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divpaxinfo")));
WebElement passlist=driver.findElement(By.id("divpaxinfo"));
passlist.click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//Select[contains(@id,'Adult')]")));
Select passAdilt=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
passAdilt.selectByValue("2");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//Select[contains(@id,'Child')]")));
Select passChild=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
passChild.selectByValue("3");
passlist.click();

}



}



