package Collections;

import java.util.ArrayList;

public class Demo02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        String searchElement = "apple";
        boolean found = false;

        // find the element (found or not found)
        for (String str : list) {
            if (str.equals(searchElement)) {
                System.out.println("Found: " + str);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not found: " + searchElement);
        }
    }
}
