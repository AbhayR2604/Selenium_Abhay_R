package Day5Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demoTest {
 
	WebDriver driver;
	@Test
	public void mytest1() throws InterruptedException {
		ChromeDriver d = new ChromeDriver();
		
		d.get("https://ineuron-courses.vercel.app/login");
		d.findElement(By.xpath("//input[@id='email1']")).sendKeys("sample9@gmail.com");
		d.findElement(By.xpath("//input[@id='password1']")).sendKeys("Mukesh1234");
		d.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		Assert.assertTrue(d.findElement(By.xpath("//button[contains(text(),'Sign out')]")).isDisplayed());;
	}
}
