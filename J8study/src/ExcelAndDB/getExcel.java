package ExcelAndDB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.ss.util.WorkbookUtil;

//import org.apache.poi.ss.usermodel.Workbook;

public class getExcel {
	
	
//	public static void main(String[] args) {
//		InputStream inp;
//		try {
//			inp = new FileInputStream("C:\\Course\\新型软件开发原理与工具（本科）\\学期\\2014-2015(2)\\平时成绩登记表.xls");
//			System.out.println("11111");
//		Workbook wb = WorkbookFactory.create(inp);
//		
//	    Sheet sheet = wb.getSheetAt(0);
//	    
//	    Row row = sheet.getRow(6);
//	    
//	    if (row != null) {
//	    	
//	    	Cell nameCell = row.getCell(1); 
//	    	
//	    	System.out.println("11111"+nameCell.getStringCellValue());
//	    	
//	    }
//		 } 
//	    catch (FileNotFoundException e) {
//			System.out.println("FileNotFoundException");
//			e.printStackTrace();
//		} catch (EncryptedDocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	

	void getExcelFile()  {
		InputStream inp;
		try {
			inp = new FileInputStream("C:\\\\Course\\\\新型软件开发原理与工具（本科）\\\\学期\\\\2014-2015(2)\\\\平时成绩登记表.xls");
		
		Workbook wb = WorkbookFactory.create(inp);
		//inp.closed();
	    Sheet sheet = wb.getSheetAt(0);
	    for (int rowIndex = 6; rowIndex <= sheet.getLastRowNum(); rowIndex++) {  	
	    
	    Row row = sheet.getRow(rowIndex);
	    if (row != null) {
	    	Cell nameCell = row.getCell(0); 
	    	System.out.println(nameCell.getStringCellValue());
	    	
	    }
	    	
	    	}
	    
	    /*if (row == null) {
	    for (int rowIndex = 6; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	    	
	    }*/
	    /*Row row = sheet.getRow(2);
	    Cell cell = row.getCell(3);
	    if (cell == null)
	        cell = row.createCell(3);
	    cell.setCellType(CellType.STRING);
	    cell.setCellValue("a test");*/

	    // Write the output to a file
	    //FileOutputStream fileOut = new FileOutputStream("workbook.xls");
	   // wb.write(fileOut);
	   // fileOut.close();
	    } 
	    catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

