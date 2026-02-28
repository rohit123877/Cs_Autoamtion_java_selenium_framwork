package com.cs_automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	

	//Classes use for red the excel file 
	public static FileInputStream inputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String getCellValue(String fileName , String sheetName, int rowNO, int CellNo)
	{
		try {
			inputStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			cell = workBook.getSheet(sheetName).getRow(rowNO).getCell(CellNo);
			workBook.close();
			return cell.getStringCellValue();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}
	}
	public static int getRowCount(String fileName, String sheetName)
	{
		try {
			inputStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			int ttrows = excelSheet.getLastRowNum()+1;
			workBook.close();
			return ttrows;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
		public static int getColCount( String fileName, String sheetName) {
			try {
				FileInputStream inputStream = new FileInputStream(fileName);
				workBook = new XSSFWorkbook(inputStream);
				excelSheet = workBook.getSheet(sheetName);
				int ttcell = excelSheet.getRow(0).getLastCellNum();
				workBook.close();
				return ttcell;
			} catch (Exception e) {
				// TODO: handle exception
				return 0;
			}
		}
	}
