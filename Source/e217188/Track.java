import java.util.ArrayList;

public class Track {

  private String trackName;
  private ArrayList<TrackFeature> featureList;
  private boolean isClockwise;
  private int flag=0;

  public Track() {
    // Fill this method
  }

  public Track(String trackName, ArrayList<TrackFeature> featureList, boolean isClockwise) {
    // Fill this method
    this.trackName = trackName;
    this.featureList = featureList;
    this.isClockwise = isClockwise;
  }

  public String getTrackName() {
    return trackName;
  }

  public void setTrackName(String trackName) {
    this.trackName = trackName;
  }

  public ArrayList<TrackFeature> getFeatureList() {
    return featureList;
  }

  public void setFeatureList(ArrayList<TrackFeature> featureList) {
    this.featureList = featureList;
  }

  public boolean isClockwise() {
    return isClockwise;
  }

  public void setClockwise(boolean clockwise) {
    isClockwise = clockwise;
  }

  public int getTrackLength() {
    // Fill this method
    return featureList.size();
  }

  public TrackFeature getNextFeature() {
    // Fill this method
    if(flag != featureList.size()){
        flag++;
        return featureList.get(flag-1);
    }
    else{
        flag = 1;
        return featureList.get(flag-1);
    }
  }

  public void addFeature(TrackFeature feature) {
    // Fill this method
    featureList.add(feature);
  }

  public boolean isValidTrack() {
    // Fill this method
    boolean bool = false;
    int rightCount = 0;
    int leftCount = 0;
    for(int i=0; i < featureList.size(); i++){
        if(featureList.get(i).getTurnDirection() == TurnDirection.RIGHT)
            rightCount++;
        if(featureList.get(i).getTurnDirection() == TurnDirection.LEFT)
            leftCount++;
    }
    if(featureList.get(0).getTurnDirection() == TurnDirection.STRAIGHT && featureList.get(featureList.size()-1).getTurnDirection() == TurnDirection.STRAIGHT){
        if((rightCount == leftCount+4 && this.isClockwise() == true)|| (rightCount == leftCount-4 && this.isClockwise() == false)){
            bool = true;
        }
    }
    return bool;
  }
}
