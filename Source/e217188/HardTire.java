public class HardTire extends Tire {

  public HardTire() {
    this.speed = 275;
    this.degradation = 0;
  }

  public void tick(TrackFeature f){
    degradation += 1.0*f.getRoughness()*f.getMultiplier();
    if(speed >= 100){
        speed -= Math.min(75,degradation)*0.25;
    }
  }

  public Tire changeTire(){
      Tire tire = new SoftTire();
      return tire;
  }
}
