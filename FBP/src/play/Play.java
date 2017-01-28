package play;

public class Play {
  public DownInfo downInfo = new DownInfo();
  int playNumber;
  String quarter; 
  String clock;
  
  public int getPlayNumber() {
    return playNumber;
  }

  public void setPlayNumber(int playNumber) {
    this.playNumber = playNumber;
  }
  
  public String getQuarter() {
    return quarter;
  }

  public void setQuarter(String quarter) {
    this.quarter = quarter;
  }

  public String getClock() {
    return clock;
  }

  public void setClock(String clock) {
    this.clock = clock;
  }

  public String playToString() {
    String playString = null;

    playString = playNumber + ":" + "(" + clock + "-" + quarter + ") ";
    playString = playString + downInfo.down + " and " + downInfo.distance + " on " + downInfo.sideOfField + " " + downInfo.yardLine; 
    
    return playString;
  }
}