package com.pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductAndServicesSelection {
public WebDriver ldriver;
	
	public ProductAndServicesSelection(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="input[value='Transact']")
	@CacheLookup
	WebElement rdBtnTransact;
	
	@FindBy(css="button[class='btn btn-primary']")
	@CacheLookup
	WebElement btnNext;
	
	@FindBy(xpath="//p[text()=' Transaction Account']//preceding::input[1]")
	@CacheLookup
	WebElement rdBtnTransactionAccount;
	
	@FindBy(css="button[class='btn btn-primary']")
	@CacheLookup
	WebElement btnConfirm;

	
	
	
	public void clkRdBtnTransact() {
		
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.elementToBeClickable(rdBtnTransact)));
		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", rdBtnTransact);
	}
	
	public void clkBtnNext() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.elementToBeClickable(btnNext)));
		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", btnNext);
	}
	
	public void clkRdBtnTransactionAccount() {
		
		int attempts = 0;
	    while(attempts < 2) {
	        try {
	        	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
	    		
	    		wait.until((ExpectedConditions.elementToBeClickable(rdBtnTransactionAccount)));
	    		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", rdBtnTransactionAccount);
	    		//rdBtnTransactionAccount.click();
	        	
	            //driver.findElement(by).click();
	            //result = true;
	            break;
	        } catch(org.openqa.selenium.StaleElementReferenceException ex) {
	        	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
	    		
	    		wait.until((ExpectedConditions.elementToBeClickable(rdBtnTransactionAccount)));
	    		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", rdBtnTransactionAccount);
	    		//rdBtnTransactionAccount.click();
	        }
	        attempts++;
	    }
	}
	
	public void clkBtnConfirm() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.elementToBeClickable(btnConfirm)));
		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", btnConfirm);
	}
	
	
	

}
