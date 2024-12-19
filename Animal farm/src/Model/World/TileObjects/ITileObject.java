package Model.World.TileObjects;

import Model.World.ITileAction;

public interface ITileObject {
    public void interact(ITileAction action);
    public boolean walkable();
}
