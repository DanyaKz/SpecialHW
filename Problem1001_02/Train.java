package Problem1001_02;

public class Train implements Comparable<Train>{
    private int trainId;
    private String location;
    private String time;

    public Train(int trainId, String location, String time) {
        this.trainId = trainId;
        this.location = location;
        this.time = time;
    }

    public int getTrainId() {
        return trainId;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    private int timeToMinutes(){
        String[] timeArr = time.split(":");
        int hours = Integer.parseInt(timeArr[0]);
        int minutes = Integer.parseInt(timeArr[1]);

        return hours * 60 + minutes;
    }


    @Override
    public int compareTo(Train t) {
        return Integer.compare(timeToMinutes(), t.timeToMinutes());
    }
}
