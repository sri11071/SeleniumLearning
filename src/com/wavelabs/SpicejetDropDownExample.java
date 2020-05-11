package com.wavelabs;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SpicejetDropDownExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
		driver.get("https://www.spicejet.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//Select[contains(@id,'Currency')]")));
		Select s=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByValue("USD");
		Thread.sleep(200);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divpaxinfo")));
		WebElement passlist=driver.findElement(By.id("divpaxinfo"));
		passlist.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//Select[contains(@id,'Adult')]")));
		Select passAdilt=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		passAdilt.selectByValue("3");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//Select[contains(@id,'Child')]")));
		Select passChild=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		passChild.selectByValue("4");
		passlist.click();
		
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
		

		//Journy date 
		
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
	 
		
	 if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
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
		//checkbox example
		
		List<WebElement> checkboxList=driver.findElements(By.xpath("//input[@type='checkbox']"));
		int zi=checkboxList.size();
		System.out.println("Checkboxes present in this page :"+zi);
		Assert.assertEquals(zi, 6);
		
		WebElement checkbox=driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
		Assert.assertFalse(checkbox.isSelected());
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected());
		
		/*Iterator<WebElement> itr = checkboxList.iterator(); 
		 while (itr.hasNext() ){ 
		   if(!itr.next().isSelected()) {
		   itr.next().click();
		   }
		   Thread.sleep(2000);
		   itr.next().click();
		 }
	for (int i=0;i<=zi;i++) {
		    checkboxList.get(i).click();
			System.out.println("Elemnt identifie.......: "+checkboxList.get(i).getText());
			
		}*/
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_btn_FindFlights")));
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		System.out.println("Result verification  :"+driver.findElement(By.xpath("//div[@class='s-results-left']")).getText());
		
	}

}
