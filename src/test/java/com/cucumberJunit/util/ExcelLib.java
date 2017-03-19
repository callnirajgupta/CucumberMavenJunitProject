package com.cucumberJunit.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelLib {
	
	String excelpath=System.getProperty("user.dir")+"\\src\\test\\resources\\report.xlsx";
	
	public String getExcelData(String sheetname,int rowNum,int colNum) throws Exception  {
	FileInputStream fis = new FileInputStream(excelpath);
	Workbook bk=WorkbookFactory.create(fis);
	Sheet sh=bk.getSheet(sheetname);
	Row row=sh.getRow(rowNum);
	String data=row.getCell(colNum).getStringCellValue();
		return data;
	}

	
	public  void setExcelData(String sheetname,int rowNum,int colNum,String data) throws InvalidFormatException, IOException{
		
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook bk=WorkbookFactory.create(fis);
		Sheet sh=bk.getSheet(sheetname);
		Row row=sh.getRow(rowNum);
		Cell cell=row.getCell(colNum);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(excelpath);
		bk.write(fos);
			
	}
	
	public int getExcelRowcount(String sheetname) throws Throwable {
		
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook bk=WorkbookFactory.create(fis);
		Sheet sh=bk.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		return rowcount;
		
	}
	
	public int getexcelcolcount(String sheetname,int rowNum) throws Throwable{
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook bk=WorkbookFactory.create(fis);
		Sheet sh=bk.getSheet(sheetname);
		Row row=sh.getRow(rowNum);
		int cellNum=row.getLastCellNum();
		return cellNum;
		
	}
	
	public int getRowNumber(String sheetName,String Scenario) throws Throwable{
		int row=0;
		for (int i=1;i<=getExcelRowcount(sheetName);i++){
			if(getExcelData(sheetName,i,0).equals(Scenario)){
			row=i;	
			}
			
		}
		
		
		return row;
		
	}
	
	public void reSetRunResult() throws Throwable{
		
		for (int i=1;i<=getExcelRowcount("Sheet2");i++){
			setExcelData("Sheet2", i, 1, "No Run");
			
		}
	}
}