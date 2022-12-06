package Problem1003_04;

public class Student implements Comparable<Student> {
    private int id;
    private String surname;
    double grade;

    public Student(int id, String surname, double grade) {
        this.id = id;
        this.surname = surname;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student s) {
        return Double.compare(grade * (-1), s.getGrade() * (-1));
    }
}
