package poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

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

    int rowCount = 0;

    Row row = sheet.createRow(0);
    int columnCount = 0;
    Cell cell = row.createCell(++columnCount);
    cell.setCellValue("PlayNumber");
    cell = row.createCell(++columnCount);
    cell.setCellValue("Clock");
    cell = row.createCell(++columnCount);
    cell.setCellValue("Quarter");
    cell = row.createCell(++columnCount);
    cell.setCellValue("PlayType");
    cell = row.createCell(++columnCount);
    cell.setCellValue("DistanceToGo");
    cell = row.createCell(++columnCount);
    cell.setCellValue("Down");
    cell = row.createCell(++columnCount);
    cell.setCellValue("SideOfField");
    cell = row.createCell(++columnCount);
    cell.setCellValue("YardLine");
    cell = row.createCell(++columnCount);
    cell.setCellValue("RushFirstName");
    cell = row.createCell(++columnCount);
    cell.setCellValue("RushLastName");
    cell = row.createCell(++columnCount);
    cell.setCellValue("YardsRushed");
    cell = row.createCell(++columnCount);
    cell.setCellValue("FumbleForcerFirstName");
    cell = row.createCell(++columnCount);
    cell.setCellValue("FumbleForcerLastName");
    cell = row.createCell(++columnCount);
    cell.setCellValue("FumblerFirstName");
    cell = row.createCell(++columnCount);
    cell.setCellValue("FumblerLastName");

    rowCount = 0;
    for (Play play : listOfPlays) {
      row = sheet.createRow(++rowCount);

      columnCount = 0;

      cell = row.createCell(++columnCount);

      cell.setCellValue(play.getPlayNumber());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.getClock());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.getQuarter());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.getTypeOfPlay());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.downInfo.getDistance());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.downInfo.getDown());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.downInfo.getSideOfField());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.downInfo.getYardLine());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.runPlay.getRusherFirstName());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.runPlay.getRusherLastName());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.runPlay.getYdsRushed());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.fumble.getForcerFirstName());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.fumble.getForcerLastName());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.fumble.getFumblerFirstName());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.fumble.getFumblerLastName());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.fumble.getRecoverFirstName());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.fumble.getRecoverLastName());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.fumble.getRtnYds());
      cell = row.createCell(++columnCount);
      cell.setCellValue(play.fumble.getTeamRecovered());
      cell = row.createCell(++columnCount);

    }
    fileName = fileName + ".xlsx";

    try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
      workbook.write(outputStream);
    }

  }

  public void buildHeader() {

  }

}
