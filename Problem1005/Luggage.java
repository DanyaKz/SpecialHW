package Problem1005;

public class Luggage {
    private String description;
    private int count;
    private double weight;

    public Luggage(String description, int count, double weight) {
        this.description = description;
        this.count = count;
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public double getWeight() {
        return weight;
    }

}
