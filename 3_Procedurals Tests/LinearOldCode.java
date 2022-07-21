package tests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.supers.TestBase;
import util.GenUtils;

public class LinearOldCode extends TestBase {

	String timestamp, email, password, city, address, zip, phone;

	@Test
	public void test() {
		try {

			initParameter();
			app.getDriver().get("https://demo.nopcommerce.com/");

			registerNewUser();
			shoppingProcessEndToEnd();

			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}

	private void initParameter() {
		timestamp = GenUtils.getCurrentTimestamp(GenUtils.TIME_FORMAT_ddMMyyHHmmSSS);
		email = "randomEmail" + timestamp + "@gmail.com";
		password = "123456";
		city = "Paris";
		address = "Av Foch";
		zip = "75001";
		phone = "123456789";
	}

	private void registerNewUser() {

		WebDriver driver = app.getDriver();

		log.info("Click Register");
		driver.findElement(By.linkText("Register")).click();

		log.info("Select male");
		driver.findElement(By.id("gender-male")).click();

		log.info("Enter first name");
		driver.findElement(By.id("FirstName")).sendKeys("Name1");

		log.info("Enter last name");
		driver.findElement(By.id("LastName")).sendKeys("Name2");

		log.info("Select Birthday");
		Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
		day.selectByVisibleText("1");

		Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		month.selectByVisibleText("January");

		Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
		year.selectByVisibleText("1920");

		log.info("Type randomized email");

		log.info("Randomized email is: " + email);
		driver.findElement(By.id("Email")).sendKeys(email);

		log.info("Type password");
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

		log.info("Click register button");
		driver.findElement(By.id("register-button")).click();

		String actualTextRegistration = driver.findElement(By.cssSelector(".result")).getText();
		String expectedTextRegistration = "Your registration completed";
		Assert.assertTrue(actualTextRegistration.equals(expectedTextRegistration),
				"Expected value: '" + expectedTextRegistration + "', but actual is '" + actualTextRegistration + "'");

		driver.findElement(By.cssSelector(".register-continue-button")).click();
		String firstScreenText = driver.findElement(By.cssSelector(".topic-block-title > h2")).getText();
		String expectedTextFirstScreen = "Welcome to our store";
		Assert.assertTrue(firstScreenText.equals(expectedTextFirstScreen),
				"Expected value: '" + expectedTextFirstScreen + "', but actual is '" + actualTextRegistration + "'");

		log.info("Click logout button");
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();

	}

	private void shoppingProcessEndToEnd() {

		WebDriver driver = app.getDriver();
		log.info("Click login button");
		driver.findElement(By.linkText("Log in")).click();
		
		log.info("Enter login details");
		
		log.info("Type email " + email);
		driver.findElement(By.id("Email")).sendKeys(email);
		
		log.info("Type password " + password);
		driver.findElement(By.id("Password")).sendKeys(password);
		
		log.info("Click login button");
		driver.findElement(By.cssSelector(".login-button")).click();
		
		log.info("Click Electronics button");
		driver.findElement(By.linkText("Electronics")).click();
		
		log.info("Click Cell Phones button");
	    driver.findElement(By.cssSelector(".item-box:nth-child(2) .title > a")).click();
	    
	    log.info("Save the price as string");
	    String expectedPrice = driver.findElement(By.cssSelector(".item-box:nth-child(2) .price")).getText();
	    
	    log.info("Click Add to cart button");
	    driver.findElement(By.cssSelector(".item-box:nth-child(2) .product-box-add-to-cart-button")).click();
	    
	    log.info("Sleep until green panel disappears");
	    GenUtils.sleepSeconds(6);
	    
	    log.info("Click Shopping cart button");
	    driver.findElement(By.cssSelector(".cart-label")).click();
	    
	    log.info("Save price new page as string");
	    String newPrice = driver.findElement(By.cssSelector(".product-subtotal")).getText();
		Assert.assertTrue(expectedPrice.equals(newPrice),
				"Expected value: '" + expectedPrice + "', but actual is '" + newPrice + "'");
	    
	    log.info("Click Terms of service button");
	    driver.findElement(By.id("termsofservice")).click();
	    
	    log.info("Click checkout button");
	    driver.findElement(By.id("checkout")).click();
	    
	    log.info("Select country dropdown");
	    Select dropdown = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
	    dropdown.selectByVisibleText("France");
	    
	    log.info("Sleep until province charge");
	    GenUtils.sleepSeconds(3);
	    
	    log.info("Type city" + city);
	    driver.findElement(By.id("BillingNewAddress_City")).sendKeys(city);
	    
	    log.info("Type address" + address);
	    driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(address);
	   
	    log.info("Type Zip" + zip);
	    driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(zip);
	    
	    log.info("Type Phone number" + phone);
	    driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(phone);
	    
	    log.info("Sleep Continue button charge");
	    GenUtils.sleepSeconds(2);
	    
	    log.info("Click Continue (save) button");
	    driver.findElement(By.name("save")).click();
	    
	    log.info("Sleep Continue button charge");
	    GenUtils.sleepSeconds(2);
	    
	    log.info("Click Continue (shipping-method) button");
	    driver.findElement(By.cssSelector(".shipping-method-next-step-button")).click();
	    
	    log.info("Sleep Continue button charge");
	    GenUtils.sleepSeconds(2);
	    
	    log.info("Click Continue (payment-method) button");
	    driver.findElement(By.cssSelector(".payment-method-next-step-button")).click();
	    
	    log.info("Sleep Continue button charge");
	    GenUtils.sleepSeconds(2);
	    
	    log.info("Click Continue (payment-info) button");
	    driver.findElement(By.cssSelector(".payment-info-next-step-button")).click();
	    
	    log.info("Sleep Continue button charge");
	    GenUtils.sleepSeconds(2);
	    
	    log.info("Save price last page as string");
	    String lastPrice = driver.findElement(By.cssSelector(".product-subtotal")).getText();
		Assert.assertTrue(expectedPrice.equals(lastPrice),
				"Expected value: '" + expectedPrice + "', but actual is '" + lastPrice + "'");
		
		log.info("Sleep Continue button charge");
	    GenUtils.sleepSeconds(2);
	    
	    log.info("Click Continue (confirm-order) button");
	    driver.findElement(By.cssSelector(".confirm-order-next-step-button")).click();
	    
	    log.info("Sleep Continue button charge");
	    GenUtils.sleepSeconds(2);
	    
	    log.info("Check string after order 1");
	    String actualTextOrder1 = driver.findElement(By.cssSelector("h1")).getText();
		String expectedTextOrder1 = "Thank you";
		Assert.assertTrue(actualTextOrder1.equals(expectedTextOrder1),
				"Expected value: '" + expectedTextOrder1 + "', but actual is '" + actualTextOrder1 + "'");
		
		log.info("Check string after order 2");
	    String actualTextOrder2 = driver.findElement(By.cssSelector(".section > .title > strong")).getText();
		String expectedTextOrder2 = "Thank you";
		Assert.assertTrue(actualTextOrder1.equals(expectedTextOrder2),
				"Expected value: '" + expectedTextOrder2 + "', but actual is '" + actualTextOrder2 + "'");
	    
		
		log.info("Sleep Continue button charge");
	    GenUtils.sleepSeconds(2);
	    
	    log.info("Click Continue (confirm-order) button");
	    driver.findElement(By.cssSelector(".order-completed-continue-button")).click();
	    
	    log.info("Check back to first screen");
	    String actualTextScreen = driver.findElement(By.cssSelector(".topic-block-title > h2")).getText();
		String expectedTextScreen = "Welcome to our store";
		Assert.assertTrue(actualTextScreen.equals(expectedTextScreen),
				"Expected value: '" + expectedTextScreen + "', but actual is '" + actualTextScreen + "'");
		
		log.info("Check shopping cart");
	    String actualTextShoppingCart = driver.findElement(By.cssSelector(".cart-qty")).getText();
		String expectedTextShoppingCart = "(0)";
		Assert.assertTrue(actualTextShoppingCart.equals(expectedTextShoppingCart),
				"Expected value: '" + expectedTextShoppingCart + "', but actual is '" + actualTextShoppingCart + "'");
	    
	}
}