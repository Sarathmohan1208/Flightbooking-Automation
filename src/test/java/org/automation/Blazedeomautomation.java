package org.automation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.base.Baseclass2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.FinalizablePhantomReference;

public class Blazedeomautomation extends Baseclass2{
	
	@Parameters({"firstname","address","city","state","zipcode","cardnumber","month","year","cardname"})
	@Test
	public void finalbooking(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9) throws InterruptedException {
	
	BookingPage b = new BookingPage();
	browser();
	loadUrl("https://blazedemo.com/index.php");
	impWait();
	driver.findElement(By.xpath("//select[@name='fromPort']")).click();
	select(driver.findElement(By.xpath("//select[@name='fromPort']")), 3);
	driver.findElement(By.xpath("//select[@name='toPort']")).click();
	select(driver.findElement(By.xpath("//select[@name='toPort']")), 5);
	driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	
	WebElement table = driver.findElement(By.xpath("//table[@class='table']"));
	List<WebElement> tRows = table.findElements(By.tagName("tr"));
	
	List<Double> li = new ArrayList<Double>();
	List<Double> lis = new ArrayList<Double>();
	
	for(int i=1;i<tRows.size();i++)
	{
		WebElement row = tRows.get(i);
		List<WebElement> tData = row.findElements(By.tagName("td")); 
	
		WebElement price = tData.get(tData.size()-1);
		String out = price.getText().substring(1);
		double finalPrice = Double.parseDouble(out);
		li.add(finalPrice);
		
	}
		lis.addAll(li);
		Collections.sort(lis);
		Double lowPrice = lis.get(0);
		int indexOf = li.indexOf(lowPrice);
		WebElement lowPriceRow = tRows.get(indexOf);
		sleep(3000);
		lowPriceRow.findElement(By.xpath("(//input[@class='btn btn-small'])["+(indexOf+1)+"]")).click();
		
		driver.findElement(By.id("inputName")).sendKeys(s1);
		driver.findElement(By.id("address")).sendKeys(s2);
		driver.findElement(By.id("city")).sendKeys(s3);
		driver.findElement(By.id("state")).sendKeys(s4);
		driver.findElement(By.id("zipCode")).sendKeys(s5);
		WebElement cardType = driver.findElement(By.id("cardType"));
		click(cardType);
		select(cardType, 1);
		driver.findElement(By.id("creditCardNumber")).sendKeys(s6);
		driver.findElement(By.id("creditCardMonth")).sendKeys(s7);
		driver.findElement(By.id("creditCardYear")).sendKeys(s8);
		driver.findElement(By.id("nameOnCard")).sendKeys(s9);
		click(driver.findElement(By.id("rememberMe")));
		click(driver.findElement(By.xpath("//input[@class='btn btn-primary']")));
		System.out.println("Booking");
		System.out.println("Booking done successfully");
		System.out.println("Booking");
		System.out.println("Booking");
		System.out.println("Booking");
		System.out.println("Booking");
		System.out.println("Booking");
		System.out.println("Booking");
		
	
	}
	
	
}
 