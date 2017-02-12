package play;

public class KickOff {
  String kickerName;
  String ydsKicked;
  String rtnName;
  String rtnYds;
  boolean isFumble;
  boolean isTD;
  boolean isTouchback;
  boolean isPenalty;

  public String getKickerName() {
    return kickerName;
  }

  public void setKickerName(String kickerName) {
    this.kickerName = kickerName;
  }

  public String getYdsKicked() {
    return ydsKicked;
  }

  public void setYdsKicked(String ydsKicked) {
    this.ydsKicked = ydsKicked;
  }

  public String getRtnName() {
    return rtnName;
  }

  public void setRtnName(String rtnName) {
    this.rtnName = rtnName;
  }

  public String getRtnYds() {
    return rtnYds;
  }

  public void setRtnYds(String rtnYds) {
    this.rtnYds = rtnYds;
  }

  public boolean isFumble() {
    return isFumble;
  }

  public void setFumble(boolean isFumble) {
    this.isFumble = isFumble;
  }

  public boolean isTD() {
    return isTD;
  }

  public void setTD(boolean isTD) {
    this.isTD = isTD;
  }

  public boolean isTouchback() {
    return isTouchback;
  }

  public void setTouchback(boolean isTouchback) {
    this.isTouchback = isTouchback;
  }

  public boolean isPenalty() {
    return isPenalty;
  }

  public void setPenalty(boolean isPenalty) {
    this.isPenalty = isPenalty;
  }
}
