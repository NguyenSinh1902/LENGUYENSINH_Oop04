package Test_Constructor;

public class Car {
    String id;
    String name;
    int size;
    boolean pin;

    public Car(String id, String name, int size, boolean pin){
        this.id = id;
        this.name = name;
        this.size = size;
        this.pin = pin;
    }

    public void display(){
        System.out.println("ID: " + id + " Name: " + name + " Size: " + size + " Pin: " + pin);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + size + " " + pin;
    }
}
