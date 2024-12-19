package Model.Inventory;

import Model.UsableObjects.StackableItem;

import java.util.Optional;
public class InventoryHandler {
    private static final int y = 6; // rows
    private static final int x = 5; // columns
    private final StackableItem[][] inventory;

    public InventoryHandler() {
        this.inventory = new StackableItem[y][x]; // Item[rows][columns]
    }

    public boolean addItem(StackableItem newStackableItem){
        for(int i = 0; i < y; i++){ // iterate over rows
            for(int j = 0; j < x; j++){ // iterate over columns
                if (inventory[i][j] != null && inventory[i][j].getName().equals(newStackableItem.getName())){
                    //inventory[i][j].add(newItem.getQuantity());
                    return true;
                } else if (inventory[i][j] == null){
                    inventory[i][j] = newStackableItem;
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

    public Optional<StackableItem> getItem(int yCoord, int xCoord){
        if (isValidSlot(yCoord,xCoord)){
            return Optional.ofNullable(inventory[yCoord][xCoord]);
        }
        return Optional.empty();
        }

    public StackableItem[][] getAllItems() {
        return inventory;
    }

    public Optional<StackableItem> selectItem(int xCoord){
        if (isValidSlot(0,xCoord)){
            return Optional.ofNullable(inventory[0][xCoord]);
        }
        return Optional.empty();
    }
}

