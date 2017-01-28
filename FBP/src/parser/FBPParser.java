package parser;

import play.Play;

public class FBPParser {

  public Play ParsePlay(String playString) {
    Play play = new Play();

    getDownAndDistance();
    
    String[] playArray = playString.split(" ");

    return play;
  }

  private boolean getDownAndDistance() {
    boolean rval = false;

    return rval;
  }
}
