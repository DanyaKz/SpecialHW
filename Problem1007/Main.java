package Problem1007;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Student> students = new ArrayList<Student>();
    static StringBuilder readInformation = new StringBuilder();
    static int altynCount = 0;

    public static void main(String[] args) {
        inputData();
        addStudents();
        printStudents();
    }

    static void inputData(){
        try{
            FileInputStream fis = new FileInputStream("src/Problem1007/toRead.txt");
            byte[] bytesData = fis.readAllBytes();

            for (byte b : bytesData) {
                readInformation.append((char) b);
            }
            fis.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    static void addStudents() {
        String[] allStudentsData = readInformation.toString().split("\r\n");

        for (String student : allStudentsData) {
            String[] eachStDataArr = student.split("( )");

            String stName = eachStDataArr[0] + " " + eachStDataArr[1];
            int[] grades = new int[4];
            boolean isAltyn = (eachStDataArr[6].equalsIgnoreCase("yes".strip()));
            if (isAltyn) altynCount++;

            for (int j = 0; j < 4; j++) {
                grades[j] = Integer.parseInt(eachStDataArr[j + 2]);
            }

            students.add(new Student(stName, grades, isAltyn));
        }

        Collections.sort(students);
        for (Student s : students) System.out.println(s);
        System.out.println(allStudentsData.length + " students were successfully added!");
    }

    static void printStudents() {
        System.out.print("Count of grants: ");
        int grantCount = scanner.nextInt();

        ListIterator<Student> stItr = students.listIterator();

        int i = 0;
        while (stItr.hasNext() && (grantCount - altynCount) > i){
            Student st = stItr.next();
            System.out.println(st);
            if (st.getIsAltyn()) altynCount--;
            stItr.previous();
            stItr.remove();
            i++;
        }

        if (altynCount > 0) {
            findAltyn();
        }
    }

    static void findAltyn() {
        for (Student s : students) {
            if (s.getIsAltyn()) {
                System.out.println(s);
            }
        }
    }


}
