package org.project;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.apache.poi.util.SystemOutLogger;
import org.base.Baseclass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task1 extends Baseclass{
	
@Test
public void flipkart() throws AWTException, InterruptedException {

	browser();
	loadurl("https://www.flipkart.com/");
	maxWindow();	
	escape();
	userKey(driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")),"samsung mobile");
	enter();
	Thread.sleep(5000);
	List<WebElement> products = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	System.out.println("Total number of productes in page: "+products.size());
	System.out.println("==========================================");
	Set<String> p = new HashSet();
	for (int i = 0; i < products.size(); i++) {
		
		String productList = products.get(i).getText();
		p.add(productList);
		System.out.println(productList);
		
	}
	
	System.out.println("\n"+"Product List Without Duplicates:"+p.size());
	System.out.println("==================================="+"\n");
	for (String x : p) {
		System.out.println(x);
	}
	List<WebElement> prodPrice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	System.out.println("\n"+"Product Price which are greater than 5000rs are listed below:");
	System.out.println("===================================================================="+"\n");
	for(int j=0;j<prodPrice.size();j++)
	{
		String a = prodPrice.get(j).getText();
		String price = a.substring(1);
		String priceFinal = price.replaceAll(",","");
		int s = Integer.parseInt(priceFinal);
		if(s>5000)
		{
			System.out.println(s);
		}
	}	   
		
}
	

}
