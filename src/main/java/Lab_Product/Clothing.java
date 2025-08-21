package Lab_Product;

public class Clothing extends Product {
    private String size;

    public Clothing(int id, String name, float price, String size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("Clothing [ID=" + id + ", Name=" + name +
                ", Price=" + price + ", Size=" + size + "]");
    }
}
