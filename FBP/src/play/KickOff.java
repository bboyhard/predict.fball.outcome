package play;

public class KickOff {
  String kickerFirstName;
  String kickerLastName;
  String ydsKicked;
  String rtnYds;
  String recFirstName;
  String recLastName;
  boolean isFumble;
  boolean isTD;
  boolean isTouchback;
  boolean isPenalty;

  public String getKickerFirstName() {
    return kickerFirstName;
  }

  public void setKickerFirstName(String kickerFirstName) {
    this.kickerFirstName = kickerFirstName;
  }

  public String getKickerLastName() {
    return kickerLastName;
  }

  public void setKickerLastName(String kickerLastName) {
    this.kickerLastName = kickerLastName;
  }

  public String getYdsKicked() {
    return ydsKicked;
  }

  public void setYdsKicked(String ydsKicked) {
    this.ydsKicked = ydsKicked;
  }

  public String getRtnYds() {
    return rtnYds;
  }

  public void setRtnYds(String rtnYds) {
    this.rtnYds = rtnYds;
  }

  public String getRecFirstName() {
    return recFirstName;
  }

  public void setRecFirstName(String recFirstName) {
    this.recFirstName = recFirstName;
  }

  public String getRecLastName() {
    return recLastName;
  }

  public void setRecLastName(String recLastName) {
    this.recLastName = recLastName;
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
