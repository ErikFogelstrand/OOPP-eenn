package Model.World.TileObjects;

import Model.UsableObjects.Item;
import Model.World.ITileAction;

import java.util.List;

public interface ITileObject {
    public List<Item> interact(ITileAction action);
    public boolean walkable();
}
