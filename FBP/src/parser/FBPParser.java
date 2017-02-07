package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    if (play.getTypeOfPlay() != null)
    switch (play.getTypeOfPlay()) {
    case "run":
        getRunPlayInfo();
        break;
    case "pass":
        break;
    default: 
        break;
    }

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
  
  private String removeUnwantedWords() {
    if (playString.contains("Jr")) {
      play.setJunior(true);
      playString = playString.replace(" Jr.", "");
    } else if (playString.contains("II"))  {
      playString = playString.replace(" II", "");
    }
    if (playString.contains(","))
      playString = playString.replace(",", "");
    
    return playString;
  }
  
  private void getRunPlayInfo() {
    playString = removeUnwantedWords();
    String[] playArray = playString.split(" ");
    
    if (playString.contains("1ST down"))
      play.setFirstDown(true);
    if (playString.contains("Penalty")) {
      // process penalty
    } else if (playString.contains("fumble")){ 
      processAFumble();
    } else {
        play.runPlay.setRusherFirstName(playArray[2]);
        play.runPlay.setRusherLastName(playArray[3]);
        if (playString.contains("no gain"))
          play.runPlay.setYdsRushed("0");
        else if (playString.contains("for a loss"))
          play.runPlay.setYdsRushed("-"+playArray[9]);
        else
          play.runPlay.setYdsRushed(playArray[6]);
    }  
  }
  
  private void processAFumble() {
    String fumbler = null;
    String recoverer = null;
    String forcer = null;
    String returnYds = null;
    String find = "";
    
    find = "fumbled";
    Pattern pattern = Pattern.compile("\\s+([^\\s]+\\s[^\\s]+\\s+)"+find);
    Matcher matcher = pattern.matcher(playString);
    if (matcher.find()) {
      fumbler = matcher.group(1);
      String[] fumblerName = fumbler.split(" ");
      play.fumble.setFumblerFirstName(fumblerName[0]);
      play.fumble.setFumblerLastName(fumblerName[1]);
    }
    
    find = "recovered by";
    pattern = Pattern.compile(find+"\\s+([^\\s]+\\s[^\\s]+\\s+[^\\s]+)");
    matcher = pattern.matcher(playString);
    if (matcher.find()) {
      recoverer = matcher.group(1);
      String[] recovererName = recoverer.split(" ");
      play.fumble.setTeamRecovered(recovererName[0]);
      play.fumble.setRecoverFirstName(recovererName[1]);
      play.fumble.setRecoverLastName(recovererName[2]);
    }
    
    find = "forced by";
    pattern = Pattern.compile(find+"\\s+([^\\s]+\\s[^\\s]+)");
    matcher = pattern.matcher(playString);
    if (matcher.find()) {
      forcer = matcher.group(1);
      String[] forcerName = forcer.split(" ");
      play.fumble.setForcerFirstName(forcerName[0]);
      play.fumble.setForcerLastName(forcerName[1]);
    }
    
    find = "return for";
    pattern = Pattern.compile(find+"\\s+([^\\s]+)");
    matcher = pattern.matcher(playString);
    if (matcher.find()) {
      returnYds = matcher.group(1);
      play.fumble.setRtnYds(returnYds);
    }
  
  }
  
  private void getPlayFlagsAndTypeOfPlay() {
    playString = playString.replace("(", "");
    playString = playString.replace(")", "");
    playString = playString.replace(" -", "");
    
    String[] playArray = playString.split(" ");
    
    play.setClock(playArray[0]);
    play.setQuarter(playArray[1]);
    
    if (playString.contains("kickoff"))
      play.setTypeOfPlay("kickOff");
    else if (playString.contains("run"))
      play.setTypeOfPlay("run");
    else if (playString.contains("pass"))
      play.setTypeOfPlay("pass");
    else if (playString.contains("punt"))
      play.setTypeOfPlay("punt");
    else if (playString.contains("Penalty"))
      play.setTypeOfPlay("penalty");
    else if (playString.contains("FG"))
      play.setTypeOfPlay("fieldGoal");
    else if (playString.contains("sacked"))
      play.setTypeOfPlay("sacked");
    else if (playString.contains("Timeout"))
      play.setTypeOfPlay("timeOut");
    else if (playString.contains("End of"))
      play.setTypeOfPlay("endOfQuater");
   
    play.setTD(false);
    if (playString.contains("TD")) {
      play.setTD(true);
      if (playString.contains("KICK"))
        play.extraPoint.setGood(true);
    }
    
  }
  

}
