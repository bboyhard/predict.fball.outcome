package parser;

import play.Play;

public class FBPParser {

  public Play ParsePlay(String playString, String driveString, int playNumber, Play play) {
    
    getDownAndDistance(driveString, play);
    determineKindOfPlay(playString, play);
    
    


    return play;
  }

  private boolean getDownAndDistance(String driveString, Play play) {
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
  
  private String determineKindOfPlay(String playString, Play play) {
    playString = playString.replace("(", "");
    playString = playString.replace(")", "");
    playString = playString.replace("-", "");
    
    String [] playArray = playString.split(" ");
    
    play.setClock(playArray[0]);
    play.setQuarter(playArray[2]);
    
    
    
    return null;
  }
  

}
