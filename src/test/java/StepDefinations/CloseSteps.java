package StepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CloseSteps extends BaseClass {
	
	

	@After
	@And ("Close browser")
	public void close_browser() {
		driver.quit();
	}
}
