package Inheritance;

public class Professor extends Person {
    int salary;

    public Professor(String id, String name, String email, int salary) {
        super(id, name, email);
        this.salary = salary;
    }
}
