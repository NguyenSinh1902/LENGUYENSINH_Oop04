package modifiers;

public class Counter {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5};

        try {
            for (int i = 0; i <= array.length; i++) {
                System.out.println("Element at Index: " + i + ": " + array[i]);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e);
        }

        System.out.println("End!!!!!");
    }
}
