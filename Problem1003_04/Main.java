package Problem1003_04;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Student> students = new LinkedList<Student>();

    public static void main(String[] args) {
        System.out.print("How many students you'd like to add ? \n -> ");
        int studentsNum = scanner.nextInt();
        scanner.nextLine();
        addStudents(studentsNum);
        printStudents();
    }

    public static void addStudents(int studentsNum){
        for (int i = 0; i < studentsNum; i++) {
            System.out.print("Enter student data (SURNAME GRADE) separated by a space: ");
            String[] studentData = scanner.nextLine().split("( )");
            int id = (int) (Math.random() * 100 - 1);
            students.add(new Student(id, studentData[0], Double.parseDouble(studentData[1])));
        }
        System.out.println(studentsNum + " students were successfully added!");
    }

    public static void printStudents(){
        Collections.sort(students);
        for (Student s: students){
            System.out.printf("%d. %s %.02f %n", s.getId(), s.getSurname(), s.getGrade());
        }
    }


}
