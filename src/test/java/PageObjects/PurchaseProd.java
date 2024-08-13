package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseProd {
	WebDriver driver;

	public PurchaseProd(WebDriver driver) {
		driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
	}

	@FindBy(className = "inventory_item_name")
	private List<WebElement> productNames;

	@FindBy(className = "inventory_details_name")
	private WebElement productName;

	@FindBy(id = "add-to-cart")
	private WebElement addCartProdButton;

	@FindBy(id = "back-to-products")
	private WebElement backToProduct;

	@FindBy(xpath = "//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")
	private WebElement CartIcone;

	@FindBy(id = "checkout")
	private WebElement checkoutButton;

	@FindBy(xpath = "//span[@data-test='title']")
	private WebElement checkOutPageT;

	@FindBy(id = "first-name")
	private WebElement first_name;

	@FindBy(id = "last-name")
	private WebElement last_name;

	@FindBy(id = "postal-code")
	private WebElement pin_Code;

	@FindBy(id = "continue")
	private WebElement conti_button;

	@FindBy(xpath = "//span[@data-test='title']")
	private WebElement Verify_overview;

	@FindBy(id = "finish")
	private WebElement finsh_button;
	
	@FindBy(xpath = "//h2[@data-test='complete-header']")
	private WebElement ThankYou_page;
	
	@FindBy(id = "back-to-products")
	private WebElement Back_HomePage;

	public void clickOnProduct(String productName) {
		for (WebElement product : productNames) {
			if (product.getText().equalsIgnoreCase(productName)) {
				product.click();
				break;
			}
		}

	}

	public String getProdName() {
		return productName.getText();
	}

	public void addProdCartBut() {
		addCartProdButton.click();
	}

	public void backToProductBut() {
		backToProduct.click();
	}

	public void CartIconeButton() {
		CartIcone.click();
	}

	public void checkOutButton() {
		checkoutButton.click();
	}

	public String CheckOutPageTitle() {
		return checkOutPageT.getText();
	}

	public void CustDetail(String firstName, String Lastname, String postalCode) {
		first_name.sendKeys(firstName);
		last_name.sendKeys(Lastname);
		pin_Code.sendKeys(postalCode);
	}

	public void clickOnContinue() {
		conti_button.click();
	}

	public String verifyOverviewPage() {

		return Verify_overview.getText();
	}
	
	public void finshButton() {
		finsh_button.click();
	}
	
	public String thankYouPage() {
		return ThankYou_page.getText();
	}
	public void backToHomePage() {
		Back_HomePage.click();
	}

}
