package com.vmetry.crmapp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataWithExcellSource {

	public static Object[][] getDataset(String methodName) throws Exception {

		

		XSSFWorkbook book = new XSSFWorkbook(new File(
				"D:\\WrokOutSelenium Wrokphase\\CRMAppDDDFrameWorkTest\\src\\test\\resources\\External_Source_File\\CRMAPPTestData.xlsx"));

		XSSFSheet sheet = book.getSheet(methodName);

		int rowno = sheet.getLastRowNum();

		int cellno = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[cellno][rowno + 1];

		for (int i = 0; i <= rowno; i++) {
			
			for (int j = 0; j < cellno; j++)
			 {
				
				Cell cell=sheet.getRow(i).getCell(j);
				sheet.getRow(i).getCell(j).setCellType(cell.CELL_TYPE_STRING);
				data[j][i]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;

	}

}
