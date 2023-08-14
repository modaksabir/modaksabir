package com.testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;

import com.pageObject.CustomerSearchResults;
import com.pageObject.HomePage;
import com.pageObject.Login;
import com.pageObject.PersonalCustomerSearchPage;
import com.pageObject.ProductAndServicesSelection;
import com.pageObject.ProductQualification;
import com.testUtilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	
	public String stgBWURL=readconfig.getStagingBWURL();
	public String usrNm=readconfig.setUserName();
	public String pswd=readconfig.setPassword();
	
	
	public static WebDriver driver;

	
	@BeforeSuite
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriverPath());
		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();

	}
	
	
	@BeforeClass
	public void preCondition() throws InterruptedException {
		driver.get(stgBWURL);
		Login lgn = new Login(driver);
		lgn.setUserName(usrNm);
		lgn.setPassword(pswd);
		lgn.clkLoginBtn();
		
		HomePage hp=new HomePage(driver);
		hp.clkCustomerMaintenance();
		hp.clkCustomerMaintenancePersonal();
		
		PersonalCustomerSearchPage pcsp=new PersonalCustomerSearchPage(driver);
		pcsp.enterFirstName("James");
		pcsp.enterLastName("Bond");
		pcsp.clkSearchCustomer();
		
		CustomerSearchResults csr=new CustomerSearchResults(driver);
		csr.clkContinueToApplication();
		
		ProductAndServicesSelection pss=new ProductAndServicesSelection(driver);
		pss.clkRdBtnTransact();
		pss.clkBtnNext();
		pss.clkRdBtnTransactionAccount();
		pss.clkBtnConfirm();
		
		ProductQualification pq=new ProductQualification(driver);
		pq.enterDateOfBirth("12/11/1999");
		pq.enterNetAnnualIncome("5000000");
		pq.clkRdBtnYesUBO();
		pq.clkRdBtnNotStaff();
		pq.clkOnEmptySpace();
		pq.clkBtnNext();
		pq.clkBtnReqmntMetNxt();		
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}



}
