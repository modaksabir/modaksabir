package com.testCases;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObject.ConfirmCustomerInformationCaptured;
import com.pageObject.DocumentUpload;
import com.testUtilities.XLUtils;

public class TestCase extends BaseClass {
	
	@Test(dataProvider = "TestData")
	public void intelligentCapture(String fileName, String firstName, String lastName, String IdType, String IdNumber, String DOB, String Gender, String Citizen ) throws InterruptedException, ParseException {
		DocumentUpload du=new DocumentUpload(driver);
		du.inputBtnChooseFile(fileName);
		Thread.sleep(5000);
		du.clkBtnUpload();
		
		ConfirmCustomerInformationCaptured ccic=new ConfirmCustomerInformationCaptured(driver);
		String fname=ccic.getTextInputFirstName();
		Assert.assertEquals(fname, firstName);
		
		String lname=ccic.getTextinputLastName();
		Assert.assertEquals(lname, lastName);
		
		String idType=ccic.getTextDrpDwnIdentityType();
		Assert.assertEquals(idType, IdType);
		
		String idNumber=ccic.getTextInputIDNumber();
		Assert.assertEquals(idNumber, IdNumber);
		
		String dob=ccic.getTextInputDOB();
		Assert.assertEquals(dob, DOB);
		
		String gender=ccic.getTextDrpDwnGender();
		Assert.assertEquals(gender, Gender);
		
		String citizen=ccic.getTextDrpDwnCitizen();
		Assert.assertEquals(citizen, Citizen);
		
		System.out.println("data retrieved");
		ccic.clkBtnClose();
			
	}
	
	@DataProvider(name = "TestData")
	public String[][] getData() throws IOException {
		// This code is used to retrieve data from a excel file
		String path = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String testdata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				testdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return testdata;
	}

}
