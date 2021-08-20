package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.CartPO;
import PageObjects.ProductsMethodsPO;
import io.cucumber.java.en.*;

public class ProductsSteps {

	WebDriver driver = null;
	ProductsMethodsPO productsMethodsPO;
	CartPO cartPO;

	@SuppressWarnings("deprecation")
	@Given("I log in to Swag Lab")
	public void i_log_in_to_swag_lab() {
		System.out.println("Inside Step - user is on login page");
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path is: " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com");

	}

	@And("user enters like standard_user")
	public void user_enters_like_and_password() throws InterruptedException {
		System.out.println("Inside Step - user enters username and password");
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		productsMethodsPO = new ProductsMethodsPO(driver);
		productsMethodsPO.titleProductPage();

	}

	@When("I select the filter")
	public void i_select_the_filter() {
		System.out.println("Inside Step - user selects the filter");
		productsMethodsPO = new ProductsMethodsPO(driver);
		productsMethodsPO.selectDropdownFilter();
	}

	@And("I choose the products")
	public void i_choose_the_products() {
		System.out.println("Inside Step - user chooses the products");
		productsMethodsPO = new ProductsMethodsPO(driver);
		productsMethodsPO.chooseProducts();

	}

	@And("I go to my cart to buy my products")
	public void i_go_to_my_cart_to_buy_my_products() {
		System.out.println("Inside Step - user reviews the products in the cart");
		cartPO = new CartPO(driver);
		cartPO.reviewCart();
		driver.findElement(By.name("firstName")).sendKeys("Trey");
		driver.findElement(By.name("lastName")).sendKeys("Griggs");
		driver.findElement(By.name("postalCode")).sendKeys("33076");
		cartPO.overviewCheckout();
	}

	@Then("the new purchase should be successful")
	public void the_new_purchase_should_be_successful() {
		System.out.println("Inside Step - user will be creates a new purchase");
		cartPO.verifyOrder();
	}

}
