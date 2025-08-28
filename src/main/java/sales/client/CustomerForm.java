package sales.client;

import sales.entities.Customer;

import java.util.Scanner;

public class CustomerForm {
    private final Scanner sc;

    public CustomerForm(Scanner sc) {
        this.sc = sc;
    }

    public int getId() {
        System.out.print("Enter id: ");
        return Integer.parseInt(sc.nextLine().trim());
    }

    public Customer getCustomer() {
        Customer c = new Customer();

        System.out.print("Enter customer name: ");
        c.setName(sc.nextLine().trim());

        System.out.print("Enter contact name: ");
        c.setContact(sc.nextLine().trim());

        System.out.print("Enter address: ");
        c.setAddress(sc.nextLine().trim());

        System.out.print("Enter city: ");
        c.setCity(sc.nextLine().trim());

        System.out.print("Enter post code: ");
        c.setPostCode(sc.nextLine().trim());

        System.out.print("Enter country: ");
        c.setCountry(sc.nextLine().trim());

        return c;
    }
}
