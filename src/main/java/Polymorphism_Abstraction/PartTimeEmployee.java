package Polymorphism_Abstraction;

public class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name);  // gọi constructor cha chỉ cần name
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;  // sửa lại công thức: giờ * rate
    }

    @Override
    public String toString() {
        return String.format("PartTimeEmployee - Name: %s, Hours: %d, HourlyRate: %.2f, Salary: %.2f",
                name, hoursWorked, hourlyRate, calculateSalary());
    }
}
