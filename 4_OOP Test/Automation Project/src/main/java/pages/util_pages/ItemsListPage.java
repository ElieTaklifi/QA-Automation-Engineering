package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class ItemsListPage extends MenusPage{
	
	public ItemsListPage(MainPageManager pages) {
		super(pages);
	}
	
	public ItemsListPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".page-title"))));
		return this;
	}
	
	public String getPrice() {
		log.info("Save the price as string");
	    return driver.findElement(By.cssSelector(".item-box:nth-child(2) .price")).getText();
	}

	public ItemsListPage addItemToCart() {
	    log.info("Click Add to cart button");
	    driver.findElement(By.cssSelector(".item-box:nth-child(2) .product-box-add-to-cart-button")).click();
		return this.ensurePageLoaded();
	}

}
