package Model.World.Terrain;

import Model.Items.Item;
import Model.Items.StackableItem;
import Model.Items.Tool;
import Model.World.ITileAction;
import Model.World.TileObjects.ITileObject;

import java.util.ArrayList;
import java.util.List;

// The terrain of a tile, holds a tileObject on top of it, as well as dropped items
public abstract class ATerrain {
    protected ITileObject tileObject;
    protected final List<Item> droppedItems;

    public ATerrain() {
        droppedItems = new ArrayList<>();
    }
    public abstract boolean walkable();

    // Uses template pattern, it prioritises the tileObject if it has one then calls for the specific implementation of the subclass
    public String interact(ITileAction action){
        if(tileObject != null){
            List<Item> droppedItem = tileObject.interact(action);
            if (droppedItem != null){
                for (Item item : droppedItem){
                    dropItem(item);
                }
            }
            return "";
        }
        return tileTypeInteract(action);
    }

    // the specific implementation of the subclass for template pattern
    protected abstract String tileTypeInteract(ITileAction action);


    public ITileObject getTileObject(){
        return tileObject;
    }

    public void setTileObject(ITileObject object){
        tileObject = object;
    }

    // Add an item to the dropped items list
    private void dropItem(Item item){
        int itemPos = droppedItemsFind(item);
        if(item instanceof Tool || itemPos == -1){
            droppedItems.add(item);
            return;
        }

        ((StackableItem) droppedItems.get(itemPos)).changeQuantity(((StackableItem) item).getQuantity());
    }

    // Finds the index for a specific item in the dropped items list
    private int droppedItemsFind(Item item){
        for (int i = 0; i < droppedItems.size(); i++){
            if (droppedItems.get(i).getType().equals(item.getType())){
                return i;
            }
        }
        return -1;
    }
    public List<Item> getDroppedItems(){
        return droppedItems;
    }

    // All dropped items are picked up at once
    public void pickUp(){
        droppedItems.clear();
    }

}
