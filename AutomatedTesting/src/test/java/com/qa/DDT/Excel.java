package com.qa.DDT;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.constants.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Excel {
	
	public WebDriver driver; 
	private ExtentReports report;
	private ExtentTest test;
	
	@Before
	public void setUp() throws IOException{
		
		System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_LOCATION);	
		driver = new ChromeDriver();
		report=new ExtentReports(Constants.getTestResourcesPath()+"\\DDT.html",true);
					
	}
	
	@Test
	public void readFromExcelTest() throws IOException{
		ExtentTest test=report.startTest("Verify opening of Excel page");
		FileInputStream file =null;
		try {
			file=new FileInputStream(Constants.getTestResourcesPath()+"\\TestData.xlsx");		
			}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook workbook =null;
		try {
			workbook=new XSSFWorkbook(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,"Excel file opened");
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFCell cell = sheet.getRow(0).getCell(0);
		System.out.println(cell.getStringCellValue());		
		assertTrue(cell.getStringCellValue().equals("Username"));
		report.flush();
	}
	

}
