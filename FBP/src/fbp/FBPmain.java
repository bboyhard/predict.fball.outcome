package fbp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import parser.FBPParser;
import play.Play;

public class FBPmain {
  private static ArrayList<Play> listOfPlays = new ArrayList<Play>();
  
  public static void main(String[] args) throws IOException {
    getTheData();
    sendTheData();
  }
  
  private static void getTheData() throws IOException {
    //----ESPN websites----
//    String url = "http://www.espn.com/college-football/playbyplay?gameId=400869187"; // NEB vs Wyoming
    String urlTen = "http://www.espn.com/college-football/playbyplay?gameId=400876104";
    Document doc = Jsoup.connect(urlTen).get();
    
    FBPParser parser = new FBPParser();

    //----Local Development----
//    File input = new File("//SERVER\\documents\\GreenAnalytics\\predict.fball.outcome\\FBP\\Resources\\testHtml.html");
//    Document doc = Jsoup.parse(input, "UTF-8");

    Elements playInfo = doc.select("span.post-play");
    Elements driveInfo = doc.select("h3");
    
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
        
        listOfPlays.add(parser.ParsePlay(playString, driveString, playNumber, play));
    }  
    System.out.println("playNumber: " + playNumber);   
  }
  private static void sendTheData() {
    
//    for (Play play : listOfPlays) {
//      System.out.println(play.playToString());
//    }
    
    for (Play play : listOfPlays) {
      if (play.getTypeOfPlay() == "run")
        System.out.println(play.playToString());
    }
    
    

  }
}
