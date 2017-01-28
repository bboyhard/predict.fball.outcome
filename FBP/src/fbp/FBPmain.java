package fbp;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import parser.FBPParser;
import play.Play;

public class FBPmain {

  public static void main(String[] args) throws IOException {
    
    Play play = new Play();
    String url = "http://www.espn.com/college-football/playbyplay?gameId=400869187"; // NEB vs Wyoming
    String urlTen = "http://www.espn.com/college-football/playbyplay?gameId=400876104";
    FBPParser parser = new FBPParser();
    
    Document doc = Jsoup.connect(urlTen).get();
    
      Element test = doc.getElementById("gamepackage-drives-wrap");
    
    Elements playInfo = doc.select("span.post-play");
    
    Elements driveInfo = test.getElementsByTag("h3");
    
    int playNumber = 0;
    for (Element inputElement : playInfo) {   
        playNumber++;
        String line = "Nothing";
        if (inputElement.attr("li") != null) {
          if (inputElement.getElementsByTag("h3") != null)
          line = inputElement.text();
        }
        
        String playString = inputElement.text();
        
        parser.ParsePlay(playString);
           
        System.out.println(line);  
    }  
    int testInt = 0;
    System.out.println("playNumber: " + playNumber);
  }

}
