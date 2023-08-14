package com.pageObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmCustomerInformationCaptured {
public WebDriver ldriver;
	
	public ConfirmCustomerInformationCaptured(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(css=".loader-text-small")
	@CacheLookup
	WebElement txtReadingDocument;
	
	@FindBy(xpath="//input[@id='input-first-name']//ancestor::app-input")
	@CacheLookup
	WebElement inputFirstName;
	
	@FindBy(xpath="//input[@id='input-last-name']//ancestor::app-input")
	@CacheLookup
	WebElement inputLastName;
	
	@FindBy(id="select-id-type-text")
	@CacheLookup
	WebElement drpDwnIdentityType;
	
	@FindBy(xpath="//input[@id='input-ID-Number']//ancestor::app-input")
	@CacheLookup
	WebElement inputIDNumber;
	
	@FindBy(xpath="//input[@id='input-dob']//ancestor::app-date")
	@CacheLookup
	WebElement inputDOB;
	
	@FindBy(id="select-gender-text")
	@CacheLookup
	WebElement drpDwnGender;
	
	@FindBy(id="select-citizen-text")
	@CacheLookup
	WebElement drpDwnCitizen;
	
	@FindBy(css=".btn.btn-primary")
	@CacheLookup
	WebElement btnConfirm;
	
	@FindBy(xpath="//button[text()='Close']")
	@CacheLookup
	WebElement btnClose;
	
	public String getTextInputFirstName() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.not(ExpectedConditions.textMatches(By.cssSelector(".loader-text-small"),Pattern.compile("Reading Document"))));
		wait.until((ExpectedConditions.visibilityOf(inputFirstName)));
		return inputFirstName.getAttribute("control-value");		
	}
	
	public String getTextinputLastName() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(120));
		wait.until((ExpectedConditions.visibilityOf(inputLastName)));
		return inputLastName.getAttribute("control-value");		
	}
	
	public String getTextDrpDwnIdentityType() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(120));
		wait.until((ExpectedConditions.visibilityOf(drpDwnIdentityType)));
		return drpDwnIdentityType.getText();		
	}
	
	public String getTextInputIDNumber() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(120));
		wait.until((ExpectedConditions.visibilityOf(inputIDNumber)));
		return inputIDNumber.getAttribute("control-value");		
	}
	
	public String getTextInputDOB() throws ParseException {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(120));
		wait.until((ExpectedConditions.visibilityOf(inputDOB)));
		String formatDate=inputDOB.getAttribute("control-value");
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd");
	    Date date = inputFormat.parse(formatDate);
	    String date_string = outputFormat.format(date);
		return date_string;		
	}
	
	public String getTextDrpDwnGender() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(120));
		wait.until((ExpectedConditions.visibilityOf(drpDwnGender)));
		return drpDwnGender.getText();		
	}
	
	public String getTextDrpDwnCitizen() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(120));
		wait.until((ExpectedConditions.visibilityOf(drpDwnCitizen)));
		return drpDwnCitizen.getText();		
	}
	
	public void clkBtnConfirm() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(120));
		wait.until((ExpectedConditions.visibilityOf(btnConfirm)));
		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", btnConfirm);
	}
	
	public void clkBtnClose() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(120));
		wait.until((ExpectedConditions.visibilityOf(btnClose)));
		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", btnClose);		
	}

}
