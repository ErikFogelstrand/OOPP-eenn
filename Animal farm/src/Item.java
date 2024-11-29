public abstract class Item {

    private IItemType itemType;
    private int quantity;
    private String name;

    public Item(IItemType itemType, int quantity, String name) {
        this.itemType = itemType;
        this.quantity = quantity;
        this.name = name;
    }

    public IItemType getItemType(){
        return itemType;
    }
    public void setItemType(IItemType itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void use() {
        if (quantity > 0) {
            itemType.use();
            quantity--;
        }

    }
    public void pickUp(int amount){
    quantity += amount;}
}

