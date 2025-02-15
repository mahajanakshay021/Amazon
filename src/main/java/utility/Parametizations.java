package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametizations {
	public static String getTestData(String sheetName,int row,int column) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\ABC\\eclipse-workspace1\\Amazons\\src\\test\\resources\\TestData.xlsx");
		
		return WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	} 

}
