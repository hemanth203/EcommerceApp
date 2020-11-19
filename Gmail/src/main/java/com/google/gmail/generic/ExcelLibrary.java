package com.google.gmail.generic;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary
{
	public static Object[][] getAllExcelData(String excelPath, String sheetName)
	{
		Object[][] objArr=null;
		try
		{
			FileInputStream fin = new FileInputStream(excelPath);
			Workbook wb=WorkbookFactory.create(fin);
			Sheet sheet=wb.getSheet(sheetName);
			int rowsCount=sheet.getPhysicalNumberOfRows();
			objArr = new Object[rowsCount-1][2];
			for(int i=1,k=0;i<=rowsCount-1;i++,k++)
			{
				int cellsCount=sheet.getRow(i).getPhysicalNumberOfCells();
				for(int j=0;j<=cellsCount-1;j++)
				{
					String data=sheet.getRow(i).getCell(j).getStringCellValue();
					objArr[k][j]=data;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return objArr;
	}
	
	public static String getCellData(String excelPath, String sheetName, int row, int cell)
	{
		try
		{
			FileInputStream fin = new FileInputStream(excelPath);
			Workbook wb=WorkbookFactory.create(fin);
			Sheet sheet=wb.getSheet(sheetName);
			return sheet.getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
