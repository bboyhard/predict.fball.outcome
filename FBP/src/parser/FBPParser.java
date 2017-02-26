package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import play.Play;

public class FBPParser {

  private Play play = new Play();
  private String playString;
  private String driveString;
  private String title;

  public Play ParsePlay(String playString, String driveString, int playNumber, Play play, String title) {
    this.play = play;
    this.playString = playString;
    this.driveString = driveString;
    this.title = title;

    getTeamsAndScore();
    getDownAndDistance();
    getPlayFlagsAndTypeOfPlay();

    if (play.getTypeOfPlay() != null)
      switch (play.getTypeOfPlay()) {
      case "run":
        getRunPlayInfo();
        break;
      case "pass":
        getPassPlayInfo();
        break;
      default:
        break;
      }

    return play;
  }

  private void getTeamsAndScore() {
    if (title.contains(","))
      title = title.replace(",", "");
    if (!title.isEmpty()) {
      String[] titleArray = title.split(" ");
      play.setVistorTeam(titleArray[0]);
      play.setHomeTeam(titleArray[2]);
      play.setGameMonth(titleArray[6]);
      play.setGameDay(titleArray[7]);
      play.setGameYear(titleArray[8]);
    }
  }

  private boolean getDownAndDistance() {
    boolean rval = false;

    if (!driveString.isEmpty()) {
      String[] driveArray = driveString.split(" ");
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
    } else if (playString.contains("II")) {
      playString = playString.replace(" II", "");
    } else if (playString.contains("III")) {
      playString = playString.replace(" III", "");
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
    } else if (playString.contains("fumble")) {
      processAFumble();
    } else {
      play.runPlay.setRusherFirstName(playArray[2]);
      play.runPlay.setRusherLastName(playArray[3]);
      if (playString.contains("no gain"))
        play.runPlay.setYdsRushed("0");
      else if (playString.contains("for a loss"))
        play.runPlay.setYdsRushed("-" + playArray[9]);
      else
        play.runPlay.setYdsRushed(playArray[6]);
    }
  }

  private void getPassPlayInfo() {
    playString = removeUnwantedWords();
    String passer = null;
    String receiver = null;
    String find = "";

    if (playString.contains("1ST down"))
      play.setFirstDown(true);
    if (playString.contains("fumble")) {
      processAFumble();
    } else if (playString.contains("intercepted")) {
      play.passPlay.setIsComplete("false");
      processAInterception();
    }

    else if (playString.contains("pass incomplete to")) {
      play.passPlay.setIsComplete("false");
      find = "pass incomplete to";
      Pattern pattern = Pattern.compile("\\s+([^\\s]+\\s[^\\s]+\\s+)" + find);
      Matcher matcher = pattern.matcher(playString);
      if (matcher.find()) {
        passer = matcher.group(1);
        String[] passerName = passer.split(" ");
        play.passPlay.setPasserFirstName(passerName[0]);
        play.passPlay.setPasserLastName(passerName[1]);
      }

    } else if (playString.contains("pass complete to")) {
      play.passPlay.setIsComplete("true");

      find = "pass complete to";
      Pattern pattern = Pattern.compile("\\s+([^\\s]+\\s[^\\s]+\\s+)" + find);
      Matcher matcher = pattern.matcher(playString);
      if (matcher.find()) {
        passer = matcher.group(1);
        String[] passerName = passer.split(" ");
        play.passPlay.setPasserFirstName(passerName[0]);
        play.passPlay.setPasserLastName(passerName[1]);
      }

      find = "pass complete to";
      pattern = Pattern.compile(find + "\\s+([^\\s]+\\s[^\\s]+)");
      matcher = pattern.matcher(playString);
      if (matcher.find()) {
        receiver = matcher.group(1);
        String[] receiverName = receiver.split(" ");
        play.passPlay.setRecFirstName(receiverName[0]);
        play.passPlay.setRecLastName(receiverName[1]);

        pattern = Pattern.compile(Pattern.quote("for ") + "(.*?)" + Pattern.quote(" yds"));
        matcher = pattern.matcher(playString);
        if (matcher.find()) {
          play.passPlay.setYards(matcher.group(1));
        }

        if (playString.contains("no gain"))
          play.passPlay.setYards("0");

        pattern = Pattern.compile("loss of\\W+(\\w+)");
        matcher = pattern.matcher(playString);
        if (matcher.find())
          play.passPlay.setYards("-" + matcher.group(1));
      }
    }
  }

  private void processAFumble() {
    String[] dummyArray;

    dummyArray = findAfter("\\s+([^\\s]+\\s[^\\s]+\\s+)", "fumbled");
    play.fumble.setFumblerFirstName(dummyArray[0]);
    play.fumble.setFumblerLastName(dummyArray[1]);

    dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+[^\\s]+)", "recovered by");
    play.fumble.setTeamRecovered(dummyArray[0]);
    play.fumble.setRecoverFirstName(dummyArray[1]);
    play.fumble.setRecoverLastName(dummyArray[2]);

    dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+)", "forced by");
    play.fumble.setForcerFirstName(dummyArray[0]);
    play.fumble.setForcerLastName(dummyArray[1]);

    dummyArray = findBefore("\\s+([^\\s]+)", "return for");
    play.fumble.setRtnYds(dummyArray[0]);

  }

  private void processAInterception() {
    
    String[] dummyArray;

    dummyArray = findAfter("\\s+([^\\s]+\\s[^\\s]+\\s+)", "pass intercepted");
    play.passPlay.setPasserFirstName(dummyArray[0]);
    play.passPlay.setPasserLastName(dummyArray[1]);
    
    dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+)", "pass intercepted");
    play.interception.setDefBackFirstName(dummyArray[0]);
    play.interception.setDefBackLastName(dummyArray[1]);
    
    if (playString.contains("TD")) {
      
    } else if (playString.contains("no gain")) {
      
    } else if (playString.contains("los")) {
      
    } else {
      dummyArray = findBefore("\\s+([^\\s]+)", "return for");
      play.interception.setRtnYds(dummyArray[0]);
    }
    

  }

  private String[] findAfter(String stringPattern, String find) {
    String[] nameArray = new String[] { "", "" };
    Pattern pattern = Pattern.compile(stringPattern + find);
    Matcher matcher = pattern.matcher(playString);
    if (matcher.find()) {
      String passer = matcher.group(1);
      nameArray = passer.split(" ");
    }

    return nameArray;
  }

  private String[] findBefore(String stringPattern, String find) {
    String[] nameArray = new String[] { "", "", "" };
    Pattern pattern = Pattern.compile(find + stringPattern);
    Matcher matcher = pattern.matcher(playString);
    if (matcher.find()) {
      String passer = matcher.group(1);
      nameArray = passer.split(" ");
    }

    return nameArray;
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
