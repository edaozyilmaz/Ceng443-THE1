public abstract class TrackFeature {

  protected int featureNo;
  protected TurnDirection turnDirection;
  protected double distance;
  protected double roughness;
  protected double multiplier;

  public int getFeatureNo() {
    return featureNo;
  }

  public double getRoughness() {
    return roughness;
  }

  public double getDistance() {
    return distance;
  }

  public TurnDirection getTurnDirection() {
    return turnDirection;
  }

  public double getMultiplier(){
      return multiplier;
  }

}
