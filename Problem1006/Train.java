package Problem1006;

public class Train {
    private int ID;
    private String fromAddress;
    private String toAddress;
    private String departureTime;

    public Train(String fromAddress, String toAddress, String departureTime) {
        this.ID = (int) (Math.random() * 100 - 1);
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.departureTime = departureTime;
    }

    public int getID() {
        return ID;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public String getDepartureTime() {
        return departureTime;
    }

}
