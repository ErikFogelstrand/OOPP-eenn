package Model.Inventory;

import Model.UsableObjects.*;

import java.util.Optional;
public class InventoryHandler {
    private static final int y = 6; // rows
    private static final int x = 5; // columns
    private final Item[][] inventory;
    private int selectedItemInHotBar;
    private Item selectedItem;
    private int selectedX = 0;
    private int selectedY = 0;

    public InventoryHandler() {
        this.inventory = new Item[y][x]; // Item[rows][columns]
        addItem(new CarrotItem(1));
        addItem(new SeedItem("Carrot", 1));
        addItem(new WateringCan());
        addItem(new Hoe());
        addItem(new Shovel());
    }

    // add object to first available slot
    public boolean addItem(Item newItem){
        for(int i = 0; i < y; i++){ // iterate over rows
            for(int j = 0; j < x; j++){ // iterate over columns
                if (inventory[i][j] == null) { // Check if the slot is empty
                    inventory[i][j] = newItem; // Add the item to the empty slot
                    return true;
                }
                if(newItem instanceof Tool){
                    continue;
                }

                StackableItem stackableItem = (StackableItem) newItem;

                if (inventory[i][j] != null && inventory[i][j] instanceof StackableItem && inventory[i][j].getType().equals(stackableItem.getType())){
                    ((StackableItem) inventory[i][j]).changeQuantity(stackableItem.getQuantity());
                    System.out.println(((StackableItem)inventory[i][j]).getType() + " " + ((StackableItem)inventory[i][j]).getQuantity());
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

    public Item getItem(int yCoord, int xCoord){
         update();

        if (isValidSlot(yCoord,xCoord)){
            return inventory[yCoord][xCoord];
        }
        return null;
        }

    //public Item[][] getAllItems() {
    //    return inventory;
    //}

    public void selectItemInHotBar(int xCoord){
        if (isValidSlot(0,xCoord)){
            selectedItemInHotBar = xCoord;
        }
    }

    public void moveSelection(int newY, int newX) {
        if (isValidSlot(newY, newX)) {
            selectedY = newY;
            selectedX = newX;
        }
    }

    public void changeSelectedItem(){
        if(selectedItem == null){
            pickUpSelectedItem();
        }else {
            putDownSelectedItem();
        }
    }
    private void pickUpSelectedItem(){
        selectedItem = inventory[selectedY][selectedX];
        inventory[selectedY][selectedX] = null;
    }

    private void putDownSelectedItem(){
        if (inventory[selectedY][selectedX] == null){
            inventory[selectedY][selectedX] = selectedItem;
            selectedItem = null;
        } else{
            Item newSelectedItem = inventory[selectedY][selectedX];
            if(newSelectedItem.getType().equals(selectedItem.getType()) && newSelectedItem instanceof StackableItem && selectedItem instanceof StackableItem){
                ((StackableItem)inventory[selectedY][selectedX]).changeQuantity(((StackableItem) selectedItem).getQuantity());
                selectedItem = null;
                return;
            }
            inventory[selectedY][selectedX] = selectedItem;
            selectedItem = newSelectedItem;
        }
    }

    public Item getSelectedItem(){
        return selectedItem;
    }

    public int getSelectedX() {
        return selectedX;
    }

    public int getSelectedY() {
        return selectedY;
    }

    public int getSelectedItemInHotBar(){
        return selectedItemInHotBar;
    }

    private void update(){
        for(int y = 0; y < getRows();y++){
            for(int x = 0; x < getColumns(); x++){
                if(inventory[y][x] instanceof StackableItem && ((StackableItem) inventory[y][x]).getQuantity() <= 0){
                    removeItemFromInventory(x, y);
                }
            }
        }
    }

    private void removeItemFromInventory(int x, int y){
        inventory[y][x] = null;
    }
}

