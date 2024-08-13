package StepDefinations;

import org.openqa.selenium.By; // Ensure this import is present
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
//import java.util.logging.LogManager;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;

import PageObjects.LogInPage;
import PageObjects.PurchaseProd;
import Utilites.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDef extends BaseClass {

	@Before
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
				driver=null;
			break;
		}
		log.info("Set up executed");

	}

	/*@Before(order = 2)
	public void orderToMethod() {
		System.out.println("order is 2 this method will run after order 1");
	}

	@Before(order = 1)
	public void orderToMethod1() {
		System.out.println("order is 1 this method will run before order 2");
	}*/

	@When("User launch Crome Browser")
	public void user_launch_crome_browser() {

		logPage = new LogInPage(driver);
		puchesProd = new PurchaseProd(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait
		log.info("Browser Launch");
	}

	@Given("User Open Url {string}")
	public void user_open_url(String url) {
		driver.get(url);
		log.info("User Open Url");
	}

	@And("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String emailadress, String passWord) {
		logPage.enter_username(emailadress);
		logPage.enter_password(passWord);
		log.info("User enter email as {string} and password as {string}");
	}

	@And("Click on login button")
	public void click_on_login_button() {
		logPage.click_login();
		log.info("Click on login button");
	}

	@Then("Page of home page title Should be {string}")
	public void page_of_home_page_title_should_be(String HomePageTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.equals(HomePageTitle));

	}

	@When("User Click on Log out button")
	public void user_click_on_log_out_button() {
		logPage.click_UserProfile();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
		logPage.click_logOut();
	}

	// -------------------------------------------------------------------------------------------------------//

	@Then("customer should click on product")
	public void customer_should_click_on_product() {
		puchesProd.clickOnProduct("Sauce Labs Backpack");
	}

	@Then("user can see the productPage detail")
	public void user_can_see_the_product_page_detail() {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='inventory-item-name']")));
		String actualtitle = puchesProd.getProdName();
		Assert.assertEquals("Sauce Labs Backpack", actualtitle);
	}

	@Then("click on addToCard button")
	public void click_on_add_to_card_button() {
		puchesProd.addProdCartBut();
	}

	@Then("Click on back to product List page")
	public void click_on_back_to_product_list_page() {
		puchesProd.backToProductBut();
	}

	@When("user can see product list page {string}")
	public void user_can_see_product_list_page(String HomePageTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.equals(HomePageTitle));
	}

	@When("Click on Crat Icone")
	public void click_on_crat_icone() {
		puchesProd.CartIconeButton();
	}

	@Then("Click on Checkout button")
	public void click_on_checkout_button() {
		puchesProd.checkOutButton();
	}

	@Then("user can see the checkout information page")
	public void user_can_see_the_checkout_information_page() {
		String actualTitle = puchesProd.CheckOutPageTitle();
		Assert.assertEquals("Checkout: Your Information", actualTitle);
	}

	@Then("user entert the name {string} and last name {string} and Pincode {string}")
	public void user_entert_the_name_and_last_name_and_pincode(String FirstName, String LastName, String PineCode) {
		puchesProd.CustDetail(FirstName, FirstName, PineCode);
	}

	@Then("click on continue button")
	public void click_on_continue_button() {
		puchesProd.clickOnContinue();
	}

	@Then("user can view Checkout Overview page")
	public void user_can_view_checkout_overview_page() {
		String actualTitle = puchesProd.verifyOverviewPage();
		Assert.assertEquals("Checkout: Overview", actualTitle);
	}

	@Then("Click on finish button")
	public void click_on_finish_button() {
		puchesProd.finshButton();
	}

	@Then("user can see the thank you page")
	public void user_can_see_the_thank_you_page() {
		String actualTitle = puchesProd.thankYouPage();
		Assert.assertEquals("Thank you for your order!", actualTitle);
	}

	@Then("click on Back t home page button")
	public void click_on_back_t_home_page_button() {
		puchesProd.backToHomePage();

	}

	@Then("click on logout button")
	public void click_on_logout_button() {
		logPage.click_UserProfile();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
		logPage.click_logOut();
	}

	@After
	public void tearDown(Scenario sc) throws IOException {

		System.out.println("After Annaotation Run sucss");

		if (sc.isFailed() == true) {
			String fileWithPath = "C:\\Users\\Admin\\eclipse-workspace\\BDDFramwork.project\\Screenshot\\test1.png";
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

			File destFile = new File(fileWithPath);

			FileUtils.copyFile(srcFile, destFile);
		}
		if (driver != null) {
	        driver.quit();
	    }
	}
	
	@AfterStep
	public void addScreenShot(Scenario sc) {
		 if (driver != null && sc.isFailed()) {
			final byte [] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			sc.attach(screenshot, "image/png", sc.getName());
		}
	}

	/*@BeforeStep
	public void beforeStep() {
		System.out.println("Before step annotation will run before every step");

	}

	@AfterStep
	public void afterStep() {
		System.out.println("After step anno run after every srep");
	}*/

}
