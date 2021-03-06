package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import play.Play;

public class FBPParser {

  private Play play = new Play();
  private String playString;
  private String driveString;
  private String title;
  private String homeTeamScore;
  private String vistorTeamScore;

  public Play ParsePlay(String playString, String driveString, int playNumber, Play play, String title,
      String homeTeamScore, String vistorTeamScore) {
    this.play = play;
    this.playString = playString;
    this.driveString = driveString;
    this.title = title;
    this.homeTeamScore = homeTeamScore;
    this.vistorTeamScore = vistorTeamScore;

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
      case "penalty":
        getPenaltyPlayInfo();
        break;
      case "kickOff":
        getKickOffInfo();
        break;
      case "punt":
        getPuntInfo();
        break;
      case "fieldGoal":
        getFieldGoalInfo();
        break;
      case "timeOut":
        getTimeOutInfo();
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
    play.setVistorTeamScore(vistorTeamScore);
    play.setHomeTeamScore(homeTeamScore);

  }

  private void getDownAndDistance() {
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

    String[] dummyArray;

    if (playString.contains("1ST down"))
      play.setFirstDown(true);
    if (playString.contains("sacked")) {
      dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+)", "sacked by");
      play.setSackerFirstName(dummyArray[0]);
      play.setSackerLastName(dummyArray[1]);
    }
    if (playString.contains("fumble")) {
      processAFumble();
    } else {
      dummyArray = findAfter("\\s+([^\\s]+\\s[^\\s]+\\s+)", "run for");
      play.runPlay.setRusherFirstName(dummyArray[0]);
      play.runPlay.setRusherLastName(dummyArray[1]);

      if (playString.contains("no gain"))
        play.runPlay.setYdsRushed("0");

      Pattern pattern = Pattern.compile("loss of\\W+(\\w+)");
      Matcher matcher = pattern.matcher(playString);
      if (matcher.find())
        play.runPlay.setYdsRushed("-" + matcher.group(1));

      else {
        pattern = Pattern.compile(Pattern.quote("for ") + "(.*?)" + Pattern.quote(" yds"));
        matcher = pattern.matcher(playString);
        if (matcher.find()) {
          play.runPlay.setYdsRushed(matcher.group(1));
        }
      }
    }
  }

  private void getPenaltyPlayInfo() {
    playString = removeUnwantedWords();

    String[] dummyArray;
    
    if (playString.contains("fumble"))
      processAFumble();
  }

  private void getTimeOutInfo() {
    //dont care timeouts dont effect the game.
  }

  private void getPuntInfo() {
    playString = removeUnwantedWords();

    String[] dummyArray;
    
    if (playString.contains("fumble"))
      processAFumble();
    
    dummyArray = findAfter("\\s+([^\\s]+\\s[^\\s]+\\s+)", "punt for");
    play.puntPlay.setPunterFirstName(dummyArray[0]);
    play.puntPlay.setPunterLastName(dummyArray[1]);

    dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+)", "punt for");
    play.puntPlay.setYdsPunted(dummyArray[0]);

    dummyArray = findAfter("\\s+([^\\s]+\\s[^\\s]+\\s+)", "returns for");
    play.puntPlay.setRtnFirstName(dummyArray[0]);
    play.puntPlay.setRtnLastName(dummyArray[1]);

    dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+)", "returns for");
    play.puntPlay.setRtnYds(dummyArray[0]);

  }

  private void getFieldGoalInfo() {
    playString = removeUnwantedWords();

    String[] dummyArray;
    
    if (playString.contains("fumble"))
      processAFumble();
    
    dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+[^\\s]+)", " yd FG");
    play.puntPlay.setPunterFirstName(dummyArray[0]);
    play.puntPlay.setPunterLastName(dummyArray[1]);

    dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+)", "punt for");
    play.puntPlay.setYdsPunted(dummyArray[0]);
  }

  private void getKickOffInfo() {
    playString = removeUnwantedWords();

    String[] dummyArray;

    if (playString.contains("fumble"))
      processAFumble();

    dummyArray = findAfter("\\s+([^\\s]+\\s[^\\s]+\\s+)", "kickoff for");
    play.kickOff.setKickerFirstName(dummyArray[0]);
    play.kickOff.setKickerLastName(dummyArray[1]);

    dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+)", "kickoff for");
    play.kickOff.setYdsKicked(dummyArray[0]);

    dummyArray = findAfter("\\s+([^\\s]+\\s[^\\s]+\\s+)", "return for");
    play.kickOff.setRecFirstName(dummyArray[0]);
    play.kickOff.setRecLastName(dummyArray[1]);

    dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+)", "return for");
    play.kickOff.setRtnYds(dummyArray[0]);

  }

  private void getPassPlayInfo() {
    playString = removeUnwantedWords();
    String[] dummyArray;
    Pattern pattern;
    Matcher matcher;

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

      dummyArray = findAfter("\\s+([^\\s]+\\s[^\\s]+\\s+)", "pass incomplete to");
      play.passPlay.setPasserFirstName(dummyArray[0]);
      play.passPlay.setPasserLastName(dummyArray[1]);

    } else if (playString.contains("pass complete to")) {
      play.passPlay.setIsComplete("true");

      dummyArray = findAfter("\\s+([^\\s]+\\s[^\\s]+\\s+)", "pass complete to");
      play.passPlay.setPasserFirstName(dummyArray[0]);
      play.passPlay.setPasserLastName(dummyArray[1]);

      dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+)", "pass complete to");
      play.passPlay.setRecFirstName(dummyArray[0]);
      play.passPlay.setRecLastName(dummyArray[1]);

      dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+)", "pass complete to");
      play.passPlay.setRecFirstName(dummyArray[0]);
      play.passPlay.setRecLastName(dummyArray[1]);

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
    if (playString.contains("fumble"))
      processAFumble();

    if (playString.contains("TD")) {
      dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+)", "for a TD");
      play.interception.setDefBackFirstName(dummyArray[0]);
      play.interception.setDefBackLastName(dummyArray[1]);
      dummyArray = findBefore("\\s+([^\\s]+)", "return for");
      play.interception.setRtnYds(dummyArray[0]);
    } else if (playString.contains("no gain")) {
      dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+)", "pass intercepted");
      play.interception.setDefBackFirstName(dummyArray[0]);
      play.interception.setDefBackLastName(dummyArray[1]);
      play.interception.setRtnYds("0");
    } else if (playString.contains("loss")) {
      dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+)", "pass intercepted");
      play.interception.setDefBackFirstName(dummyArray[0]);
      play.interception.setDefBackLastName(dummyArray[1]);
    } else {
      dummyArray = findBefore("\\s+([^\\s]+\\s[^\\s]+\\s+)", "pass intercepted");
      play.interception.setDefBackFirstName(dummyArray[0]);
      play.interception.setDefBackLastName(dummyArray[1]);
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
    else if (playString.contains("run") || playString.contains("sacked"))
      play.setTypeOfPlay("run");
    else if (playString.contains("pass"))
      play.setTypeOfPlay("pass");
    else if (playString.contains("punt"))
      play.setTypeOfPlay("punt");
    else if (playString.contains("Penalty") || playString.contains("PENALTY"))
      play.setTypeOfPlay("penalty");
    else if (playString.contains("FG"))
      play.setTypeOfPlay("fieldGoal");
    else if (playString.contains("Timeout"))
      play.setTypeOfPlay("timeOut");

    play.setTD(false);
    if (playString.contains("TD")) {
      play.setTD(true);
      if (playString.contains("KICK"))
        play.setExtraPoint(true);
    }

  }

}
