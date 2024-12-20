package Model.World.Terrain;

import Model.UsableObjects.Item;
import Model.UsableObjects.StackableItem;
import Model.UsableObjects.Tool;
import Model.World.ITileAction;
import Model.World.TileObjects.ITileObject;

import java.util.ArrayList;
import java.util.List;

public abstract class ATerrain {
    protected ITileObject tileObject;
    protected final List<Item> droppedItems;

    public ATerrain() {
        droppedItems = new ArrayList<>();
    }
    public abstract boolean walkable();
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
    protected abstract String tileTypeInteract(ITileAction action);


    public ITileObject getTileObject(){
        return tileObject;
    }

    public void setTileObject(ITileObject object){
        tileObject = object;
    }

    private void dropItem(Item item){
        int itemPos = droppedItemsFind(item);
        if(item instanceof Tool || itemPos == -1){
            droppedItems.add(item);
            return;
        }

        ((StackableItem) droppedItems.get(itemPos)).changeQuantity(((StackableItem) item).getQuantity());
    }

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

    public void pickUp(){
        droppedItems.clear();
    }

}
