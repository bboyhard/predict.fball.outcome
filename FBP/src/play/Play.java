package play;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Play {
  public DownInfo downInfo = new DownInfo();
  public KickOff kickOff = new KickOff();
  public RunPlay runPlay = new RunPlay();
  public PassPlay passPlay = new PassPlay();
  public PuntPlay puntPlay = new PuntPlay();
  public Penalty penalty = new Penalty();
  public FieldGoal fieldGoal = new FieldGoal();
  public Fumble fumble = new Fumble();
  public Interception interception = new Interception();

  int playNumber;
  String quarter;
  String clock;
  String typeOfPlay;
  String vistorTeam;
  String homeTeam;
  String gameMonth;
  String gameDay;
  String gameYear;
  String vistorTeamScore;
  String homeTeamScore;
  String sackerFirstName;
  String sackerLastName;
  boolean isTD;
  boolean extraPoint;
  boolean twoPointConversion;
  boolean isPenalty;
  boolean isFirstDown;
  boolean isJunior;

  public String getSackerFirstName() {
    return sackerFirstName;
  }

  public void setSackerFirstName(String sackerFirstName) {
    this.sackerFirstName = sackerFirstName;
  }

  public String getSackerLastName() {
    return sackerLastName;
  }

  public void setSackerLastName(String sackerLastName) {
    this.sackerLastName = sackerLastName;
  }

  public DownInfo getDownInfo() {
    return downInfo;
  }

  public void setDownInfo(DownInfo downInfo) {
    this.downInfo = downInfo;
  }

  public KickOff getKickOff() {
    return kickOff;
  }

  public void setKickOff(KickOff kickOff) {
    this.kickOff = kickOff;
  }

  public RunPlay getRunPlay() {
    return runPlay;
  }

  public void setRunPlay(RunPlay runPlay) {
    this.runPlay = runPlay;
  }

  public PassPlay getPassPlay() {
    return passPlay;
  }

  public void setPassPlay(PassPlay passPlay) {
    this.passPlay = passPlay;
  }

  public PuntPlay getPuntPlay() {
    return puntPlay;
  }

  public void setPuntPlay(PuntPlay puntPlay) {
    this.puntPlay = puntPlay;
  }

  public Penalty getPenalty() {
    return penalty;
  }

  public void setPenalty(Penalty penalty) {
    this.penalty = penalty;
  }

  public FieldGoal getFieldGoal() {
    return fieldGoal;
  }

  public void setFieldGoal(FieldGoal fieldGoal) {
    this.fieldGoal = fieldGoal;
  }

  public Fumble getFumble() {
    return fumble;
  }

  public void setFumble(Fumble fumble) {
    this.fumble = fumble;
  }

  public Interception getInterception() {
    return interception;
  }

  public void setInterception(Interception interception) {
    this.interception = interception;
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

  public String getTypeOfPlay() {
    return typeOfPlay;
  }

  public void setTypeOfPlay(String typeOfPlay) {
    this.typeOfPlay = typeOfPlay;
  }

  public String getVistorTeam() {
    return vistorTeam;
  }

  public void setVistorTeam(String vistorTeam) {
    this.vistorTeam = vistorTeam;
  }

  public String getHomeTeam() {
    return homeTeam;
  }

  public void setHomeTeam(String homeTeam) {
    this.homeTeam = homeTeam;
  }

  public String getGameMonth() {
    return gameMonth;
  }

  public void setGameMonth(String gameMonth) {
    this.gameMonth = gameMonth;
  }

  public String getGameDay() {
    return gameDay;
  }

  public void setGameDay(String gameDay) {
    this.gameDay = gameDay;
  }

  public String getGameYear() {
    return gameYear;
  }

  public void setGameYear(String gameYear) {
    this.gameYear = gameYear;
  }

  public String getVistorTeamScore() {
    return vistorTeamScore;
  }

  public void setVistorTeamScore(String vistorTeamScore) {
    this.vistorTeamScore = vistorTeamScore;
  }

  public String getHomeTeamScore() {
    return homeTeamScore;
  }

  public void setHomeTeamScore(String homeTeamScore) {
    this.homeTeamScore = homeTeamScore;
  }

  public boolean isTD() {
    return isTD;
  }

  public void setTD(boolean isTD) {
    this.isTD = isTD;
  }

  public boolean isExtraPoint() {
    return extraPoint;
  }

  public void setExtraPoint(boolean extraPoint) {
    this.extraPoint = extraPoint;
  }

  public boolean isTwoPointConversion() {
    return twoPointConversion;
  }

  public void setTwoPointConversion(boolean twoPointConversion) {
    this.twoPointConversion = twoPointConversion;
  }

  public boolean isPenalty() {
    return isPenalty;
  }

  public void setPenalty(boolean isPenalty) {
    this.isPenalty = isPenalty;
  }

  public boolean isFirstDown() {
    return isFirstDown;
  }

  public void setFirstDown(boolean isFirstDown) {
    this.isFirstDown = isFirstDown;
  }

  public boolean isJunior() {
    return isJunior;
  }

  public void setJunior(boolean isJunior) {
    this.isJunior = isJunior;
  }

  public LinkedList<String> gameInfoHeader() {
    LinkedList<String> gameInfoHeader = new LinkedList<String>();
    gameInfoHeader.add("Game Month");
    gameInfoHeader.add("Game Day");
    gameInfoHeader.add("Game Year");
    gameInfoHeader.add("Home Team");
    gameInfoHeader.add("Home Team Score");
    gameInfoHeader.add("Vistor Team");
    gameInfoHeader.add("Vistor Team Score");

    return gameInfoHeader;
  }

  public LinkedHashMap<String, String> gameInfoToMap() {
    LinkedHashMap<String, String> gameInfoMap = new LinkedHashMap<String, String>();
    gameInfoMap.put("gameMonth", gameMonth);
    gameInfoMap.put("gameDay", gameDay);
    gameInfoMap.put("gameYear", gameYear);
    gameInfoMap.put("homeTeam", homeTeam);
    gameInfoMap.put("homeTeamScore", homeTeamScore);
    gameInfoMap.put("vistorTeam", vistorTeam);
    gameInfoMap.put("vistorTeamScore", vistorTeamScore);

    return gameInfoMap;
  }

  public LinkedList<String> downInfoHeader() {
    LinkedList<String> gameInfoHeader = new LinkedList<String>();
    gameInfoHeader.add("Clock");
    gameInfoHeader.add("Quarter");
    gameInfoHeader.add("Play Type");
    gameInfoHeader.add("Distance To Go");
    gameInfoHeader.add("Down");
    gameInfoHeader.add("Side Of Field");
    gameInfoHeader.add("Yard Line");

    return gameInfoHeader;
  }

  public LinkedHashMap<String, String> downInfoToMap() {
    LinkedHashMap<String, String> gameInfoMap = new LinkedHashMap<String, String>();
    gameInfoMap.put("clock", clock);
    gameInfoMap.put("quarter", quarter);
    gameInfoMap.put("Play Type", typeOfPlay);
    gameInfoMap.put("distanceToGo", downInfo.distance);
    gameInfoMap.put("down", downInfo.down);
    gameInfoMap.put("sideOfField", downInfo.sideOfField);
    gameInfoMap.put("yardLine", downInfo.yardLine);

    return gameInfoMap;
  }

  public LinkedList<String> runInfoHeader() {
    LinkedList<String> gameInfoHeader = new LinkedList<String>();
    gameInfoHeader.add("Rusher First Name");
    gameInfoHeader.add("Rusher Last Name");
    gameInfoHeader.add("Yards Rushed");
    gameInfoHeader.add("Sacker First Name");
    gameInfoHeader.add("Sacker Last Name");

    return gameInfoHeader;
  }

  public LinkedHashMap<String, String> runInfoToMap() {
    LinkedHashMap<String, String> gameInfoMap = new LinkedHashMap<String, String>();
    gameInfoMap.put("rusherFirstName", runPlay.rusherFirstName);
    gameInfoMap.put("rusherLastName", runPlay.rusherLastName);
    gameInfoMap.put("yardsRush", runPlay.ydsRushed);
    gameInfoMap.put("sackerFirstName", sackerFirstName);
    gameInfoMap.put("sackerLastName", sackerLastName);
    

    return gameInfoMap;
  }

  public LinkedList<String> fumbleInfoHeader() {
    LinkedList<String> gameInfoHeader = new LinkedList<String>();
    gameInfoHeader.add("Forcer First Name");
    gameInfoHeader.add("Forcer Last Name");
    gameInfoHeader.add("Fumbler First Name");
    gameInfoHeader.add("Fumbler Last Name");
    gameInfoHeader.add("Recover First Name");
    gameInfoHeader.add("Recover Last Name");
    gameInfoHeader.add("Fumble Return Yards");
    gameInfoHeader.add("Team Recovered");

    return gameInfoHeader;
  }

  public LinkedHashMap<String, String> fumbleInfoToMap() {
    LinkedHashMap<String, String> gameInfoMap = new LinkedHashMap<String, String>();
    gameInfoMap.put("forcerFirstName", fumble.forcerFirstName);
    gameInfoMap.put("forcerLastName", fumble.forcerLastName);
    gameInfoMap.put("fumblerFirstName", fumble.fumblerFirstName);
    gameInfoMap.put("fumblerLastName", fumble.fumblerLastName);
    gameInfoMap.put("recoverFirstName", fumble.recoverFirstName);
    gameInfoMap.put("recoverLastName", fumble.recoverLastName);
    gameInfoMap.put("fumbleReturnYards", fumble.rtnYds);
    gameInfoMap.put("teamRecovered", fumble.teamRecovered);

    return gameInfoMap;
  }

  public LinkedList<String> intInfoHeader() {
    LinkedList<String> gameInfoHeader = new LinkedList<String>();
    gameInfoHeader.add("Def Back First Name");
    gameInfoHeader.add("Def Back Last Name");
    gameInfoHeader.add("Int Return Yards");

    return gameInfoHeader;
  }

  public LinkedHashMap<String, String> intInfoToMap() {
    LinkedHashMap<String, String> gameInfoMap = new LinkedHashMap<String, String>();
    gameInfoMap.put("defBackFirstName", interception.defBackFirstName);
    gameInfoMap.put("defBackLastName", interception.defBackLastName);
    gameInfoMap.put("intReturnYards", interception.rtnYds);

    return gameInfoMap;
  }

  public LinkedList<String> kickOffInfoHeader() {
    LinkedList<String> gameInfoHeader = new LinkedList<String>();
    gameInfoHeader.add("Kickoff Kicker First Name");
    gameInfoHeader.add("Kickoff Kicker Last Name");
    gameInfoHeader.add("Yards Kicked");
    gameInfoHeader.add("Receiver First Name");
    gameInfoHeader.add("Receiver Last Name");
    gameInfoHeader.add("Return Yards");
    return gameInfoHeader;
  }

  public LinkedHashMap<String, String> kickOffInfoToMap() {
    LinkedHashMap<String, String> gameInfoMap = new LinkedHashMap<String, String>();
    gameInfoMap.put("KickOffKickFirstName", kickOff.kickerFirstName);
    gameInfoMap.put("KickOffKickLastName", kickOff.kickerLastName);
    gameInfoMap.put("kickOffYardsKicked", kickOff.ydsKicked);
    gameInfoMap.put("kickOffRecFirstName", kickOff.recFirstName);
    gameInfoMap.put("kickOffRecLastName", kickOff.recLastName);
    gameInfoMap.put("kickOffRtnYards", kickOff.rtnYds);

    return gameInfoMap;
  }
  
  public LinkedList<String> puntInfoHeader() {
    LinkedList<String> gameInfoHeader = new LinkedList<String>();
    gameInfoHeader.add("Puntter First Name");
    gameInfoHeader.add("Punter Last Name");
    gameInfoHeader.add("Punt Yards Kicked");
    gameInfoHeader.add("Receiver First Name");
    gameInfoHeader.add("Receiver Last Name");
    gameInfoHeader.add("Return Yards");
    return gameInfoHeader;
  }

  public LinkedHashMap<String, String> puntInfoToMap() {
    LinkedHashMap<String, String> gameInfoMap = new LinkedHashMap<String, String>();
    gameInfoMap.put("punterFirstName", puntPlay.punterFirstName);
    gameInfoMap.put("punterLastName", puntPlay.punterLastName);
    gameInfoMap.put("puntYardsKicked", puntPlay.ydsPunted);
    gameInfoMap.put("puntRecFirstName", puntPlay.rtnFirstName);
    gameInfoMap.put("puntRecLastName", puntPlay.rtnLastName);
    gameInfoMap.put("puntRtnYards", puntPlay.rtnYds);

    return gameInfoMap;
  }

  public LinkedList<String> passInfoHeader() {
    LinkedList<String> gameInfoHeader = new LinkedList<String>();
    gameInfoHeader.add("Passer First Name");
    gameInfoHeader.add("Passer Last Name");
    gameInfoHeader.add("Complete");
    gameInfoHeader.add("Receiver First Name");
    gameInfoHeader.add("Receiver Last Name");
    gameInfoHeader.add("Passing Yards");

    return gameInfoHeader;
  }

  public LinkedHashMap<String, String> passInfoToMap() {
    LinkedHashMap<String, String> gameInfoMap = new LinkedHashMap<String, String>();
    gameInfoMap.put("passerFirstName", passPlay.passerFirstName);
    gameInfoMap.put("passerLastName", passPlay.passerLastName);
    gameInfoMap.put("complete", passPlay.isComplete);
    gameInfoMap.put("receiverFirstName", passPlay.recFirstName);
    gameInfoMap.put("receiverLastName", passPlay.recLastName);
    gameInfoMap.put("passingYards", passPlay.yards);

    return gameInfoMap;
  }
}