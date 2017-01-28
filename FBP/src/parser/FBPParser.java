package parser;

import play.Play;

public class FBPParser {

  public Play ParsePlay(String playString, String driveString, int playNumber, Play play) {
    
    getDownAndDistance(driveString, play);
    


    return play;
  }

  private boolean getDownAndDistance(String driveString, Play play) {
    boolean rval = false;

    if (!driveString.isEmpty()) {
      String [] driveArray = driveString.split(" ");
      play.downInfo.setDown(driveArray[0]);
      play.downInfo.setDistance(driveArray[2]);
      
      int test = driveArray.length;
      
      if ( test > 4) {
      
      play.downInfo.setYardLine(driveArray[4]);
      }
      rval = true;
    }
      
    
    return rval;
  }
  

}
