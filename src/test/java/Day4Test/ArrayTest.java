package Day4Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayTest {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().window().maximize();
	}
	
//	@AfterMethod
//	public void teardown() {
//		driver.quit();
//		System.out.println("Running After Method - Browser session closed");
//	}
	@Test(dataProvider =  "data-provider")
	public void myTest(String username,String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Test-1 Executed" +username +" "+password);
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).isDisplayed());;
		driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();
	}
	
	@DataProvider(name = "data-provider")
	public Object[][] testDataGeneration()
	{
		Object [][]arr = new Object[4][2];
		   arr[0][0] = "sample9@gmail.com";
	        arr[0][1] = "Mukesh1234";
	        arr[1][0] = "samplemukesh@gmail.com";
	        arr[1][1] = "Mukesh1234";
	        arr[2][0] = "samplemukesh1@gmail.com";
	        arr[2][1] = "Mukesh1234";
	        arr[3][0] = "samplemukesh2@gmail.com";
	        arr[3][1] = "hello";
	        return arr;
	}

}
