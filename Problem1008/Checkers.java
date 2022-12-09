package Problem1008;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;

public class Checkers {
    private static final SortedMap<Integer, Integer> colors = new TreeMap<Integer, Integer>();

    public static void main(String[] args) {
        LinkedList<Integer> inpData =  inputData();
        researchData(inpData);
    }

    static LinkedList<Integer> inputData() {
        LinkedList<Integer> data = new LinkedList<Integer>();
        try {
            FileInputStream fis = new FileInputStream("src/Problem1008/toRead.txt");
            int i = -1;
            int j = 0;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);

                int toAdd = Character.getNumericValue((char) i);

//                \r == -1
                if (!(toAdd == -1)) {
                    data.add(toAdd);
                }

            }
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    static void researchData(LinkedList<Integer> data){
        System.out.println();
        StringBuilder changedColors = new StringBuilder();

        int size = 0;
        for (Integer i: data){
            if (colors.containsKey(i)){
                colors.put(i, colors.get(i) + 1);
            }else {
                colors.put(i, 1);
            }

            if (i == 2){
                changedColors.append("2");
            }else changedColors.append("-");

            size++;

            if (size % Math.sqrt(data.size()) == 0){
                changedColors.append("\n");
            }

        }
        getResult(changedColors.toString());
    }

    static void getResult(String data){
        if (colors.size() < 4){
            System.out.println("BAD INPUT LIST");
        }else {
            for (String s : data.split("\n")) {
                System.out.println(s);
            }
            System.out.println();
            for (Integer val: colors.values()){
                System.out.printf("%d ", val);
            }
        }

    }

}
