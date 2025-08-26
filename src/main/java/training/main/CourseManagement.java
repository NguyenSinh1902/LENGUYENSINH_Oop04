package training.main;

import training.entities.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagement {
    private ArrayList<Course> courses;

    private static final String ADD = "1";
    private static final String SEARCH = "2";
    private static final String DISPLAY = "3";
    private static final String EXIT = "4";

    public CourseManagement() {
        courses = new ArrayList<>();
    }

    // Input course
    public void input(Scanner sc) {
        Course course = new Course();
        course.input(sc, courses);
        courses.add(course);
        System.out.println("✅ Course added successfully!");
    }

    // Search
    public ArrayList<Course> search(String type, Object data) {
        ArrayList<Course> results = new ArrayList<>();
        for (Course c : courses) {
            switch (type.toLowerCase()) {
                case "code":
                    if (c.getCode().equalsIgnoreCase(data.toString())) results.add(c);
                    break;
                case "name":
                    if (c.getName().equalsIgnoreCase(data.toString())) results.add(c);
                    break;
                case "status":
                    if (c.isStatus() == Boolean.parseBoolean(data.toString())) results.add(c);
                    break;
                case "duration":
                    if (c.getDuration() == Short.parseShort(data.toString())) results.add(c);
                    break;
                case "flag":
                    if (c.getFlag().equalsIgnoreCase(data.toString())) results.add(c);
                    break;
                default:
                    System.out.println("Invalid search type.");
            }
        }
        return results;
    }

    // Display
    public void displayAll(String flag) {
        boolean found = false;
        for (Course c : courses) {
            if (c.getFlag().equalsIgnoreCase(flag)) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No courses found with flag: " + flag);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManagement cm = new CourseManagement();

        while (true) {
            System.out.println("\n=== Course Management Menu ===");
            System.out.println(ADD + ". Create course");
            System.out.println(SEARCH + ". Search course");
            System.out.println(DISPLAY + ". Display courses by flag");
            System.out.println(EXIT + ". Quit");
            System.out.print("Select an option: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case ADD:
                    cm.input(sc);
                    break;
                case SEARCH:
                    System.out.print("Enter search type (code/name/status/duration/flag): ");
                    String type = sc.nextLine().trim();
                    System.out.print("Enter search value: ");
                    String data = sc.nextLine().trim();

                    ArrayList<Course> results = cm.search(type, data);
                    if (results.isEmpty()) {
                        System.out.println("No results found.");
                    } else {
                        results.forEach(System.out::println);
                    }
                    break;
                case DISPLAY:
                    System.out.print("Enter flag (optional/prerequisite/N/A): ");
                    String flag = sc.nextLine().trim();
                    cm.displayAll(flag);
                    break;
                case EXIT:
                    System.out.println("Exit!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
