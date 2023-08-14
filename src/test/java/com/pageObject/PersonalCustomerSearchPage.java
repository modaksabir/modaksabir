package com.pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalCustomerSearchPage {
public WebDriver ldriver;
	
	public PersonalCustomerSearchPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="input-first-name")
	@CacheLookup
	WebElement inputFirstName;
	
	@FindBy(id="input-last-name")
	@CacheLookup
	WebElement inputLastName;
	
	@FindBy(css="button[class='btn btn-danger search-item-btn']")
	@CacheLookup
	WebElement btnSearchCustomer;
	
	
	
	public void enterFirstName(String FName) {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.visibilityOf(inputFirstName)));
		//inputFirstName.click();
		inputFirstName.clear();
		inputFirstName.sendKeys(FName);
	}
	
	public void enterLastName(String LName) {
		//WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		//wait.until((ExpectedConditions.visibilityOf(inputLastName)));
		inputLastName.click();
		inputLastName.clear();
		inputLastName.sendKeys(LName);
	}
	
	public void clkSearchCustomer() {
		//WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		//wait.until((ExpectedConditions.visibilityOf(inputLastName)));
		btnSearchCustomer.click();
	}

}
