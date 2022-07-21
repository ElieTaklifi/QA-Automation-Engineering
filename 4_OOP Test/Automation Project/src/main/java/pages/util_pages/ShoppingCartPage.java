package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class ShoppingCartPage extends MenusPage{

	public ShoppingCartPage(MainPageManager pages) {
		super(pages);
	}
	
	public ShoppingCartPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("termsofservice"))));
		return this;
	}

	public ShoppingCartPage verifyPrice(String expectedPrice) {
		log.info("Save price new page as string");
	    String newPrice = driver.findElement(By.cssSelector(".product-subtotal")).getText();
		Assert.assertTrue(expectedPrice.equals(newPrice),
				"Expected value: '" + expectedPrice + "', but actual is '" + newPrice + "'");
		return this;
		
	}

	public ShoppingCartPage agreeToToS() {
		log.info("Click Terms of service button");
	    driver.findElement(By.id("termsofservice")).click();
		return this;		
	}

	public CheckOutPage clickCheckout() {
		log.info("Click checkout button");
	    driver.findElement(By.id("checkout")).click();
	    return pages.checkOutPage.ensurePageLoaded();
	}
}
