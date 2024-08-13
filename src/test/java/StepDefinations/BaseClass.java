package StepDefinations;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import PageObjects.LogInPage;
import PageObjects.PurchaseProd;
import Utilites.ReadConfig;
import io.cucumber.java.Before;

public class BaseClass {

	public static WebDriver driver;
	public LogInPage logPage;
	public PurchaseProd puchesProd;
	public WebDriverWait wait;
	public static Logger log = LogManager.getLogger(BaseClass.class);
	// we have create object of readConfig class to read the value of
	// config.prperies file and this class will be extend by other class to get the
	// value of config.prperies file
	public ReadConfig readConfig;

	@BeforeClass
	public void setUP() {
		log = LogManager.getLogger("StepDef");
		readConfig = new ReadConfig();
		String browser = readConfig.getApplicationURL();
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "msedge":
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			break;
		}
		log.info("Set up executed");

	}

	/*
	 * public void setUp(String br) {
	 * 
	 * log = Logger.getLogger("ebanking");
	 * PropertyConfigurator.configure("Log4j.properties"); }
	 */
}
