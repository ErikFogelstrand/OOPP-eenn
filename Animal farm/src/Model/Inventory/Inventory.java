package Model.Inventory;

import Model.UsableObjects.Item;

import java.util.Optional;
public class Inventory{
    private static final int y = 6; // rows
    private static final int x = 5; // columns
    private Item[][] inventory;

    public Inventory() {
        this.inventory = new Item[y][x]; // Item[rows][columns]
    }

    public boolean addItem(Item newItem){
        for(int i = 0; i < y; i++){ // iterate over rows
            for(int j = 0; j < x; j++){ // iterate over columns
                if (inventory[i][j] != null && inventory[i][j].getName().equals(newItem.getName())){
                    //inventory[i][j].add(newItem.getQuantity());
                    return true;
                } else if (inventory[i][j] == null){
                    inventory[i][j] = newItem;
                    return true;
                }
            }
        }

        return false; // om inventory fullt
        }

    private boolean isValidSlot(int yCoord, int xCoord) {
        return yCoord >= 0 && yCoord < y && xCoord >= 0 && xCoord < x;
    }

    public int getRows(){return y;}

    public int getColumns(){return x;}

    public Optional<Item> getItem(int yCoord, int xCoord){
        if (isValidSlot(yCoord,xCoord)){
            return Optional.ofNullable(inventory[yCoord][xCoord]);
        }
        return Optional.empty();
        }

    public Item[][] getAllItems() {
        return inventory;
    }

    public Optional<Item> selectItem(int xCoord){
        if (isValidSlot(0,xCoord)){
            return Optional.ofNullable(inventory[0][xCoord]);
        }
        return Optional.empty();
    }
}

