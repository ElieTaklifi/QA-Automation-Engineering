package tests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import tests.supers.TestBase;
import util.GenUtils;

public class AppiumTestHomeWork extends TestBase {

	@Test
	public void test() {
		try {

			WebDriver driver = app.getDriver();
			log.info("Click Add");
			driver.findElement(By.id("com.sec.android.app.clockpackage:id/menu_alarm_add")).click();
			
			GenUtils.sleepSeconds(2);
			log.info("Click M");
			driver.findElement(By.id("com.sec.android.app.clockpackage:id/repeat_1")).click();

			log.info("Click Vibration");
			driver.findElement(By.id("com.sec.android.app.clockpackage:id/alarm_sound_switch")).click();
			
			log.info("Click save");
			driver.findElement(By.id("com.sec.android.app.clockpackage:id/smallLabel")).click();

			log.info("Rotate Landscape");
			((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
			log.info("Rotate Portrait");
			((Rotatable) driver).rotate(ScreenOrientation.PORTRAIT);


			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}
}
