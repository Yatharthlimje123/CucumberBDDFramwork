package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	WebDriver driver;
	public LogInPage(WebDriver driver) {
		driver=driver;
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
	}
	
	@FindBy (xpath  = "//input[@placeholder='Username']")
	WebElement User_name;
	
	@FindBy (xpath = "//input[@placeholder='Password']")
	WebElement Pass_word;
	
	@FindBy (id = "login-button")
	WebElement LogIn_button;
	
	@FindBy(id = "react-burger-menu-btn")
	WebElement User_profile;
	
	@FindBy (id  = "logout_sidebar_link")
	WebElement Logout_button;
	
	public void enter_username(String EmailAdd) {
		User_name.clear();
		User_name.sendKeys(EmailAdd);
	}
	
	public void enter_password(String password) {
		Pass_word.clear();
		Pass_word.sendKeys(password);
	}
	
	public void click_login() {
		LogIn_button.click();
	}
	
	public void click_UserProfile() {
		User_profile.click();
	}
	
	public void click_logOut() {
		Logout_button.click();
	}
	
}
