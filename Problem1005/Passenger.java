package Problem1005;

import javax.swing.plaf.LabelUI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Passenger implements Comparable<Passenger> {
    private String name;
    List<Luggage> luggage = new ArrayList<Luggage>();

    public Passenger(String name) {
        this.name = name;
    }

    //    про этот метод я вам говорил
    public Luggage getMaxLuggage() {
        Luggage luggage = this.luggage.get(0);
        for (Luggage l : this.luggage) {
            if (luggage.getWeight() < l.getWeight()) {
                luggage = l;
            }
        }
        return luggage;
    }

    public String getName() {
        return name;
    }

    public List<Luggage> getLuggage() {
        return luggage;
    }

    public void addLuggage(Luggage l) {
        luggage.add(l);
    }

    @Override
    public int compareTo(Passenger p) {
        Luggage aLuggage = getMaxLuggage();
        Luggage bLuggage = p.getMaxLuggage();

        double a = aLuggage.getWeight() * aLuggage.getCount() * (-1);
        double b = bLuggage.getWeight() * bLuggage.getCount() * (-1);

        return Double.compare(a, b);
    }
}
