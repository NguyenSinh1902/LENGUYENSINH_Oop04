package Inheritance;

public class Student extends Person {
    float gpa;

    public Student(String id, String name, String email, float gpa) {
        super(id, name, email);
        this.gpa = gpa;
    }

    @Override
    public void input() {
        super.input();
    }
}
