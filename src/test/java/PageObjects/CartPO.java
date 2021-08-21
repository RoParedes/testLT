package PageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPO {
	//variables
	private WebDriver driver;
	private By lblHeaderOverview = By.xpath("//div/span[@class='title']");
	private By lblThanksMessage = By.xpath("//h2");
	private By btnOpenMenu = By.xpath("//div[@class='bm-burger-button']/button");
	private By itemLogOut = By.xpath("//div/nav/a[@id='logout_sidebar_link']");
	
	public CartPO(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Validates the option to access the cart and continue with the checkout form.
	 */
	public void reviewCart() {
		 driver.findElement(By.id("shopping_cart_container")).click();
		 driver.findElement(By.id("checkout")).click();
		 
		}
	
	/*
	 * Verifies if the title of the page are equals than the expected.
	 */
	public void overviewCheckout() {
		driver.findElement(By.id("continue")).click();
		String titlePage = driver.findElement(lblHeaderOverview).getText();
		assertEquals("The expected message are not the same", "CHECKOUT: OVERVIEW", titlePage);
	}
	
	/*
	 * Validates the last message when to finish the order process
	 * And return to the product page.
	 * and Logs out of the web.
	 */
	public void verifyOrder() {
		 driver.findElement(By.name("finish")).click();
		 String thanksMessage = driver.findElement(lblThanksMessage).getText();
		 assertEquals("The expected message are not the same", "THANK YOU FOR YOUR ORDER", thanksMessage);
		 driver.findElement(By.name("back-to-products")).click();
		 driver.findElement(btnOpenMenu).click();
		 driver.findElement(itemLogOut).click();
		 driver.close();
		 }
}
