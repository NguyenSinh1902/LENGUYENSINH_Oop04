package ecommerce;

public class ProductManagement {
    private static final int MAX_PRODUCTS = 10;   // tránh hardcode
    private Product[] products = new Product[MAX_PRODUCTS];
    private int productCount = 0;

    // Add product
    public void addProduct(Product product) {
        if (productCount >= MAX_PRODUCTS) {
            throw new IllegalArgumentException("Cannot add more than " + MAX_PRODUCTS + " products.");
        }

        // Check for duplicate ID
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == product.getProductID()) {
                throw new IllegalArgumentException("Product ID must be unique.");
            }
        }

        products[productCount++] = product;
        System.out.println("Product added successfully.");
    }

    // Find by ID
    public Product getProductByID(int productID) throws ProductNotFoundException {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductID() == productID) {
                return products[i];
            }
        }
        throw new ProductNotFoundException("Product with ID " + productID + " not found.");
    }

    // Update product
    public void updateProductQuantity(int productID, int newQuantity) throws ProductNotFoundException {
        Product product = getProductByID(productID);
        product.setQuantityInStock(newQuantity);
        System.out.println("Product quantity updated successfully.");
    }
}
