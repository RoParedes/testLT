package PageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsMethodsPO {
	// variables
	private By lblHeaderProductPage = By.xpath("//div/span[@class='title']");
	private WebDriver driver;
	private By cmb_Selector = By.xpath("//select[@class='product_sort_container']");

	public ProductsMethodsPO(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Verifies the title of the Page for Products.
	 */
	public void titleProductPage() {
		String titlePage = driver.findElement(lblHeaderProductPage).getText();
		assertEquals("The expected message are not the same", "PRODUCTS", titlePage);
	}
	
	/*
	 * Selects the filter option for Low to High priced of the products. 
	 */
	public void selectDropdownFilter() {
		Select selectList = new Select(driver.findElement(cmb_Selector));
		selectList.selectByVisibleText("Price (low to high)");
	}

	/*
	 * Chooses the each product according to the prices. 
	 */
	public void chooseProducts() {
		driver.findElement(By.name("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
	}

}
