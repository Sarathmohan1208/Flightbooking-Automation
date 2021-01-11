package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass2 {
	
	public static WebDriver driver;
	
	public static void browser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sarat\\eclipse-workspace\\Project\\src\\Driver\\chromedriver.exe");
		driver= new ChromeDriver();
	}		
	public static void loadUrl (String a) {
		driver.get(a);
		driver.manage().window().maximize();
	}
	public static void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void escape() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	public static void sleep(int sec) throws InterruptedException {
		Thread.sleep(sec);
	}
	public static  void mouseOver(WebElement trgt) {
		Actions a = new Actions(driver);
		a.moveToElement(trgt);
	}
	public static  void doubleClick(WebElement trgt) {
		Actions a = new Actions(driver);
		a.doubleClick(trgt);
	}
	public static  void rightClick(WebElement trgt) {
		Actions a = new Actions(driver);
		a.contextClick(trgt);
	}
	public static void sendkey(WebElement a , String s) {
		a.sendKeys(s);
	}
	public static  void click(WebElement c) {
		c.click();
	}
	public static void select(WebElement s,int q) {
		Select a = new Select(s);
		a.selectByIndex(q);
	}
	
	public static void impWait() {
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public static String data(String sheetname,int row,int cell) throws IOException {
//		File f = new File("C:\\Users\\sarat\\eclipse-workspace\\Project\\Data\\SignUp Data.xlsx");
//		FileInputStream in = new FileInputStream(f);
//		Workbook w = new XSSFWorkbook(in);
//		Sheet s = w.getSheet(sheetname);
//		Row r = s.getRow(row);
//		Cell c = r.getCell(cell);
//		String value = c.getStringCellValue();
//		return value;
		
		String value = null;
		
		File dataloc = new File ("C:\\Users\\sarat\\eclipse-workspace\\Project\\Data\\SignUp Data.xlsx"); 
		FileInputStream in = new FileInputStream(dataloc);
		Workbook w = new XSSFWorkbook(in);
		Sheet s = 	w.getSheet(sheetname);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int type = c.getCellType();
		
		if(type==1)
		{
			value = c.getStringCellValue(); 
		}
		
		else if(type==0)
		{
			if(DateUtil.isCellDateFormatted(c))
			{
				 java.util.Date d = c.getDateCellValue();
				 SimpleDateFormat date= new SimpleDateFormat("dd/MM/YY");
				 value = date.format(d);	 
			}
			else {
				double num = c.getNumericCellValue();
				long l = (long)num;
				value = String.valueOf(l);
			}
				
		}
		return value;
	
		
	}
	
	
	
}
