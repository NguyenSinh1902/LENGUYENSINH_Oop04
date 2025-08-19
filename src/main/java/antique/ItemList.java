package antique;

public class ItemList {
    private Item[] list;
    private int numOfItem;
    private final int MAX = 100;

    public ItemList() {
        list = new Item[MAX];
        numOfItem = 0;
    }

    public boolean addItem(Item item) {
        if (item == null || numOfItem >= MAX) {
            return false;
        }

        // Check trung id
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].id.equals(item.id)) {
                System.out.println("ID already exists, cannot add!");
                return false;
            }
        }

        list[numOfItem] = item;
        numOfItem++;
        return true;
    }


    public void displayAll() {
        if (numOfItem == 0) {
            System.out.println("No items in list.");
            return;
        }
        for (int i = 0; i < numOfItem; i++) {
            System.out.println(list[i]);
        }
    }

    public Item findItem(String creator) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getCreator().equalsIgnoreCase(creator)) {
                return list[i];
            }
        }
        return null;
    }

    public void displayItemsByType(String type) {
        for (int i = 0; i < numOfItem; i++) {
            if (type.equalsIgnoreCase("Vase") && list[i] instanceof Vase) {
                System.out.println(list[i]);
            } else if (type.equalsIgnoreCase("Statue") && list[i] instanceof Statue) {
                System.out.println(list[i]);
            } else if (type.equalsIgnoreCase("Painting") && list[i] instanceof Painting) {
                System.out.println(list[i]);
            }
        }
    }
}
