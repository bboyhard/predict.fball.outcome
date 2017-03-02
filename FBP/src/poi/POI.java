package poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import play.Play;

public class POI {

  public void createFile(String fileName, ArrayList<Play> listOfPlays)
      throws FileNotFoundException, IOException, IllegalArgumentException, IllegalAccessException {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet(fileName);
    Play dummyPlay = listOfPlays.get(1);

    int rowCount = 0;
    Cell cell;
    Row row = sheet.createRow(0);
    int columnCount = 0;
    cell = row.createCell(++columnCount);
    cell.setCellValue("Play#");

    for (String field : dummyPlay.gameInfoHeader()) {
      cell = row.createCell(++columnCount);
      cell.setCellValue(field);
    }

    for (String field : dummyPlay.downInfoHeader()) {
      cell = row.createCell(++columnCount);
      cell.setCellValue(field);
    }

    for (String field : dummyPlay.runInfoHeader()) {
      cell = row.createCell(++columnCount);
      cell.setCellValue(field);
    }

    for (String field : dummyPlay.fumbleInfoHeader()) {
      cell = row.createCell(++columnCount);
      cell.setCellValue(field);
    }
    
    for (String field : dummyPlay.passInfoHeader()) {
      cell = row.createCell(++columnCount);
      cell.setCellValue(field);
    }
    
    for (String field : dummyPlay.intInfoHeader()) {
      cell = row.createCell(++columnCount);
      cell.setCellValue(field);
    }
    
    for (String field : dummyPlay.kickOffInfoHeader()) {
      cell = row.createCell(++columnCount);
      cell.setCellValue(field);
    }

    rowCount = 0;
    for (Play play : listOfPlays) {
      row = sheet.createRow(++rowCount);

      LinkedHashMap<String, String> playMap = play.gameInfoToMap();
      playMap.putAll(play.downInfoToMap());
      playMap.putAll(play.runInfoToMap());
      playMap.putAll(play.fumbleInfoToMap());
      playMap.putAll(play.passInfoToMap());
      playMap.putAll(play.intInfoToMap());
      playMap.putAll(play.kickOffInfoToMap());

      columnCount = 0;

      cell = row.createCell(++columnCount);
      cell.setCellValue(play.getPlayNumber());

      for (String key : playMap.keySet()) {
        cell = row.createCell(++columnCount);
        cell.setCellValue(playMap.get(key));
      }

    }
    fileName = fileName + ".xlsx";

    try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
      workbook.write(outputStream);
    }

  }

  public void buildHeader() {

  }

}
