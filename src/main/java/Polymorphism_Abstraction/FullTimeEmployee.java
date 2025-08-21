package Polymorphism_Abstraction;

public class FullTimeEmployee extends Employee {


    public FullTimeEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}
