package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{		
		File src = new File(".\\ApplicationTestData\\AppData.xlsx");
		try {
			
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
		
		}
		catch(Exception e)
		{
			System.out.println("Exception is :"+ e.getMessage());
		}
		
	}
	
	
	public String getData(int sheetnumber, int row, int coloumn)
	{
		//XSSFSheet sheet = wb.getSheetAt(sheetnumber);
		String data =wb.getSheetAt(sheetnumber).getRow(row).getCell(coloumn).getStringCellValue();
		return data;
		
	}
	
	public String getData(String sheetname, int row, int coloumn)
	{
		//XSSFSheet sheet = wb.getSheetAt(sheetnumber);
		String data =wb.getSheet(sheetname).getRow(row).getCell(coloumn).getStringCellValue();
		return data;
		
	}
	
}


