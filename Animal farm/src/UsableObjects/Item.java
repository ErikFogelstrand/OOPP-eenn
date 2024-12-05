package UsableObjects;

public abstract class Item implements IItem {
    private String itemType;
    private int quantity;
    private String name;

    public Item (String itemType, int quantity, String name){
        this.itemType = itemType;
        this.quantity = quantity;
        this.name = name;
    }
    public void setItemType(String itemType){
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
   @Override
    public int getQuantity(){
        return quantity;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void pickup() {

    }
}
