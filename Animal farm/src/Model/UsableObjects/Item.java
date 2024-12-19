package Model.UsableObjects;

import Model.Inventory.InventoryHandler;
import Model.Player.Player;


public abstract class Item implements IEdibleObject {
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


    public int getQuantity(){
        return quantity;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }


    @Override
    public void pickUp(InventoryHandler inventoryHandler) {
        boolean added = inventoryHandler.addItem(this);//kommer ej åt inventory
    }


    @Override
    public abstract void use(Player player);
}

