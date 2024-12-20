package Model.World.TileObjects;

import Model.Items.Item;
import Model.World.ITileAction;

import java.util.List;

public interface ITileObject {
    public List<Item> interact(ITileAction action);
    public boolean walkable();
}
