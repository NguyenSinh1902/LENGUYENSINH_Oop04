package ecommerce;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int quantityInStock;

    // Constructor
    public Product(int productID, String name, double price, int quantityInStock) {
        if (productID <= 0) {
            throw new IllegalArgumentException("Product ID must be greater than 0.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }

        if (price < 0) {
            throw new IllegalArgumentException("Price must be non-negative.");
        }

        if (quantityInStock < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative.");
        }

        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    // Getters and Setters
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        if (productID <= 0) {
            throw new IllegalArgumentException("Product ID must be greater than 0.");
        }
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be non-negative.");
        }
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        if (quantityInStock < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative.");
        }
        this.quantityInStock = quantityInStock;
    }

    // Display product
    public void displayProductInfo() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity in Stock: " + quantityInStock);
    }
}
