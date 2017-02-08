package poi;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POI {
//Create Blank workbook
  XSSFWorkbook workbook = new XSSFWorkbook(); 
  //Create file system using specific name
  
  File file = new File ("createworkbook.xlsx");
  FileOutputStream out = new FileOutputStream(new File("createworkbook.xlsx"));
  
  
}
