package Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	//This declares a Properties object named pro which will be used to store and manage the properties read from the config.properties file
	Properties pro;// it is class name prperties
	//constructor
	public ReadConfig() {
		File src=new File("config.properties");// path of properties file 
		
		try {
			// initialise the properties class
			pro=new Properties();
			//load the properties class
			FileInputStream fis=new FileInputStream(src);
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("exception is"+  e.getMessage());
		}
	}
	
	//this the method to read the value of property file 
	public String getApplicationURL() {
		//to read the value from property file we use .getProperty method
		String url=pro.getProperty("browser");
		return url;
	}



}
