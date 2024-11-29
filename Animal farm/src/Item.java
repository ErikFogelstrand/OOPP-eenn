import World.IAction;

public class Item implements IAction {
    private int quantity;
    private final String itemName;

    public Item(int quantity, String itemName) {
        this.quantity = quantity;
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void add(int quantity) {
        this.quantity += quantity;
    }

    public String getName() {
        return itemName;
    }

    @Override
    public String getType() {
        return getName();
    }

}

