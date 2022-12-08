package Problem1007;

public class Student implements Comparable<Student>{
    private int ID;
    private String name;
    private int[] grades;
    private boolean isAltyn;
    private int sumPoints;

    public Student(String name, int[] grades, boolean isAltyn) {
        this.ID = (int) (Math.random() * 1000 - 1);
        this.name = name;
        this.grades = grades;
        this.isAltyn = isAltyn;
        this.sumPoints = gradeSum();
    }

    private int gradeSum(){
        int sum = 0;
        for (int i : grades) {
            sum += i;
        }
        return sum;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }

    public boolean getIsAltyn() {
        return isAltyn;
    }

    public int getSumPoints() {
        return sumPoints;
    }

    @Override
    public int compareTo(Student s) {
        return Integer.compare(sumPoints * (-1), s.getSumPoints() * (-1));
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name=" + name +
                ", sumPoints=" + sumPoints +
                ", getIsAltyn = " + isAltyn +
                '}';
    }
}
