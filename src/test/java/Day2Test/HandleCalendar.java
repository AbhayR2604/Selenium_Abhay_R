package Day2Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleCalendar {
	@Test
	public void test() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html\r\n");
		driver.findElement(By.xpath("//input[@id ='datepicker']")).click();
		driver.findElement(By.xpath("//a[text()='25']")).click();
		Assert.assertTrue(true);
	}
}
