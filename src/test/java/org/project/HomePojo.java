package org.project;

import org.base.Baseclass2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePojo extends Baseclass2{
	
	public HomePojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="signin2")
	private WebElement signUp;
	
	@FindBy(id="sign-username")
	private WebElement userName;
	
	@FindBy(id ="sign-password")
	private WebElement password;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[2]")
	private WebElement signupBtn;
	
	@FindBy(xpath="//a[text()='Samsung galaxy s6']")
	private WebElement phone;
	
	@FindBy(xpath = "//a[text()='Add to cart']")
	private WebElement add;
	
	@FindBy(xpath="//a[text()='Cart']")
	private WebElement cart;
	
	@FindBy(id="totalp")
	private WebElement cartValue;
	
	@FindBy(xpath="//button[text()='Place Order']")
	private WebElement orderButton;
	


	public WebElement getOrderButton() {
		return orderButton;
	}

	public WebElement getSignUp() {
		return signUp;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignupBtn() {
		return signupBtn;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getAdd() {
		return add;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getCartValue() {
		return cartValue;
	}
	
	

}
