package play;

import java.util.HashMap;

public class Play {
  public DownInfo downInfo = new DownInfo();
  public KickOff kickOff = new KickOff();
  public ExtraPoint extraPoint = new ExtraPoint();
  public RunPlay runPlay = new RunPlay();
  public PassPlay passPlay = new PassPlay();
  public PuntPlay puntPlay = new PuntPlay();
  public Penalty penalty = new Penalty();
  public FieldGoal fieldGoal = new FieldGoal();
  public Fumble fumble = new Fumble();

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
  boolean isTD;
  boolean isPenalty;
  boolean isFirstDown;
  boolean isJunior;

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

  public ExtraPoint getExtraPoint() {
    return extraPoint;
  }

  public void setExtraPoint(ExtraPoint extraPoint) {
    this.extraPoint = extraPoint;
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

  public HashMap<String,String> playToMap() {
    HashMap<String, String> playMap = new HashMap<String, String>();
    
    
    return playMap;
  }
}