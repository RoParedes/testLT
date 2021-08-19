package StepDefinitions;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.*;

public class ProductsSteps {
	
	WebDriver driver = null;
	public static WebDriver driverW;
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	public static void highlightObject(WebElement object) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driverW;
			jse.executeScript("arguments[0].setAttribute('style','background: #e0ebeb; border: 2px solid green;');", object);
		} catch(Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append(LINE_SEPARATOR).append("----It was not possible to highlight the object.").append(LINE_SEPARATOR);
			sb.append("-----Exception: " + e.getMessage());
			Logger.getAnonymousLogger().log(Level.SEVERE, sb.toString());
		}
	}

	@SuppressWarnings("deprecation")
	@Given("I log in to Swag Lab")
	public void i_log_in_to_swag_lab() {
		System.out.println("Inside Step - user is on login page");
		
		String projectPath=System.getProperty("user.dir");
		System.out.println("Project Path is: " + projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.saucedemo.com");
		
	}

	@And("user enters like {string} and password {string}")
	public void user_enters_like_and_password(String string, String string2) throws InterruptedException {
		System.out.println("Inside Step - user enters username and password");
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		//driver.getPageSource().contains("Epic sadface: Sorry, this user has been locked out.");//Para un codigo extra

	}

	@When("I select the {string} filter")
	public void i_select_the_filter(String string) {
		System.out.println("Inside Step - user selects the filter");
	}

	@And("I choose the products")
	public void i_choose_the_products() {
		System.out.println("Inside Step - user chooses the products");
	}

	@And("I go to my cart to buy my products")
	public void i_go_to_my_cart_to_buy_my_products() {
		System.out.println("Inside Step - user reviews the products in the cart");
	}

	@Then("the new purchase should be successful")
	public void the_new_purchase_should_be_successful() {
		System.out.println("Inside Step - user will be creates a new purchase");
	}
	
}
