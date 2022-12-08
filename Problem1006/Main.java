package Problem1006;


import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static TrainComparator tComp = new TrainComparator();
    static Set<Train> trains = new TreeSet<Train>(tComp);


    private static class TrainComparator implements Comparator<Train> {
        @Override
        public int compare(Train t1, Train t2) {
            return t1.getToAddress().compareTo(t2.getToAddress());
        }
    }

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
        for (Train t : trains) {
            System.out.printf("%d %s - %s %s %n", t.getID(), t.getFromAddress().toUpperCase(),
                    t.getToAddress().toUpperCase(), t.getDepartureTime());
        }
    }

}
