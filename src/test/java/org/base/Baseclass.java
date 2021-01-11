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

public class Baseclass {
	
//	static String captcha;
	
	public static WebDriver driver;
	
	public static void browser() {
	
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\sarat\\eclipse-workspace\\Baseclass\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();	

	}
	public static void loadurl(String url) {
		driver.get(url);

	}
	public static  void maxWindow() {
		driver.manage().window().maximize();
	}
	public static String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	} 
	public static String getTitle() {
		String currentTitle = driver.getTitle();
		return currentTitle;
	}
	public static void userKey(WebElement a,String value ) {
		
		a.sendKeys(value);

	}
	
	public static void click(WebElement b) {
		
		b.click();

	}
	
	public static void screenshot(String name) throws IOException {
		
		TakesScreenshot t = (TakesScreenshot) driver;
		File screenshotAs = t.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\sarat\\eclipse-workspace\\Baseclass\\Screenshot\\"+name+".png");
		FileUtils.copyFile(screenshotAs, f);
		
	}
	public static void close() {  
		
		driver.close();

	}
	
	public static void scroll(String j,WebElement dest) {
		JavascriptExecutor v = (JavascriptExecutor) driver;
		v.executeScript(j,dest);

	}
	public static void mouseover(WebElement dest) {
		Actions a = new Actions (driver);
		a.moveToElement(dest).perform();
	}
	public static void userPass(WebElement pass,String p) {
	
		pass.sendKeys(p);
		
	} 
	public static void escape() throws AWTException {
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);

	}
	public static void enter() throws AWTException {
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void rightClick(WebElement target) {
		Actions a = new Actions (driver);
		a.contextClick(target).perform();
	}
	
	public static void selectIndex(WebElement sel, int i) {
		
		Select s = new Select(sel);
		s.selectByIndex(i);

	}

	public static void selectValue(WebElement value,String s) {
		
		Select q = new Select(value);
		q.selectByValue(s);

	}

	public static void selectVisible(WebElement text,String w) {
		
		Select e = new Select(text);
		e.selectByValue(w);

	}
	public static void deselectIndex(WebElement sel, int i) {
		
		Select s = new Select(sel);
		s.deselectByIndex(i);

	}

	public static void deselectValue(WebElement value,String s) {
		
		Select q = new Select(value);
		q.deselectByValue(s);

	}

	public static void deselectVisible(WebElement text,String w) {
		
		Select e = new Select(text);
		e.deselectByValue(w);

	}
	
	public static void switchFrame(WebElement a) {
		
		driver.switchTo().frame(a);
	}
	
	public static void switchFramebystring(String s) {
		
		driver.switchTo().frame(s);
	}
	
	public static void switchframebyindex(int i) {
		
		driver.switchTo().frame(i);
	}
	
	public static void alertOk() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
	public static void alertNotok() {
		Alert b = driver.switchTo().alert();
		b.dismiss();
	}
	
	public static void windowHandle() {
		String s = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			
			if(!s.equals(string)) {
				
				driver.switchTo().window(string);
			}
		}
	}
	public static void implicitwait() {
		
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
	}
	public static void explicitwait(WebElement w) {

		WebDriverWait wait = new WebDriverWait(driver, 200);
		
	}
	
	public static String readData(int cell,int row) throws IOException {
		
		String value = null;
		
		File dataloc = new File ("C:\\Users\\sarat\\eclipse-workspace\\MavenProject\\target\\Excel Docs\\Data.xlsx"); 
		FileInputStream in = new FileInputStream(dataloc);
		Workbook w = new XSSFWorkbook(in);
		Sheet s = 	w.getSheet("source");
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
	
	public static String scan() {

		Scanner s= new Scanner(System.in);
		System.out.println("Enter the Captcha:");
		String captcha = s.next();	
		return captcha;
	}
	
	public static String writeData(int cell,int row,String v) throws IOException {
	
			
		File dataloc = new File ("C:\\Users\\sarat\\eclipse-workspace\\MavenProject\\target\\Excel Docs\\write.xlsx"); 
		FileOutputStream out = new FileOutputStream(dataloc);
		Workbook w = new XSSFWorkbook();
		Sheet s = 	w.createSheet("Write");
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(v);
		w.write(out);
		return v;
		
	}
	
	public static String editExcel(int cell,int row,String Checkvalue,String Setvalue) throws IOException {
		
		String value = null;
		
		File dataloc = new File ("C:\\Users\\sarat\\eclipse-workspace\\MavenProject\\target\\Excel Docs\\Data.xlsx"); 
		FileInputStream in = new FileInputStream(dataloc);
		Workbook w = new XSSFWorkbook(in);
		Sheet s = 	w.getSheet("source");
		
		for(int i = 0;i<s.getPhysicalNumberOfRows();i++)
		{
			Row r = s.getRow(i);
			
			for(int j=0;j<r.getPhysicalNumberOfCells();j++)
			{
				Cell c = r.getCell(j);
				int type = c.getCellType();
				if(type==1)
				{
					value = c.getStringCellValue(); 
					if(value.equalsIgnoreCase(Checkvalue)) {
						FileOutputStream out =new FileOutputStream(dataloc);
						c.setCellValue(Setvalue);
						w.write(out);
					}
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
				
			}

				
		}
		return value;
			
				
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
}
