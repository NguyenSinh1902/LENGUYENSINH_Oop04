package ecommerce;

import java.util.Scanner;

public class Program {
    private static final int ADD_PRODUCT = 1;
    private static final int RETRIEVE_PRODUCT = 2;
    private static final int UPDATE_QUANTITY = 3;
    private static final int EXIT = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagement pm = new ProductManagement();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Product Management Menu ===");
            System.out.println(ADD_PRODUCT + ". Add Product");
            System.out.println(RETRIEVE_PRODUCT + ". Retrieve Product by ID");
            System.out.println(UPDATE_QUANTITY + ". Update Product Quantity");
            System.out.println(EXIT + ". Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case ADD_PRODUCT:
                    try {
                        Product newProduct = inputProduct(scanner);
                        pm.addProduct(newProduct);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case RETRIEVE_PRODUCT:
                    try {
                        System.out.print("Enter Product ID to retrieve: ");
                        int searchID = scanner.nextInt();

                        Product foundProduct = pm.getProductByID(searchID);
                        foundProduct.displayProductInfo();
                    } catch (ProductNotFoundException | IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case UPDATE_QUANTITY:
                    try {
                        System.out.print("Enter Product ID to update: ");
                        int updateID = scanner.nextInt();

                        System.out.print("Enter new quantity: ");
                        int newQty = scanner.nextInt();

                        pm.updateProductQuantity(updateID, newQty);
                    } catch (ProductNotFoundException | IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case EXIT:
                    System.out.println("Exiting!!!!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static Product inputProduct(Scanner scanner) {
        System.out.println("Enter product details:");

        System.out.print("Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Product Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity in Stock: ");
        int qty = scanner.nextInt();

        return new Product(id, name, price, qty);
    }
}
