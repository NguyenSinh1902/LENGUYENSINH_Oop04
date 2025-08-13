package Lab02;

public class Student {
    String id;
    String name;
    int age;
    String address;
    String gender;
    String email;

    // Hien thi bang ds sinh vien
    public void display() {
        System.out.printf("%-10s %-15s %-5d %-20s %-10s %-25s\n",
                id, name, age, address, gender, email);
    }
}

