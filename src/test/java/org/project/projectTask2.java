package org.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import org.base.Baseclass2;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class projectTask2 extends Baseclass2 {

	@Test
	public void blaze() throws InterruptedException, IOException, AWTException {

	//wait na enna nu check pandra
		browser();
		loadUrl("https://www.demoblaze.com/index.html");
		impWait();
		HomePojo h = new HomePojo();
		click(h.getSignUp());
		sendkey(h.getUserName(), data("data", 0,0 ));
		sendkey(h.getPassword(), data("data", 1, 0));
		click(h.getSignupBtn());
		sleep(3000);
//		Alert x = driver.switchTo().alert();			
//		x.accept();
		enter();
		click(h.getPhone());
		click(h.getAdd());
		click(h.getCart());
		click(h.getCartValue());
//		click(driver.findElement(By.xpath("//a[text()='Sign up']")));
//		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
//		driver.findElement(By.id("sign-username")).sendKeys(data("data", 0, 0));
//		driver.findElement(By.id("sign-password")).sendKeys(data("data", 1, 0));
//		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
//		sleep(3000);
//		Alert x = driver.switchTo().alert();			
//		x.accept();
//		driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
//		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
//		enter();
//		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		
//		WebElement cartvalue = driver.findElement(By.id("totalp"));
//		String print = cartvalue.getText();
//		System.out.println(print);
		
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()=\"Place Order\"]")))).click();;
		click(h.getOrderButton());
		driver.findElement(By.id("name")).sendKeys(data("data", 0, 1));
		driver.findElement(By.id("country")).sendKeys(data("data", 1, 1));
		driver.findElement(By.id("city")).sendKeys(data("data", 2, 1));
		driver.findElement(By.id("card")).sendKeys(data("data", 3, 1));
		driver.findElement(By.id("month")).sendKeys(data("data", 4, 1));
		driver.findElement(By.id("year")).sendKeys(data("data", 5, 1));
		driver.findElement(By.xpath("//button[text()=\"Purchase\"]")).click();
	}

}
