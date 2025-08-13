package Lab02;

import java.util.Scanner;

public class StudentManagement {

    private static final String ADD = "1";
    private static final String DISPLAY = "2";
    private static final String FIND_BY_ID = "3";
    private static final String UPDATE = "4";
    private static final String QUIT = "5";

    private static Student[] students = new Student[100];
    private static int count = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean exitFlag = false;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1: Create new student");
            System.out.println("2: Display all");
            System.out.println("3: Find a student by ID");
            System.out.println("4: Update a student by ID");
            System.out.println("5: Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case ADD:
                    addNewStudent();
                    break;
                case DISPLAY:
                    showAllStudentList();
                    break;
                case FIND_BY_ID:
                    findById();
                    break;
                case UPDATE:
                    updateById();
                    break;
                case QUIT:
                    System.out.println("Exiting...");
                    exitFlag = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter from 1 to 5.");
            }
        } while (!exitFlag);
    }


    private static void addNewStudent() {
        if (count >= students.length) {
            System.out.println("Student list is full!");
            return;
        }

        Student s = new Student();

        // ID
        while (true) {
            System.out.print("Enter ID: ");
            s.id = scanner.nextLine();
            if (s.id.isEmpty()) {
                System.out.println("ID cannot be empty.");
            } else if (isDuplicateID(s.id)) {
                System.out.println("ID already exists!");
            } else {
                break;
            }
        }

        // Name
        while (true) {
            System.out.print("Enter Name: ");
            s.name = scanner.nextLine();
            if (s.name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            } else {
                break;
            }
        }

        // Age
        while (true) {
            System.out.print("Enter Age: ");
            s.age = readInt();
            if (s.age < 18) {
                System.out.println("Age must be >= 18.");
            } else {
                break;
            }
        }

        // Address
        System.out.print("Enter Address: ");
        s.address = scanner.nextLine();

        // Gender
        while (true) {
            System.out.print("Enter Gender (male/female): ");
            s.gender = scanner.nextLine().toLowerCase();
            if (s.gender.equals("male") || s.gender.equals("female")) {
                break;
            } else {
                System.out.println("Gender must be male or female.");
            }
        }

        // Email
        System.out.print("Enter Email: ");
        s.email = scanner.nextLine();

        students[count++] = s;
        System.out.println("Student added successfully!");
    }

    private static void showAllStudentList() {
        if (count == 0) {
            System.out.println("No students to display.");
            return;
        }
        System.out.printf("%-10s %-15s %-5s %-20s %-10s %-25s\n",
                "ID", "Name", "Age", "Address", "Gender", "Email");
        System.out.println("------------------------------------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            students[i].display();
        }
    }

    private static void findById() {
        System.out.print("Enter ID to find: ");
        String id = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                System.out.printf("%-10s %-15s %-5s %-20s %-10s %-25s\n",
                        "ID", "Name", "Age", "Address", "Gender", "Email");
                students[i].display();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void updateById() {
        System.out.print("Enter ID to update: ");
        String id = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                System.out.print("Enter new Name: ");
                students[i].name = scanner.nextLine();
                System.out.print("Enter new Age: ");
                students[i].age = readInt();
                System.out.print("Enter new Address: ");
                students[i].address = scanner.nextLine();
                System.out.print("Enter new Gender: ");
                students[i].gender = scanner.nextLine();
                System.out.print("Enter new Email: ");
                students[i].email = scanner.nextLine();
                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static boolean isDuplicateID(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    //Ham valid nhap so nguyen
    private static int readInt() {
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }
}


