package Lab_Product;

public class Electronics extends Product {
    private String brand;

    public Electronics(int id, String name, float price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronics [ID=" + id + ", Name=" + name +
                ", Price=" + price + ", Brand=" + brand + "]");
    }
}
