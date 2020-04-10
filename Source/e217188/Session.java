import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashSet;

public class Session {

  private Track track;
  private ArrayList<Team> teamList;
  private int totalLaps;
  private ArrayList<Double> timeArray = new ArrayList<Double>();

  public Session() {
    // Fill this method
  }

  public Session(Track track, ArrayList<Team> teamList, int totalLaps) {
    // Fill this method
    this.track = track;
    this.teamList = teamList;
    this.totalLaps = totalLaps;
  }

  public Track getTrack() {
    return track;
  }

  public void setTrack(Track track) {
    this.track = track;
  }

  public ArrayList<Team> getTeamList() {
    return teamList;
  }

  public void setTeamList(ArrayList<Team> teamList) {
    this.teamList = teamList;
  }

  public int getTotalLaps() {
    return totalLaps;
  }

  public void setTotalLaps(int totalLaps) {
    this.totalLaps = totalLaps;
  }

  public void simulate() {
    // Fill this method

    ArrayList<Car> carArray = new ArrayList<Car>();
    ArrayList<Car> carList = new ArrayList<Car>();
    if(track.isValidTrack() == false){
        System.out.println("Track is invalid.Simulation aborted!");
        return;
    }
    else{
        System.out.println("Track is valid.Starting simulation on " + this.track.getTrackName() + " for " + this.totalLaps + " laps.");
        /*for(int i=0; i < this.teamList.size(); i++){
            carList = teamList.get(i).getCarList();
            for (int j=0; j < carList.size() ; j++) {
                for(int lap=0; lap < this.totalLaps; lap++){
                    for (int f=0;f < track.getTrackLength() ;f++) {
                        carList.get(j).tick(track.getNextFeature());
                    }
                }
                //System.out.println(carList.get(j).getTotalTime());

            }*/
            printWinnerTeam();
            printTimingTable();
        }
  }

  public String printWinnerTeam() {
    // Fill this method
    ArrayList<Car> carList1 = new ArrayList<Car>();
    double faster = Double.MAX_VALUE;
    String name = "";
    String[] colors={};
    for(int i=0; i < this.teamList.size(); i++){
        carList1 = teamList.get(i).getCarList();
        for (int j=0; j < carList1.size() ; j++) {
            for(int lap=0; lap < this.totalLaps; lap++){
                for (int f=0;f < track.getTrackLength() ;f++) {
                    carList1.get(j).tick(track.getNextFeature());
                }
            }
            timeArray.add(carList1.get(j).getTotalTime());
            //System.out.println(carList.get(j).getTotalTime());
            if(faster > carList1.get(j).getTotalTime()){
                faster = carList1.get(j).getTotalTime();
                name = teamList.get(i).getName();
                colors = teamList.get(i).getTeamColors();
            }
        }
    }
    String flag = "";
    if (colors.length == 1){
        flag += colors[0];
    }
    else if(colors.length == 2){
        flag += colors[0] + " and " + colors[1];
    }
    else{
        for(int i=0;i<colors.length-2;i++){
            flag += colors[i] + ", ";
        }
        flag += colors[colors.length-2] + " and " + colors[colors.length-1];
    }
    System.out.println("Team " + name + " wins." + flag +" flags are waving everywhere.");

    return ".";
  }

  private String printTimingTable() {
    // Fill this method
    String flag="",flag2="",flag3="",flag4="";
    Collections.sort(timeArray);
    LinkedHashSet<Double> hashSet = new LinkedHashSet<>(timeArray);
    ArrayList<Double> timeArray = new ArrayList<>(hashSet); //Delete duplicates from timeArray

    ArrayList<Car> carList = new ArrayList<Car>();
    for(int time=0;time<timeArray.size();time++){
        for(int j=0; j < this.teamList.size(); j++){
            carList = teamList.get(j).getCarList();
            for(int i=0; i < carList.size(); i++){

                //System.out.println(timeArray.get(time)+"................"+carList1.get(i).getTotalTime());
                if(timeArray.get(time) == carList.get(i).getTotalTime()){
                    long l = (new Double(timeArray.get(time))).longValue();
                    long hours = TimeUnit.SECONDS.toHours(l);
                    if(hours < 10)
                        flag = "0"+(int)hours;
                    else
                        flag=(int)hours + "";
                    long minutes = TimeUnit.SECONDS.toMinutes(l) - (TimeUnit.SECONDS.toHours(l)* 60);
                    if(minutes < 10)
                        flag2 = "0"+(int)minutes;
                    else
                        flag2=(int)minutes + "";
                    long seconds = TimeUnit.SECONDS.toSeconds(l) - (TimeUnit.SECONDS.toMinutes(l) *60);
                    if(seconds < 10)
                        flag3 = "0"+(int)seconds;
                    else
                        flag3=(int)seconds + "";
                    double milis = timeArray.get(time).doubleValue() - (double)(timeArray.get(time).intValue());

                    String msec = String.format("%.3f", milis);
                    String first = msec.charAt(2) + "";
                    String second = msec.charAt(3) + "";
                    String third = msec.charAt(4) + "";
                    flag4 = first + second + third + "";

                    System.out.println(carList.get(i).getDriverName()+"("+carList.get(i).getCarNo()+"): "+ flag +":"+flag2+":"+flag3+"."+flag4);
                }
            }
        }
    }
    return ".";
  }
}
