package play;

public class Penalty {
  String teamAgainst;
  String againstFirstName;
  String againstLastName;
  String howManyYds;
  boolean isNoPlay;
  
  public String getTeamAgainst() {
    return teamAgainst;
  }
  
  public void setTeamAgainst(String teamAgainst) {
    this.teamAgainst = teamAgainst;
  }
  
  public String getAgainstFirstName() {
    return againstFirstName;
  }
  
  public void setAgainstFirstName(String againstFirstName) {
    this.againstFirstName = againstFirstName;
  }
  
  public String getAgainstLastName() {
    return againstLastName;
  }
  
  public void setAgainstLastName(String againstLastName) {
    this.againstLastName = againstLastName;
  }
  
  public String getHowManyYds() {
    return howManyYds;
  }
  
  public void setHowManyYds(String howManyYds) {
    this.howManyYds = howManyYds;
  }
  
  public boolean isNoPlay() {
    return isNoPlay;
  }
  
  public void setNoPlay(boolean isNoPlay) {
    this.isNoPlay = isNoPlay;
  }
}
