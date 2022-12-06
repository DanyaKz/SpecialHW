package Problem1005;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Passenger> passengers = new ArrayList<Passenger>();

    public static void main(String[] args) {
        System.out.print("How many passengers you'd like to add ? \n -> ");
        int passengersNum = scanner.nextInt();
        scanner.nextLine();
        addPassengers(passengersNum);
        printMaxWeight();
    }

    static void addPassengers(int passengersNum) {
        for (int i = 0; i < passengersNum; i++) {
            System.out.print((i + 1) + ". Enter the passenger name: ");
            String name = scanner.next();
            passengers.add(new Passenger(name));
            fillLuggage(i);
        }
        System.out.println(passengersNum + " passengers were successfully added !");
    }

    static void fillLuggage(int passengerIdx) {
        System.out.print("Size of luggage: ");
        int luggageSize = scanner.nextInt();
        scanner.nextLine();
        for (int j = 0; j < luggageSize; j++) {
            System.out.print((j + 1) + ". Enter luggage data (description, count and weight) separated by space: ");
            String[] luggageData = scanner.nextLine().split("( )");
            passengers.get(passengerIdx).addLuggage(
                    new Luggage(luggageData[0], Integer.parseInt(luggageData[1]),
                            Double.parseDouble(luggageData[2])));
        }
        System.out.println(luggageSize + " items were successfully added to " +
                passengers.get(passengerIdx).getName() + "'s luggage");
    }

    static void printMaxWeight() {
        Collections.sort(passengers);
        Passenger champion = passengers.get(0);
        System.out.println(champion.getName());
        String maxLuggage = champion.getMaxLuggage().getDescription();
        System.out.println(maxLuggage);
    }
}
