package appiumcalc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class Appiummb {
static WebDriver driver;
	public static void main(String[] args)  {
		
		try {
			calc();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		catch(Exception f) {
			f.getStackTrace();
		}
	}
	
	public static void calc() throws MalformedURLException, InterruptedException {
		DesiredCapabilities desired = new DesiredCapabilities();
		desired.setCapability("platformName", "Android");
		desired.setCapability("deviceName", "moto g power");
		desired.setCapability("udid", "ZY227XTGJM");
		desired.setCapability("platformVersion", "11");
	
		//desired.setCapability("webdriver.chrome.driver", "chromedriver.exe");		
		// setting desire capabilities for app
		desired.setCapability("appPackage", "com.android.chrome");
		desired.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AppiumDriver<WebElement> driver = new AppiumDriver<WebElement>(url,desired);
		TouchAction action = new TouchAction(driver);
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.chrome:id/positive_button")).click();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.roicians.com/");
		Thread.sleep(5000);
		action.tap(ElementOption.element(driver.findElement(By.xpath("//button[@class='elementskit-menu-hamburger elementskit-menu-toggler']")))).perform();
		//driver.findElement(By.xpath("//button[@class='elementskit-menu-hamburger elementskit-menu-toggler']")).click();		
	}

}
