package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;
import util.GenUtils;

public class CheckOutPage extends MenusPage{

	public CheckOutPage(MainPageManager pages) {
		super(pages);
	}
	
	public CheckOutPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".page-title"))));
		return this;
	}

	public CheckOutPage setCountry(String string) {
		log.info("Select country dropdown");
	    Select dropdown = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
	    dropdown.selectByVisibleText(string);
	    GenUtils.sleepSeconds(2);
	    return this;
	}

	public CheckOutPage setCity(String string) {
		log.info("Type city" + string);
	    driver.findElement(By.id("BillingNewAddress_City")).sendKeys(string);
	    return this;
	}

	public CheckOutPage setAddress1(String address) {
		log.info("Type address" + address);
	    driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(address);
	    return this;
	}

	public CheckOutPage setZip(String zip) {
		log.info("Type Zip" + zip);
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(zip);
		return this;
	}

	public CheckOutPage setPhone(String phone) {
		log.info("Type Phone number" + phone);
	    driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(phone);
	    GenUtils.sleepSeconds(1);
	    return pages.checkOutPage.ensurePageLoaded();
	}

	public CheckOutPage clickContinueToShippingMethod() {
		log.info("Click Continue (save) button");
	    driver.findElement(By.name("save")).click();
	    GenUtils.sleepSeconds(1);
	    return pages.checkOutPage.ensurePageLoaded();
	}
	
	public CheckOutPage clickContinueToPaymentMethod() {
		log.info("Click Continue (shipping-method) button");
	    driver.findElement(By.cssSelector(".shipping-method-next-step-button")).click();
	    GenUtils.sleepSeconds(1);
	    return pages.checkOutPage.ensurePageLoaded();
	}
	
	public CheckOutPage clickContinueToPaymentInfo() {
		log.info("Click Continue (payment-method) button");
	    driver.findElement(By.cssSelector(".payment-method-next-step-button")).click();
	    GenUtils.sleepSeconds(1);
	    return pages.checkOutPage.ensurePageLoaded();
	}
	
	public CheckOutPage clickContinueToComfirmOrder() {
		log.info("Click Continue (payment-info) button");
	    driver.findElement(By.cssSelector(".payment-info-next-step-button")).click();
	    GenUtils.sleepSeconds(1);
	    return pages.checkOutPage.ensurePageLoaded();
	}

	public CheckOutPage verifyOrderPrice(String expectedPrice) {
		String lastPrice = driver.findElement(By.cssSelector(".product-subtotal")).getText();
		Assert.assertTrue(expectedPrice.equals(lastPrice),
				"Expected value: '" + expectedPrice + "', but actual is '" + lastPrice + "'");
		GenUtils.sleepSeconds(1);
		return pages.checkOutPage.ensurePageLoaded();
	}

	public OrderSuccessPage clickComfirmOrder() {
		log.info("Click Continue (confirm-order) button");
	    driver.findElement(By.cssSelector(".confirm-order-next-step-button")).click();
	    GenUtils.sleepSeconds(1);
	    return pages.orderSuccessPage.ensurePageLoaded();
	}

}
