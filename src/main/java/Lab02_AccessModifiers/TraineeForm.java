package Lab02_AccessModifiers;

import java.util.Scanner;

public class TraineeForm {
    private Scanner scanner;

    // Constructor Scanner
    public TraineeForm(Scanner scanner) {
        this.scanner = scanner;
    }

    // Method input ID
    public String getId() {
        System.out.print("Enter trainee ID: ");
        return scanner.nextLine();
    }

    // Method input Trainee
    public Trainee getTrainee() {
        System.out.print("Enter trainee ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter trainee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter trainee gender (male/female): ");
        String gender = scanner.nextLine();

        System.out.print("Enter trainee age: ");
        byte age = scanner.nextByte();
        scanner.nextLine();

        return new Trainee(id, name, gender, age);
    }
}
