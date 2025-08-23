package ecommerce;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int quantityInStock;

    public Product(int productID, String name, double price, int quantityInStock) {
        this.setProductID(productID);
        this.setName(name);
        this.setPrice(price);
        this.setQuantityInStock(quantityInStock);
    }

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

    public void displayProductInfo() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity in Stock: " + quantityInStock);
    }
}
