package Model.World.TileObjects;

import Model.UsableObjects.Item;
import Model.UsableObjects.StackableItemHolder;
import Model.World.ITileAction;

public interface ITileObject {
    public StackableItemHolder interact(ITileAction action);
    public boolean walkable();
}
