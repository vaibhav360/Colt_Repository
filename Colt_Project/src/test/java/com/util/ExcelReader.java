package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelReader 
{
	File file=null;
	FileInputStream  inputStream=null;
	Workbook workbook=null;
	String fileExtensionName=null;
	Sheet sheet=null;

	public ExcelReader(String fileName,String sheetName) throws IOException
	{
		file =    new File(getPath()+"\\ExcelFile\\"+fileName);
		inputStream = new FileInputStream(file);
		workbook = null;

		fileExtensionName = fileName.substring(fileName.indexOf("."));
		if(fileExtensionName.equals(".xlsx"))
		{
			workbook = new XSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xls"))
		{
			workbook = new HSSFWorkbook(inputStream);
		}
		sheet = workbook.getSheet(sheetName);
	}

	
	//Get absolute path
	public String getPath()
	{
		String path ="";		
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("/", "//");		
		return path;
	}

	@SuppressWarnings({ "deprecation", "null" })
	public String readExcel(int row,int col) throws IOException
	{
		String value="";
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		if(row>rowCount)
		{
			return "INVALID ROW...";
		}
		Row row1 = sheet.getRow(row);	
		if(col>row1.getLastCellNum())
		{
			return "INVALID COLUMN...";
		}
		else
		{
			row1 = sheet.getRow(row);
			switch(row1.getCell(col).getCellTypeEnum())
			{
			case NUMERIC :
				value = String.valueOf(row1.getCell(col).getNumericCellValue());
				break;
			case STRING:
				value= String.valueOf(row1.getCell(col).getStringCellValue());
				break;
			case FORMULA:
				value = String.valueOf(row1.getCell(col).getCellFormula());
				break;
			case BOOLEAN:
				value = String.valueOf(row1.getCell(col).getBooleanCellValue());
				break;
			case BLANK:
				value = null;
				break;
			default:
				Assert.fail("Invalid Format is found");
				break;
			}
		}
		return value;
	}
	
	public int getRowCount()
	{
		return sheet.getLastRowNum()-sheet.getFirstRowNum();
	}
	
	public int getColCount()
	{
		Row row1 = sheet.getRow(0);	
		return row1.getLastCellNum();		
	}
}
