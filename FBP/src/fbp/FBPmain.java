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

  public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException {
    long startTime = System.currentTimeMillis();
    
    
    getTheData();
    sendTheData();
    
    
    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("Run Time: "+totalTime/1000d+"seconds");
  }

  private static void getTheData() throws IOException {
    // ----ESPN websites----
     String url ="http://www.espn.com/college-football/playbyplay?gameId=400869187"; //
    // NEB vs Wyoming
     Document doc = Jsoup.connect(url).get();
//    String urlTen = "http://www.espn.com/college-football/playbyplay?gameId=400876104";
//    Document doc = Jsoup.connect(urlTen).get();

    FBPParser parser = new FBPParser();

    // ----Local Development----
    // File("//SERVER\\documents\\GreenAnalytics\\predict.fball.outcome\\FBP\\Resources\\fumble.html");
    // Document doc = Jsoup.parse(input, "UTF-8");

    Elements playInfo = doc.select("span.post-play");
    Elements driveInfo = doc.select("h3");

    title = doc.title();

    Iterator<?> driveIt = driveInfo.iterator();
    Iterator<?> playIt = playInfo.iterator();

    int playNumber = 0;
    while (playIt.hasNext() && driveIt.hasNext()) {
      Play play = new Play();
      playNumber++;
      play.setPlayNumber(playNumber);
      Element driveElement = (Element) driveIt.next();
      Element playElement = (Element) playIt.next();

      String driveString = driveElement.text();
      String playString = playElement.text();

      listOfPlays.add(parser.ParsePlay(playString, driveString, playNumber, play, title));
    }
    
  }

  private static void sendTheData()
      throws FileNotFoundException, IOException, IllegalArgumentException, IllegalAccessException {

    POI poi = new POI();

    if (title.isEmpty())
      title = "No Title";

    poi.createFile(title, listOfPlays);

  }
}
