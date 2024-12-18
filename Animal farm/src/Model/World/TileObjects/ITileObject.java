package Model.World.TileObjects;

import Model.World.IAction;

public interface ITileObject {
    public void interact(IAction action);
    public boolean walkable();
}
