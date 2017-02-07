package play;

public class FieldGoal {
  String kickerFirstName;
  String kickerLastName;
  String fieldGoalDistance;
  boolean isGood;
  
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
  
  public String getFieldGoalDistance() {
    return fieldGoalDistance;
  }
  
  public void setFieldGoalDistance(String fieldGoalDistance) {
    this.fieldGoalDistance = fieldGoalDistance;
  }
  
  public boolean isGood() {
    return isGood;
  }
  
  public void setGood(boolean isGood) {
    this.isGood = isGood;
  }
}
