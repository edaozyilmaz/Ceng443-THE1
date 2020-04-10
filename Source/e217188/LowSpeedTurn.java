public class LowSpeedTurn extends TrackFeature {

  public LowSpeedTurn(int turnNo, TurnDirection direction, double distance, double roughness) {
    // Fill this method
    featureNo = turnNo;
    turnDirection = direction;
    this.distance = distance;
    this.roughness = roughness;
    this.multiplier = 1.3;
  }
}
