package org.automation;

import org.base.Baseclass2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage extends Baseclass2{
	
	public BookingPage() {
	
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(xpath="//select[@name='fromPort']")
	private WebElement fromStation;
	
	@FindBy (xpath= "//select[@name='toPort']")
	private WebElement toStation;
	
	@FindBy (xpath="//input[@class='btn btn-primary']")
	private WebElement	findButton;	
	
	
	
	public WebElement getFromStation() {
		return fromStation;
	}

	public WebElement getToStation() {
		return toStation;
	}

	public WebElement getFindButton() {
		return findButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
