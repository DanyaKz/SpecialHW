package Problem1001_02;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Map<String, List<Train>> destPoints = new HashMap<String, List<Train>>();

    public static void main(String[] args) {
        System.out.print("How many destination points you'd like to add ? \n -> ");
        int pointsNum = scanner.nextInt();
        scanner.nextLine();
        addDestPoints(pointsNum);
        System.out.println(printDestination());
    }

    public static void addDestPoints(int pointsNum) {
        for (int i = 0; i < pointsNum; i++) {
            System.out.print("Enter ID, destination address, time data separated by space: ");
            String data = scanner.nextLine();
            String[] dataArr = data.split(" ");
            String destName = dataArr[1].toLowerCase();

            if (Objects.isNull(destPoints.getOrDefault(destName,null))){
                System.out.println(1);
                destPoints.put(destName,
                        new ArrayList<Train>(List.of(new Train(Integer.parseInt(dataArr[0]), dataArr[1], dataArr[2]))));

            }else {
                System.out.println(2);
                destPoints.get(destName).add(new Train(Integer.parseInt(dataArr[0]), dataArr[1], dataArr[2]));
            }

        }
        System.out.println(pointsNum + " destination points were successfully added! ");
    }

    static List<Train> findTrain(){
        System.out.print("Enter the location name: ");
        String locName = scanner.next();
        return destPoints.getOrDefault(locName.toLowerCase(), null);
    }

    static String printDestination(){
        List<Train> getTrains = findTrain();
        if (Objects.isNull(getTrains)) return "Impossible";
        StringBuilder trainsLst = new StringBuilder("Destinations were sorted by time:\n");

        Collections.sort(getTrains);

        for (Train t: getTrains){
            trainsLst.append(String.format("%d %s %s ;\n", t.getTrainId(),
                    t.getLocation(), t.getTime()));
        }


        return trainsLst.toString().replaceAll("(.$)", "");
    }


}
