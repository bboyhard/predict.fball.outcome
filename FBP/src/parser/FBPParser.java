package parser;

import play.Play;

public class FBPParser {

  private Play play = new Play();
  private String playString;
  private String driveString;
  
  public Play ParsePlay(String playString, String driveString, int playNumber, Play play) {
    this.play = play;
    this.playString = playString;
    this.driveString = driveString;
   
    
    getDownAndDistance();
    getPlayFlagsAndTypeOfPlay();
    
    return play;
  }

  private boolean getDownAndDistance() {
    boolean rval = false;

    if (!driveString.isEmpty()) {
      String [] driveArray = driveString.split(" ");
      play.downInfo.setDown(driveArray[0]);
      play.downInfo.setDistance(driveArray[2]);
      
      int test = driveArray.length;
      
      if (test == 5) {
        
      } else {
        play.downInfo.setSideOfField(driveArray[4]);
        play.downInfo.setYardLine(driveArray[5]);
      }

    }
    return rval;
  }
  
  private void getPlayFlagsAndTypeOfPlay() {
    playString = playString.replace("(", "");
    playString = playString.replace(")", "");
    playString = playString.replace("-", "");
    
    String[] playArray = playString.split(" ");
    
    play.setClock(playArray[0]);
    play.setQuarter(playArray[2]);
    
    if (playString.contains("kickoff"))
      play.setTypeOfPlay("kickOff");
    else if (playString.contains("run"))
      play.setTypeOfPlay("run");
    else if (playString.contains("pass"))
      play.setTypeOfPlay("pass");
    else if (playString.contains("punt"))
      play.setTypeOfPlay("punt");
    else if (playString.contains("penalty"))
      play.setTypeOfPlay("penalty");
    else if (playString.contains("FG"))
      play.setTypeOfPlay("fieldGoal");
   
    play.setTD(false);
    if (playString.contains("TD")) {
      play.setTD(true);
      if (playString.contains("KICK"))
        play.extraPoint.setGood(true);
    }
  }
  

}
