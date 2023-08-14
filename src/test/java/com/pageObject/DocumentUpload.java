package com.pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocumentUpload {
public WebDriver ldriver;
	
	public DocumentUpload(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="input[type='file']")
	@CacheLookup
	WebElement btnChooseFile;
	
	@FindBy(xpath="//button[text()='Upload']")
	@CacheLookup
	WebElement btnUpload;
	
	public void inputBtnChooseFile(String file_name) {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.visibilityOf(btnChooseFile)));
		btnChooseFile.sendKeys(String.format("C:\\Users\\con_modaks\\eclipse-workspace\\Intelligent Capture Automation\\TestSamples\\%s", file_name));
	}
	
	public void clkBtnUpload() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.visibilityOf(btnUpload)));
		btnUpload.click();		
	}

}
