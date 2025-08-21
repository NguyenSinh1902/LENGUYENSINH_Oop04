package Polymorphism_Abstraction;

public abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Vì Employee là abstract class nên phương thức này cũng nên là abstract
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Name: %s, BaseSalary: %.2f", name, baseSalary);
    }
}
