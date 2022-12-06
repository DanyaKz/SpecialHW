package Problem1006;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Train> trains = new ArrayList<Train>();

    public static void main(String[] args) {
        System.out.print("How many trains you'd like to add ? \n -> ");
        int trainsNum = scanner.nextInt();
        scanner.nextLine();
        addTrains(trainsNum);
        printSortedTrains();
    }

    static void addTrains(int trainsNum) {
        for (int i = 0; i < trainsNum; i++) {
            System.out.print((i + 1) + ". Text train's data (FromAddress, ToAddress, DepartureTime) separated by space: ");
            String[] trainData = scanner.nextLine().split("( )");
            trains.add(new Train(trainData[0], trainData[1], trainData[2]));
        }

        System.out.println(trainsNum + " trains were successfully added!");
    }

    static void printSortedTrains() {
        Collections.sort(trains);
        for (Train t : trains) {
            System.out.printf("%d %s - %s %s %n", t.getID(), t.getFromAddress().toUpperCase(),
                    t.getToAddress().toUpperCase(), t.getDepartureTime());
        }
    }

}
