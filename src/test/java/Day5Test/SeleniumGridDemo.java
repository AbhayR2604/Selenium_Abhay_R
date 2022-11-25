package Day5Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGridDemo {
	WebDriver driver;
	
	@Parameters({"browserName","browserVersion","os","osVersion"})
	@BeforeMethod
	public void setup(String browserName, String browserVersion,String os,String osVersion) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("browserVersion", browserVersion);
		capabilities.setCapability("os",os);
		capabilities.setCapability("osVersion", osVersion);
		
		URL url = null;
		try {
			url = new URL("https://abhayram_hqg0GT:eY3WpHfzMvyzsepn8LPB@hub-cloud.browserstack.com/wd/hub");
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		driver = new RemoteWebDriver(url, capabilities);
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test
	public void mytest1() throws InterruptedException {
		
		
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("sample9@gmail.com");
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("Mukesh1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).isDisplayed());;
	}
	

}
