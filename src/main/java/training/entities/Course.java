package training.entities;

import training.utils.Validator;
import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String code;
    private String name;
    private boolean status;
    private short duration;
    private String flag;

    public Course() {
    }

    public Course(String code, String name, boolean status, short duration, String flag) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.duration = duration;
        this.flag = flag;
    }

    // Getters và Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + (status ? "Active" : "Inactive") +
                ", duration=" + duration +
                ", flag='" + flag + '\'' +
                '}';
    }

    //Input
    public void input(Scanner sc, ArrayList<Course> courses) {
        // Nhập code
        while (true) {
            System.out.print("Enter course code (RAxxx): ");
            String inputCode = sc.nextLine().trim();
            if (Validator.validateCode(inputCode) && !Validator.isDuplicatedCode(inputCode, courses)) {
                this.code = inputCode;
                break;
            } else {
                System.out.println("Invalid or duplicated code. Try again!");
            }
        }

        // input name
        System.out.print("Enter course name: ");
        this.name = sc.nextLine().trim();

        // input status
        while (true) {
            System.out.print("Enter status (true=active, false=inactive): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                this.status = Boolean.parseBoolean(input);
                break;
            } else {
                System.out.println("Invalid status. Please enter true/false.");
            }
        }

        // input duration
        while (true) {
            try {
                System.out.print("Enter duration (>0): ");
                short d = Short.parseShort(sc.nextLine().trim());
                if (Validator.validateDuration(d)) {
                    this.duration = d;
                    break;
                } else {
                    System.out.println("Duration must be > 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Duration must be a number.");
            }
        }

        // input flag
        while (true) {
            System.out.print("Enter flag (optional/prerequisite/N/A): ");
            String inputFlag = sc.nextLine().trim();
            if (Validator.validateFlag(inputFlag)) {
                this.flag = inputFlag;
                break;
            } else {
                System.out.println("Invalid flag. Try again.");
            }
        }
    }
}
