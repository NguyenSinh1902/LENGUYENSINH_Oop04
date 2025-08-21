package Lab_Product;

import java.util.Scanner;

public class Program {
    private Product[] products;
    private byte numOfProduct;
    private static final byte MAX = 100;

    public Program() {
        products = new Product[MAX];
        numOfProduct = 0;
    }

    public void addProduct(Product product) {
        if (numOfProduct < MAX) {
            products[numOfProduct++] = product;
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Product list is full!");
        }
    }

    public void displayProducts() {
        if (numOfProduct == 0) {
            System.out.println("No products available.");
            return;
        }
        for (int i = 0; i < numOfProduct; i++) {
            products[i].displayInfo(); // polymorphism
        }
    }

    public Product findProduct(int id) {
        for (int i = 0; i < numOfProduct; i++) {
            if (products[i].getId() == id) {
                return products[i];
            }
        }
        return null;
    }

    // kiem tra trung id
    private boolean isIdExists(int id) {
        for (int i = 0; i < numOfProduct; i++) {
            if (products[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    // input Product
    private ProductData inputBasicProductInfo(Scanner scanner) {
        int id;
        while (true) {
            System.out.print("Enter ID (positive integer, not duplicate): ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (id > 0 && !isIdExists(id)) {
                    break;
                } else {
                    System.out.println("ID must be > 0 and unique. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // clear invalid input
            }
        }

        String name;
        while (true) {
            System.out.print("Enter Name: ");
            name = scanner.nextLine().trim();
            if (!name.isEmpty()) break;
            System.out.println("Name cannot be empty. Try again.");
        }

        float price;
        while (true) {
            System.out.print("Enter Price (>0): ");
            if (scanner.hasNextFloat()) {
                price = scanner.nextFloat();
                scanner.nextLine();
                if (price > 0) break;
                else System.out.println("Price must be > 0. Try again.");
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        return new ProductData(id, name, price);
    }

    private static class ProductData {
        int id;
        String name;
        float price;

        ProductData(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Program p = new Program();
        Scanner scanner = new Scanner(System.in);
        int choice;

        final int ADD_ELECTRONICS = 1;
        final int ADD_CLOTHING = 2;
        final int DISPLAY_PRODUCTS = 3;
        final int FIND_PRODUCT = 4;
        final int EXIT = 0;

        do {
            System.out.println("\n--- E-commerce Menu ---");
            System.out.println(ADD_ELECTRONICS + ". Add Electronics");
            System.out.println(ADD_CLOTHING + ". Add Clothing");
            System.out.println(DISPLAY_PRODUCTS + ". Display Products");
            System.out.println(FIND_PRODUCT + ". Find Product");
            System.out.println(EXIT + ". Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Enter a number.");
                scanner.nextLine();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case ADD_ELECTRONICS:
                    ProductData e = p.inputBasicProductInfo(scanner);
                    System.out.print("Enter Brand: ");
                    String brand = scanner.nextLine();
                    p.addProduct(new Electronics(e.id, e.name, e.price, brand));
                    break;

                case ADD_CLOTHING:
                    ProductData c = p.inputBasicProductInfo(scanner);
                    System.out.print("Enter Size: ");
                    String size = scanner.nextLine();
                    p.addProduct(new Clothing(c.id, c.name, c.price, size));
                    break;

                case DISPLAY_PRODUCTS:
                    p.displayProducts();
                    break;

                case FIND_PRODUCT:
                    System.out.print("Enter ID to find: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine();
                    }
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    Product found = p.findProduct(searchId);
                    if (found != null) {
                        found.displayInfo();
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case EXIT:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != EXIT);

        scanner.close();
    }
}
