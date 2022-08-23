package reusableMethods;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataSheet {
	
	
	String filePath;
	org.apache.poi.ss.usermodel.Sheet sh;
	
	public ExcelDataSheet (String sheetName)  {
		
		try {
			filePath = System.getProperty("user.dir")+PropertiesFile.getPropertyValue("testDataLocation");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

		File testDataFile = new File(filePath);
		Workbook book = null;
		try {
			book = WorkbookFactory.create(testDataFile);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	    sh = book.getSheet(sheetName);
		//sh.getRow(0).getCell(0).toString();
	}
	
	public HashMap<String, String> getTestDataInMap(int rowNumber) throws EncryptedDocumentException, IOException
	{
		
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNumber).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNumber).getCell(i).toString());
		}
		 
		return hm;
	}
	public int getRowCount() {
		
		return sh.getLastRowNum();
	}
	public int getColCount() {
		return sh.getRow(0).getLastCellNum();
		
	}

}
