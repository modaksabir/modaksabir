package com.pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductQualification {
public WebDriver ldriver;
	
	public ProductQualification(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css=".mat-datepicker-input")
	@CacheLookup
	WebElement inputDOB;	
	
	@FindBy(id="input-income")
	@CacheLookup
	WebElement inputNetAnnualIncome;
	
	@FindBy(css="#radio-ubo-0")
	@CacheLookup
	WebElement rdBtnYesUBO;
	
	@FindBy(css="#radio-staff-memeber-1")
	@CacheLookup
	WebElement rdBtnNotStaff;
	
	@FindBy(css=".col-md-9")
	@CacheLookup
	WebElement clkEmptySpace;

	@FindBy(css="button[class='btn btn-primary']")
	@CacheLookup
	WebElement clkNext;
	
	
	@FindBy(id="addIncomeSource-save-btn")
	@CacheLookup
	WebElement btnReqmntMetNext;
	
	public void enterDateOfBirth(String DOB) {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.visibilityOf(inputDOB)));
		inputDOB.clear();
		inputDOB.sendKeys(DOB);
	}
	
	public void enterNetAnnualIncome(String income) {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.visibilityOf(inputNetAnnualIncome)));
		inputNetAnnualIncome.clear();
		inputNetAnnualIncome.sendKeys(income);
	}
	
	public void clkRdBtnYesUBO() {
		rdBtnYesUBO.click();
	}
	
	public void clkRdBtnNotStaff() {
		rdBtnNotStaff.click();
	}
	
	public void clkOnEmptySpace() {
		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", clkEmptySpace);
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.textToBePresentInElementLocated(By.id("select-rim-classification-text"), "High Nett Worth")));
	}
	
	public void clkBtnNext() {
		clkNext.click();
	}
	
	public void clkBtnReqmntMetNxt() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until((ExpectedConditions.elementToBeClickable(btnReqmntMetNext)));
		((JavascriptExecutor)ldriver).executeScript("arguments[0].click();", btnReqmntMetNext);
	}
}
