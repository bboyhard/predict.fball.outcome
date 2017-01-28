package play;

public class Play {
  public DownInfo downInfo = new DownInfo();


  public String playToString() {
    String playString = null;
    
    playString = downInfo.down + " and " + downInfo.distance; 
    
    return playString;
  }
}