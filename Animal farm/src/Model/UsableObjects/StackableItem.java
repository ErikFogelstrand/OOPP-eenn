package Model.UsableObjects;


public abstract class StackableItem extends Item {
    private int quantity;

    public StackableItem(String type, int quantity){
        super(type);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void changeQuantity(int amount){
        quantity = Math.max(0, quantity+amount);
    }
}

