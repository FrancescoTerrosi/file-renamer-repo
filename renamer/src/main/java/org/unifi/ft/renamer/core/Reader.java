package org.unifi.ft.renamer.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reader {

	public String filename;

	public Reader(String filename) {
		this.filename = filename;
	}
	
	public Hashtable<String, BigInteger> readFile() throws IOException {
		Hashtable<String, BigInteger> result = new Hashtable<>();
		try {

			InputStream inp = new FileInputStream(filename);
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row row;
			Cell cell1;
			Cell cell2;

			int rows; // No of rows
			rows = sheet.getPhysicalNumberOfRows();

			int cols = 0; // No of columns
			int tmp = 0;

			// This trick ensures that we get the data properly even if it doesn't start
			// from first few rows
			for (int i = 0; i < 10 || i < rows; i++) {
				row = sheet.getRow(i);
				if (row != null) {
					tmp = sheet.getRow(i).getPhysicalNumberOfCells();
					if (tmp > cols)
						cols = tmp;
				}
			}
			for (int r = 1; r < rows; r++) {
				row = sheet.getRow(r);
				if (row != null) {
						cell1 = row.getCell(0);
						cell2 = row.getCell(1);
						if (cell1 != null && cell2 != null) {
							result.put(cell1.getStringCellValue(), new BigInteger(cell2.getStringCellValue()));
						}
					}
				}
			wb.close();
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		return result;
	}
}
