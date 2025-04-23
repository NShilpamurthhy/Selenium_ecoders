package homepagescenarios_shilpa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class O3_ReadFrohhfmExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String result = getData("Sheet1", 0 , 0);
		System.out.println(result);
	}

	public static String getData(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException
	{
		String value = null;
		// where is the excel file. 
		String rootFolder = System.getProperty("user.dir");
		
		System.out.println("Working Directory: " + System.getProperty("user.dir"));
		String excelSheetPath=rootFolder +"//project_documents.xlsx";
		
		System.out.println(excelSheetPath);
		// inside the file. 
		
		try
		{
			File f = new File(excelSheetPath);
			System.out.println("Does file exist? " + f.exists()); 
			FileInputStream fis = new FileInputStream(f);
			// create the work book. 
			Workbook wb = WorkbookFactory.create(fis);
			
			org.apache.poi.ss.usermodel.Sheet sh  = wb.getSheet(sheetName);
			value = sh.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	
        return value;
	}

}
