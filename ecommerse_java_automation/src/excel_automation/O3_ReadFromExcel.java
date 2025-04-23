package excel_automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class O3_ReadFromExcel {

	public static String getData(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException
	{
		String value = null;
		// where is the excel file. 
		String rootFolder = System.getProperty("user.dir");
		File f = new File(rootFolder +"\\project_documents.xlsx");
		// inside the file. 
		FileInputStream fis = new FileInputStream(f);
		
		// create the work book. 
		Workbook wb = WorkbookFactory.create(fis);
		
		value = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		
        return value;
	}

}