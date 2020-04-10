import java.util.Random;
public class Car {

  private int carNo;
  private String driverName;
  private double totalTime;
  private Tire tire;

  public Car() {
    // Fill this method
  }

  public Car(String driverName, int carNo, Tire tire) {
    // Fill this method
    this.carNo = carNo;
    this.driverName = driverName;
    this.tire = tire;
    this.totalTime = 0;
  }

  public Tire getTire() {
    return tire;
  }

  public void setTire(Tire tire) {
    this.tire = tire;
  }

  public String getDriverName() {
    return driverName;
  }

  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }

  public int getCarNo() {
    return carNo;
  }

  public void setCarNo(int carNo) {
    this.carNo = carNo;
  }

  public double getTotalTime() {
    return totalTime;
  }

  public void tick(TrackFeature feature) {
    // Fill this method
    this.totalTime += feature.getDistance()/this.tire.getSpeed();// + Math.random();
    tire.tick(feature);
    if(tire.getDegradation() > 70){
        //Change tire
        this.totalTime += 25;
        tire = tire.changeTire();
    }
  }

}
