package jenkins.jenkinsIntegration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SampleTest {

	@Test
	public void testLaunch() throws InterruptedException, MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, System.getProperty("PlatformName"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, System.getProperty("PlatformVersion"));
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "CJ's iPhone");
		capabilities.setCapability("udid", "25e7a555854513e7e1b9c70eef95435fdbe79e96");
		//capabilities.setCapability(MobileCapabilityType.APP, "/Users/user/Library/Developer/Xcode/DerivedData/UICatalog-dcohmfrxpwrlzvaovpgrsbdhfemk/Build/Products/Debug-iphonesimulator/UICatalog.app");
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/mobileappstester/Library/Developer/Xcode/DerivedData/UICatalog-dfdkrfsmlarjpwasrlifmkytqfea/Build/Products/Debug-iphoneos/UICatalog.app");
		IOSDriver<MobileElement> driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[7]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIAStaticText[1]")).click();
		driver.scrollTo("Date Picker").click();
		System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(0).getAttribute("value"));	
		System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(1).getAttribute("value"));
		System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(2).getAttribute("value"));
		System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(3).getAttribute("value"));
		driver.findElements(By.className("UIAPickerWheel")).get(0).sendKeys("Sun Sept 18");
		driver.findElements(By.className("UIAPickerWheel")).get(1).sendKeys("12");
		driver.findElements(By.className("UIAPickerWheel")).get(2).sendKeys("00");
		driver.findElements(By.className("UIAPickerWheel")).get(3).sendKeys("PM");
		Thread.sleep(5000);
		driver.quit();
	}
}
