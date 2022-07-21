package tests.basic;

import org.testng.annotations.Test;

import tests.supers.TestBase;
import util.GenUtils;

public class PageObjectCode extends TestBase {

	String timestamp, email, password, price, country, city, address, zip, phone;

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
        price = "";
        country = "France";
        city = "Paris";
		address = "Av Foch";
		zip = "75001";
		phone = "123456789";
	}

	
	private void registerNewUser() {

		app.pages().menusPage.clickRegister().chooseGender("male")
				.setFirstName("Name1").setLastName("Name2")
				.selectBirthdayDay("1").selectBirthdayMonth("January").selectBirthdayYear("2000")
				.setMail(email)
				.setPassword(password).setPasswordVerification(password)
				.clickRegisterButton()
				.verifySuccessMessage().clickContinue().verifyHomeText().logout();
	}

	private void shoppingProcessEndToEnd() {
	
		//login
		String expectedPrice = app.pages().menusPage.clickLogin().setEmail(email).setPassword(password).clickLoginButton().
		clickElectronicCategory().clickCellePhoneCategory().addItemToCart().getPrice();
		GenUtils.sleepSeconds(6);
		app.pages().menusPage.checkAmountInCart(1).clickShoppingCart().verifyPrice(expectedPrice).agreeToToS().clickCheckout().
				setCountry(country).setCity(city).setAddress1(address).setZip(zip).setPhone(phone).
				clickContinueToShippingMethod().clickContinueToPaymentMethod().clickContinueToPaymentInfo().clickContinueToComfirmOrder().
				verifyOrderPrice(expectedPrice).clickComfirmOrder().verifySuccessMessage().clickContinue().verifyHomeText().logout();

	}
}
