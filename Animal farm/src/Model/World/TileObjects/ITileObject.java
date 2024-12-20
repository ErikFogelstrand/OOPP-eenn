package Model.World.TileObjects;

import Model.UsableObjects.Item;
import Model.World.ITileAction;

public interface ITileObject {
    public Item interact(ITileAction action);
    public boolean walkable();
}
