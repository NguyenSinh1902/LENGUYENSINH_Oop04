package antique;

import java.util.Scanner;

public class Item {
    protected String id;      // unique
    protected int value;      // >=0
    protected String creator; // not empty

    public Item() {
    }

    public Item(String id, int value, String creator) {
        this.id = id;
        this.value = value;
        this.creator = creator;
    }

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("ID cannot be empty!");
            this.id = "UNKNOWN";
        } else {
            this.id = id.trim();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    // Input method
    public void input() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter id: ");
            setId(sc.nextLine());
        } while (this.id.equals("UNKNOWN"));

        System.out.print("Enter value: ");
        value = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter creator: ");
        creator = sc.nextLine();
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Value: %d, Creator: %s", id, value, creator);
    }
}
