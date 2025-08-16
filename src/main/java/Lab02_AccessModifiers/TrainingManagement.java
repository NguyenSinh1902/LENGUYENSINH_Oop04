package Lab02_AccessModifiers;

import java.util.Scanner;

public class TrainingManagement {
    private final String ADD = "1";
    private final String DISPLAY = "2";
    private final String FIND_BY_ID = "3";
    private final String FIND_BY_NAME = "4";
    private final String UPDATE = "5";
    private final String EXIT = "6";

    private TraineeForm traineeForm;
    private Scanner scanner;
    private Trainee[] listOfTrainees;
    private byte count;

    // Constructor
    public TrainingManagement() {
        scanner = new Scanner(System.in);
        traineeForm = new TraineeForm(scanner);
        listOfTrainees = new Trainee[100];
        count = 0;
    }

    //ADD
    private void addTrainee() {
        Trainee newTrainee = traineeForm.getTrainee();

        // Check unique ID
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getId().equals(newTrainee.getId())) {
                System.out.println("ID already exists!!!");
                return;
            }
        }

        listOfTrainees[count++] = newTrainee;
        System.out.println("Trainee added successfully!");
    }

    //Show ALL
    private void displayAllTrainees() {
        if (count == 0) {
            System.out.println("No trainees in the list.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(listOfTrainees[i]);
        }
    }

    //Find ID
    private void findById() {
        System.out.print("Enter ID to search: ");
        String id = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getId().equals(id)) {
                System.out.println(listOfTrainees[i]);
                return;
            }
        }
        System.out.println("Not found!");
    }

    //FInd Name
    private void findByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getName().equalsIgnoreCase(name)) {
                System.out.println(listOfTrainees[i]);
                found = true;
            }
        }
        if (!found) System.out.println("Not found!");
    }

    //Update
    private void updateTrainee() {
        System.out.print("Enter ID to update: ");
        String updateId = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getId().equals(updateId)) {
                System.out.println("Enter new trainee info: ");
                Trainee updated = traineeForm.getTrainee();
                listOfTrainees[i] = updated;
                System.out.println("Trainee updated successfully!");
                return;
            }
        }
        System.out.println("Trainee with ID " + updateId + " not found!");
    }

    //Menu
    private void menu() {
        String choice;
        do {
            System.out.println("\n===== Training Management Menu =====");
            System.out.println("1. Add trainee");
            System.out.println("2. Display all trainees");
            System.out.println("3. Find trainee by ID");
            System.out.println("4. Find trainee by name");
            System.out.println("5. Update trainee");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextLine();

            switch (choice) {
                case ADD:
                    addTrainee();
                    break;
                case DISPLAY:
                    displayAllTrainees();
                    break;
                case FIND_BY_ID:
                    findById();
                    break;
                case FIND_BY_NAME:
                    findByName();
                    break;
                case UPDATE:
                    updateTrainee();
                    break;
                case EXIT:
                    System.out.println("Bai Bai!!!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (!choice.equals(EXIT));
    }

    public static void main(String[] args) {
        TrainingManagement tm = new TrainingManagement();
        tm.menu();
    }
}
