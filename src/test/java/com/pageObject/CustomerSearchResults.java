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

public class CustomerSearchResults {
public WebDriver ldriver;
	
	public CustomerSearchResults(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="button[class='btn btn-danger create-item-btn']")
	@CacheLookup
	WebElement btnContinueToApplication;
	
	public void clkContinueToApplication() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.textMatches(By.cssSelector(".todo-counter"), Pattern.compile("Result")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='gui-content']")));
		wait.until((ExpectedConditions.elementToBeClickable(btnContinueToApplication)));
		Thread.sleep(2000);
		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", btnContinueToApplication);
	}

}
