package Inventory;

import UsableObjects.Item;

import java.util.Optional;
public class Inventory {
    private static final int rows = 5;
    private static final int columns = 4;
    public Item[][] inventory;

    public Inventory() {
        this.inventory = new Item[rows][columns];
    }

    public boolean addItem(Item newItem){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
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
    private boolean isValidSlot(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public int getRows(){return rows;}

    public int getColumns(){return columns;}

    public Optional<Item> getItem(int row, int column){
        if (isValidSlot(row,column)){
            return Optional.ofNullable(inventory[row][column]);
        }
        return Optional.empty();
        }
    }

