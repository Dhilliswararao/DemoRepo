package CucumberFramework.stepFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceloperations {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\aa78137\\Desktop\\Age Validation.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws	= wb.getSheet("Sheet1");

		// Count the number of rows in the sheet
		int rowcount = ws.getLastRowNum();
		System.out.println("number of Rows in the sheet is :"+rowcount);
		
		// Count the number of columns in the sheet
		int colcount = ws.getRow(1).getLastCellNum();
		System.out.println("number of Columns in the sheet is :"+ colcount);
		
		// To iterate through sheet 
		
		for(int i=1; i<=rowcount; i++)
		{
			XSSFCell celldata = ws.getRow(1).getCell(1);
			String celltext;
						
			// To get cell values
			
			switch(celldata.getCellType()) {
		    case STRING:
		    	celltext=celldata.getStringCellValue();
		        break;
		    case NUMERIC:
		    	celltext =String.valueOf(celldata.getNumericCellValue());
		        break;
		    case BLANK:
		    	celltext="";
		       
			
			/*
			 * if(cell.getCellType().STRING) { celltext = cell.getStringCellValue(); } else
			 * if(cell.getCellType()== cell.CELL_TYPE_NUMERIC) { celltext =
			 * String.valueOf(cell.getNumericCellValue());
			 * 
			 * } else if(cell.getCellType()==cell.CELL_TYPE_BLANK) { celltext = "";
			 * 
			 * }
			 */
			
			if(Double.parseDouble(celltext)>=18)
			{
				ws.getRow(i).getCell(2).setCellValue("Major");
			}
			else
			{
			 ws.getRow(i).getCell(2).setCellValue("Minor");
			}
			fis.close();
			default:
				break;
			
		}
	
		//Open excel to write data in to work book
		FileOutputStream fos= new FileOutputStream("C:\\Users\\aa78137\\Desktop\\Age Validation.xlsx");
	
		//To write data
	wb.write(fos);
	// To close output stream
	fos.close();
	}
	}
}
	
