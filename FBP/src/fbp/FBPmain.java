package fbp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import parser.FBPParser;
import play.Play;
import poi.POI;

public class FBPmain {
  private static ArrayList<Play> listOfPlays = new ArrayList<Play>();
  private static String title;

//  public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException {
//    long startTime = System.currentTimeMillis();
//
//    getTheData();
//    sendTheData();
//
//    long endTime = System.currentTimeMillis();
//    long totalTime = endTime - startTime;
//    System.out.println("Run Time: " + totalTime / 1000d + "seconds");
    
//    new Panel();  
//  }
  
  public void startTheProcess(String website, String fileLocation) throws IOException, IllegalArgumentException, IllegalAccessException {
    getTheData(website, fileLocation);
    sendTheData(fileLocation);
  }

  private static void getTheData(String website, String fileLocation) throws IOException {
    // ----ESPN websites----
//    String url = "http://www.espn.com/college-football/playbyplay?gameId=400869187"; //
//    Document doc = Jsoup.connect(url).get();
//     String urlTen ="http://www.espn.com/college-football/playbyplay?gameId=400876104";
//     Document doc = Jsoup.connect(urlTen).get();
    Document doc = Jsoup.connect(website).get();
    FBPParser parser = new FBPParser();

    // ----Local Development----
    // File input = new
    // File("//SERVER\\documents\\GreenAnalytics\\predict.fball.outcome\\FBP\\Resources\\fumble.html");
    // Document doc = Jsoup.parse(input, "UTF-8");

    Elements playInfo = doc.select("span.post-play");
    Elements driveInfo = doc.select("h3");

    Elements gameDrives = doc.select("li.accordion-item");

    String homeTeamScore = "0";
    String vistorTeamScore = "0";

    title = doc.title();

    int playNumber = 0;

    for (Element element : gameDrives) {
      playInfo = element.select("span.post-play");
      driveInfo = element.select("h3");

      Elements homeScore = element.select("span.home");
      Elements vistorScore = element.select("span.away");

      String hscore = homeScore.text();
      
      
      String vscore = vistorScore.text();

      String[] homeScoreArray = hscore.split("[^0-9]+");
      String[] vistorScoreArray = vscore.split("[^0-9]+");

      // Espn has the wrong tags for the home and away team for scores.
      if (homeScoreArray.length == 2)
        vistorTeamScore = homeScoreArray[1];
      if (vistorScoreArray.length == 2)
        homeTeamScore = vistorScoreArray[1];

      Iterator<?> driveIt = driveInfo.iterator();
      Iterator<?> playIt = playInfo.iterator();

      while (playIt.hasNext() && driveIt.hasNext()) {
        Play play = new Play();
        playNumber++;
        play.setPlayNumber(playNumber);
        Element driveElement = (Element) driveIt.next();
        Element playElement = (Element) playIt.next();

        String driveString = driveElement.text();
        String playString = playElement.text();

        if (!playString.contains("End of"))
          listOfPlays
              .add(parser.ParsePlay(playString, driveString, playNumber, play, title, homeTeamScore, vistorTeamScore));
      }
    }

  }

  private static void sendTheData(String fileLocation)
      throws FileNotFoundException, IOException, IllegalArgumentException, IllegalAccessException {

    POI poi = new POI();

    if (title.isEmpty())
      title = "No Title";

    poi.createFile(title, listOfPlays, fileLocation);

  }
}
