package play;

public class Play {
  public DownInfo downInfo = new DownInfo();
  public KickOff kickOff = new KickOff();
  public ExtraPoint extraPoint = new ExtraPoint();
  public RunPlay runPlay = new RunPlay();
  public PassPlay passPlay = new PassPlay();
  public PuntPlay puntPlay = new PuntPlay();
  public Penalty penalty = new Penalty();
  public FieldGoal fieldGoal = new FieldGoal();
  
  int playNumber;
  String quarter; 
  String clock;
  String typeOfPlay;
  boolean isTD;
  boolean isPenalty;
  boolean isFumble;
  boolean isFirstDown;
  
  public boolean isPenalty() {
    return isPenalty;
  }

  public void setPenalty(boolean isPenalty) {
    this.isPenalty = isPenalty;
  }

  public boolean isFumble() {
    return isFumble;
  }

  public void setFumble(boolean isFumble) {
    this.isFumble = isFumble;
  }

  public boolean isFirstDown() {
    return isFirstDown;
  }

  public void setFirstDown(boolean isFirstDown) {
    this.isFirstDown = isFirstDown;
  }

  public boolean isTD() {
    return isTD;
  }

  public void setTD(boolean isTD) {
    this.isTD = isTD;
  }

  public String getTypeOfPlay() {
    return typeOfPlay;
  }

  public void setTypeOfPlay(String typeOfPlay) {
    this.typeOfPlay = typeOfPlay;
  }

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
    playString = playString + " - Play Type: " + typeOfPlay;
    if(isTD) {
      playString = playString + " -Touchdown!!!-";
      if(extraPoint.isGood)
        playString = playString + " ExtraPoint Good";
    }
        
    
    return playString;
  }
}