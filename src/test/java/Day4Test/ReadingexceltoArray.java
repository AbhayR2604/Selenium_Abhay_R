package Day4Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadingexceltoArray {

	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().window().maximize();
	}

		@AfterMethod
		public void teardown() {
			driver.quit();
			System.out.println("Running After Method - Browser session closed");
		}
		
		
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
	@Test
	public Object[][] testDataGeneration() throws InvalidFormatException
	{
		Object arr[][]=null;
		File src = new File("C:/QE workspace/SapientTestData.xlsx");
		try {
			XSSFWorkbook wb = new XSSFWorkbook(src);
			XSSFSheet sh = wb.getSheet("loginData");

			int r = sh.getPhysicalNumberOfRows();
			int c = sh.getRow(0).getPhysicalNumberOfCells();
			arr=new Object[r][c];
			for(int i =0;i<r;i++) {
				for(int j=0;j<c;j++)
				{
					arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();

				}
			}

		}catch(FileNotFoundException e) {
			System.out.println("Please check data file path "+e.getMessage());
		}catch(IOException e) {
			System.out.println("Something went wrong IO "+e.getMessage());
		}
		return arr;
	}
}



