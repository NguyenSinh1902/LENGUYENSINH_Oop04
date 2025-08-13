import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        //Student1
//        Student student1 = new Student();
//        student1.name = "john";
//        student1.mark1 = 80;
//        student1.mark2 = 60;
//        student1.mark3 = 70;
//
//        System.out.println("Name: " + student1.name);
//        System.out.println("Mark: " + student1.mark1);
//        System.out.println("Mark: " + student1.mark2);
//        System.out.println("Mark: " + student1.mark3);
//        System.out.println("Total: " + student1.total());
//        System.out.println("average: " + student1.average());

        Student[] students = new Student[100];
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        String choice;
        final String ADD = "1";
        final String SHOW = "2";
        final String EXIT = "3";

        do {
            System.out.println("1. Add student: ");
            System.out.println("2. Show all student ");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case ADD: //add student

                    if (count >= students.length) {
                        System.out.println("Student list is full");
                        break;
                    }
                    Student student = new Student();
                    System.out.println("Enter student name: ");
                    student.name = scanner.nextLine();

                    System.out.println("Enter mark1: ");
                    student.mark1 = scanner.nextInt();

                    System.out.println("Enter mark2: ");
                    student.mark2 = scanner.nextInt();

                    System.out.println("Enter mark3: ");
                    student.mark3 = scanner.nextInt();

                    students[count++] = student;
                    break;
                case SHOW:
                    System.out.println("List of students: ");
                    for (int i = 0; i < count; i++) {
                        System.out.println(students[i].name);
                        System.out.println(students[i].mark1);
                        System.out.println(students[i].mark2);
                        System.out.println(students[i].mark3);
                        System.out.println("==============");
                    }
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    break;
            }
        } while (!choice.equals("3"));


    }
}