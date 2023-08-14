package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public WebDriver ldriver;
	
	public Login(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="input-username")
	@CacheLookup
	WebElement userName;
	
	@FindBy(id="input-password")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="login-btn")
	@CacheLookup
	WebElement loginBtn;
	
	public void setUserName(String UserName) {
		userName.click();
		userName.clear();
		userName.sendKeys(UserName);
	}
	
	public void setPassword(String Password) {
		password.click();
		password.clear();
		password.sendKeys(Password);
	}
	
	public void clkLoginBtn() {
		loginBtn.click();
	}
}
