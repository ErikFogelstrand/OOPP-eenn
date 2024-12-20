package Model.World.Terrain;

import Model.UsableObjects.StackableItemHolder;
import Model.World.ITileAction;
import Model.World.TileObjects.ITileObject;

import java.util.ArrayList;
import java.util.List;

public abstract class ATerrain {
    protected ITileObject tileObject;
    protected final List<StackableItemHolder> droppedItems;

    public ATerrain() {
        droppedItems = new ArrayList<>();
    }
    public abstract boolean walkable();
    public String interact(ITileAction action){
        if(tileObject != null){
            StackableItemHolder droppedItem = tileObject.interact(action);
            if (droppedItem != null){
                dropItem(droppedItem);
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
    private void dropItem(StackableItemHolder itemHolder){
        int itemPos = droppedItemsFind(itemHolder);
        if (itemPos >= 0){
            droppedItems.get(itemPos).changeQuantity(itemHolder.getQuantity());
        } else{
            droppedItems.add(itemHolder);
        }
    }

    private int droppedItemsFind(StackableItemHolder newItemHolder){
        for (int i = 0; i < droppedItems.size(); i++){
            if (droppedItems.get(i).getItem().getType().equals(newItemHolder.getItem().getType())){
                return i;
            }
        }
        return -1;
    }
    public List<StackableItemHolder> getDroppedItems(){
        return droppedItems;
    }

    public void pickUp(){
        droppedItems.clear();
    }

}
