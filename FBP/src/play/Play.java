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
  public Fumble fumble = new Fumble();

  int playNumber;
  String quarter;
  String clock;
  String typeOfPlay;
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

  public String playToString() {
    String playString = null;

    playString = playNumber + ":" + "(" + clock + "-" + quarter + ") ";
    playString = playString + downInfo.down + " and " + downInfo.distance + " on " + downInfo.sideOfField + " "
        + downInfo.yardLine;
    playString = playString + " - Play Type: " + typeOfPlay;
    if (isTD) {
      playString = playString + " -Touchdown!!!-";
      if (extraPoint.isGood)
        playString = playString + " ExtraPoint Good";
    }
    if (typeOfPlay == "run") {
      playString = playString + " " + runPlay.rusherFirstName + " " + runPlay.rusherLastName + " ";
      if (isJunior)
        playString = playString + "Jr.";

      playString = playString + " " + "yds: " + runPlay.ydsRushed;

    }

    return playString;
  }
}