package antique;

import java.util.Scanner;

public class AntiqueShop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemList itemList = new ItemList();
        String choice;
        final String ADD_VASE = "1";
        final String ADD_STATUE = "2";
        final String ADD_PAINTING = "3";
        final String DISPLAY_ALL = "4";
        final String FIND_BY_CREATOR = "5";
        final String DISPLAY_BY_TYPE = "6";
        final String QUIT = "7";

        do {
            System.out.println("\n--- Antique Shop Menu ---");
            System.out.println("1. Add a new Vase");
            System.out.println("2. Add a new Statue");
            System.out.println("3. Add a new Painting");
            System.out.println("4. Display all items");
            System.out.println("5. Find items by creator");
            System.out.println("6. Display items by type");
            System.out.println("7. Quit");
            System.out.print("Your choice: ");
            choice = sc.nextLine();

            switch (choice) {
                case ADD_VASE:
                    Vase v = new Vase();
                    v.input();
                    if (itemList.addItem(v)) System.out.println("Vase added!");
                    else System.out.println("Failed to add Vase!");
                    break;

                case ADD_STATUE:
                    Statue s = new Statue();
                    s.input();
                    if (itemList.addItem(s)) System.out.println("Statue added!");
                    else System.out.println("Failed to add Statue!");
                    break;

                case ADD_PAINTING:
                    Painting p = new Painting();
                    p.input();
                    if (itemList.addItem(p)) System.out.println("Painting added!");
                    else System.out.println("Failed to add Painting!");
                    break;

                case DISPLAY_ALL:
                    itemList.displayAll();
                    break;

                case FIND_BY_CREATOR:
                    System.out.print("Enter creator name: ");
                    String creator = sc.nextLine();
                    Item found = itemList.findItem(creator);
                    if (found != null) System.out.println("Found: " + found);
                    else System.out.println("No item found!");
                    break;

                case DISPLAY_BY_TYPE:
                    System.out.print("Enter type (Vase/Statue/Painting): ");
                    String type = sc.nextLine();
                    itemList.displayItemsByType(type);
                    break;

                case QUIT:
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (!choice.equals(QUIT));

        sc.close();
    }
}
