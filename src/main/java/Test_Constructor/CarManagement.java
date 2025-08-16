package Test_Constructor;

import java.util.Scanner;

public class CarManagement {

    // Khai báo car là thuộc tính của class
    private Car car;

    // Method nhập dữ liệu
    public void add() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the car ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter car name: ");
        String name = scanner.nextLine();

        System.out.print("Enter car size: ");
        int size = scanner.nextInt();

        System.out.print("Enter pin (true/false): ");
        boolean pin = scanner.nextBoolean();

        // Tạo đối tượng Car và gán cho thuộc tính car
        this.car = new Car(id, name, size, pin);
    }

    // Method hiển thị thông tin
    public void displaySC() {
        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("No car to display!");
        }
    }

    public static void main(String[] args) {
        CarManagement cm = new CarManagement();
        Scanner scanner = new Scanner(System.in);
        String choice;
        final String ADD = "1";
        final String DISPLAY = "2";
        final String EXIT = "3";
        do{
            System.out.println("menu");
            System.out.println("1.Add");
            System.out.println("2.Display");
            System.out.println("3.Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextLine();
            switch(choice) {
                case ADD: cm.add(); break;
                case DISPLAY: cm.displaySC(); break;
                case EXIT:  break;
            }
        }while(!choice.equals("3"));
    }
}
