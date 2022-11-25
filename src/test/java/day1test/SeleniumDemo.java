package day1test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumDemo {

	@Test
	public void test4() {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Abhay R");
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		String url = driver.getCurrentUrl();
		System.out.println("URL is "+url);
		Assert.assertTrue(true);

	}

}
