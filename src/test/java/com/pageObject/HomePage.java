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


public class HomePage {
public WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="body > app-root:nth-child(1) > app-home:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > app-home-btn:nth-child(2) > div:nth-child(1)")
	@CacheLookup
	WebElement customerMaintenance;
	
	@FindBy(css="body > app-root:nth-child(1) > app-home:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > app-home-btn:nth-child(3) > div:nth-child(1)")
	@CacheLookup
	WebElement newBusinessApplication;
	
	@FindBy(css="body > ngb-modal-window:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > app-customer-maintenance-type-select:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > p:nth-child(2)")
	@CacheLookup
	WebElement customerMaintenancePersonal;
	
	
	public void clkCustomerMaintenance() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.visibilityOf(customerMaintenance)));
		wait.until((ExpectedConditions.elementToBeClickable(customerMaintenance)));
		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", customerMaintenance);
	}
	
	public void clknewBusinessApplication() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.visibilityOf(newBusinessApplication)));
		newBusinessApplication.click();
	}
	
	public void clkCustomerMaintenancePersonal() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.visibilityOf(customerMaintenancePersonal)));
		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", customerMaintenancePersonal);
		//customerMaintenancePersonal.click();
		//System.out.println("After personal");
	}
	
	

}
