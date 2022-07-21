package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;
import util.GenUtils;

public class OrderSuccessPage extends MenusPage{

	public OrderSuccessPage(MainPageManager pages) {
		super(pages);
	}
	
	public OrderSuccessPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".page-title"))));
		return this;
	}

	public OrderSuccessPage verifySuccessMessage() {
		GenUtils.sleepSeconds(1);
		log.info("Check string after order 1");
	    String actualTextOrder1 = driver.findElement(By.cssSelector("h1")).getText();
		String expectedTextOrder1 = "Thank you";
		Assert.assertTrue(actualTextOrder1.equals(expectedTextOrder1),
				"Expected value: '" + expectedTextOrder1 + "', but actual is '" + actualTextOrder1 + "'");
		
		log.info("Check string after order 2");
	    String actualTextOrder2 = driver.findElement(By.cssSelector(".section > .title > strong")).getText();
		String expectedTextOrder2 = "Your order has been successfully processed!";
		Assert.assertTrue(actualTextOrder2.equals(expectedTextOrder2),
				"Expected value: '" + expectedTextOrder2 + "', but actual is '" + actualTextOrder2 + "'");
		return this;
	}

	public HomePage clickContinue() {
		log.info("Click Continue (confirm-order) button");
	    driver.findElement(By.cssSelector(".order-completed-continue-button")).click();
		return pages.homePage.ensurePageLoaded();
	}
	
}