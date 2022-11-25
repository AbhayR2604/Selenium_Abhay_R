package Day3;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.findElement(By.name("email1")).sendKeys("ineuron@ineuron.ai");
		driver.findElement(By.id("password1")).sendKeys("ineuron");
		driver.findElement(By.xpath("//button[@class ='submit-btn']")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//span[text()='Manage']"));
		String parent=driver.getWindowHandle();


		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

		driver.findElement(By.xpath("//a[@href='/category/manage']")).click();
		Thread.sleep(2000);
		Set<String> allWindowHandle=driver.getWindowHandles();
		for(String child:allWindowHandle)
		{

			if(!child.equals(parent))
			{

				driver.switchTo().window(child);
				driver.findElement(By.xpath("//button[normalize-space()='Add New Category']")).click();
				//		WebElement ele2 = driver.findElement(By.xpath("m//button[contains('Add New Category')]"));
				//		Actions action1 = new Actions(driver);
				//		action.moveToElement(ele2).perform();
				WebDriverWait wb=new WebDriverWait(driver,Duration.ofSeconds(10));
				Alert alt=wb.until(ExpectedConditions.alertIsPresent());
				alt.sendKeys("JavaSelenium");
		        alt.accept();
		        driver.findElement(By.xpath("//td[contains(text(),'JavaSelenium')]//following::button[1]")).click();
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("//button[@xpath='1']")).click();
		        
			}
		}
		
	}
}
