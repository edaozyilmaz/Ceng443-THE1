public class SoftTire extends Tire {

  public SoftTire() {
    this.speed = 350;
    this.degradation = 0;
  }

  public void tick(TrackFeature f){
    degradation += 1.2*f.getRoughness()*f.getMultiplier();
    if(speed >= 100){
        speed -= Math.min(75,degradation)*0.25;
    }
  }

  public Tire changeTire(){
      Tire tire = new MediumTire();
      return tire;
  }
}
