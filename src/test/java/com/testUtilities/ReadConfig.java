package com.testUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File src=new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
				pro.load(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Message:" + e.getMessage());
			}
		
	}
	
	public String getStagingBWURL() {
		String url=pro.getProperty("stagingBWURL");
		return url;
	}
	
	public String getChromeDriverPath() {
		String chromeDriverPath=pro.getProperty("chromeDriverPath");
		return chromeDriverPath;
	}
	
	public String setUserName() {
		String setusername=pro.getProperty("userName");
		return setusername;
	}
	
	public String setPassword() {
		String setpassword=pro.getProperty("password");
		return setpassword;
	}

}
