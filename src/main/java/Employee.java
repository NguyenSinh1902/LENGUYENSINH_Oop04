import java.util.Scanner;

public class Employee {
    String code;
    String name;
    int bYear;
    String address;

    public Employee(String code,  String name, int bYear, String address) {
        this.code = code;
        this.name = name;
        this.bYear = bYear;

        this.address = address;
    }

    void input() {
        Scanner sccaner = new Scanner(System.in);
        System.out.println("Enter code: ");
        code = sccaner.nextLine();
        System.out.println("Enter name: ");
        name = sccaner.nextLine();
        System.out.println("Enter birth year: ");
        bYear = sccaner.nextInt();
        System.out.println("Enter address: ");
        address = sccaner.nextLine();
    }

    @Override
    public String toString() {
        return code + " " + name + " " + bYear + " " + address;
    }
}
