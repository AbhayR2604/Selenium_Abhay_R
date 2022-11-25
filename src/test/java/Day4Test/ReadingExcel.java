package Day4Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingExcel {
	@Test
	public void testData() throws InvalidFormatException {
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
//		String username = wb.getSheet("loginData").getRow(0).getCell(0).getStringCellValue();
//		System.out.println(username);
//		
		wb.close();
		
	}catch(FileNotFoundException e) {
		System.out.println("Please check data file path "+e.getMessage());
	}catch(IOException e) {
		System.out.println("Something went wrong IO "+e.getMessage());
	}
}
}
