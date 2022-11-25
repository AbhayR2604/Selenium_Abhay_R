package Day3Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.out.println("Running before method - creating browser session");
		driver = new ChromeDriver();
		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("Running After Method - Browser session closed");
	}
	
	@Test
	public void Noentry() {
		driver.findElement(By.xpath("//input[@class='button']")).click();
//		WebElement ele = driver.findElement(By.xpath("//span[@id='spanMessage'].getText()"));
//		String s = "Username cannot be empty";
//		Assert.assertEquals(ele, s);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='spanMessage']")).getText().contains("Username cannot be empty"));			
	}
	
	@Test
	public void ValidCredentials() {
		driver.findElement(By.xpath("//input[@id ='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id ='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
		driver.findElement(By.xpath("//input[@type ='submit']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
	@Test
	public void InvalidPassword() {
		driver.findElement(By.xpath("//input[@id ='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id ='txtPassword']")).sendKeys("passowrd");
		driver.findElement(By.xpath("//input[@type ='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id ='spanMessage']")).getText().contains("Invalid"));
	}
	
	@Test
	public void ForgotPassword() {
		driver.findElement(By.xpath("//a[normalize-space()='Forgot your password?']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
		
	}
}
