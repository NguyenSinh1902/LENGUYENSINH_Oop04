package antique;

import java.util.Scanner;

public class Vase extends Item {
    private int height;
    private String material;

    //constructor
    public Vase() {
    }

    public Vase(String id, int value, String creator, int height, String material) {
        super(id, value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height: ");
        height = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter material: ");
        material = sc.nextLine();
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(", Height: %d, Material: %s", height, material);
    }
}
