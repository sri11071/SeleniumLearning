package com.wavelabs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeliniumPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.spicejet.com/");
		
		System.out.println("Before selecting city");
		
		WebElement originCity=driver.findElement(By.xpath("//input[contains(@id,'origin')]"));
		originCity.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@value,'HYD')]")));
		driver.findElement(By.xpath("//a[contains(@value,'HYD')]")).click();
		System.out.println("Origin city Selected");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'destina')]")));
		WebElement destCity=driver.findElement(By.xpath("//input[contains(@id,'destina')]"));
		destCity.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@value,'BLR')])[2]")));
	    List<WebElement> descity=driver.findElements(By.xpath("//a[contains(@value,'BLR')]"));
		System.out.println("Size ......:.    "+descity.size());
		int el_size=descity.size();
	    //driver.findElement(By.xpath("(//a[contains(@value,'BLR')])[2]")).click();
		WebElement destinationSelected= driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[contains(@value,'BLR')]"));
		destinationSelected.click();

		System.out.println("Destination city selected   :"+destinationSelected.getText());
		
		
		List<WebElement> allDates=driver.findElements(By.xpath("//div[contains(@class,'ui-datepicker-group')]//table//tbody/tr/td"));
		System.out.println("Total elments for month   +"+allDates.size());
		
		for(WebElement ele:allDates)
		{
			System.out.println("In Loop ......"+ele.getText());
			String date=ele.getText();
			if(date.equalsIgnoreCase("28"))
			{
				ele.click();
				break;
			}
			
		}
		
		System.out.println("Before click .........."+driver.findElement(By.id("Div1")).getAttribute("style"));
		 //driver.findElement(By.id("Div1")).getAttribute("style").contains("opacity")
		
	 WebElement returndate= driver.findElement(By.id("ctl00_mainContent_view_date2"));
	 System.out.println("Return date is enabled .....:"+returndate.isEnabled());
	 driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	 System.out.println("Round trip selected and  date is enabled .....:"+returndate.isEnabled());
	 
	 System.out.println("After click .........."+driver.findElement(By.id("Div1")).getAttribute("style"));
		
		
	 driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).click();
	 List<WebElement> allDates2=driver.findElements(By.xpath("//div[contains(@class,'ui-datepicker-group ui-datepicker-group-first')]//table//tbody/tr/td"));
		System.out.println("Total elments for month   +"+allDates2.size());
		
	 for(WebElement ele2:allDates2)
		{
			System.out.println("In Loop ......"+ele2.getText());
			String date=ele2.getText();
			if(date.equalsIgnoreCase("29"))
			{
				ele2.click();
				break;
			}
			
		}
		

	}

}
