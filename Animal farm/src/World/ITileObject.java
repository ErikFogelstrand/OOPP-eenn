package World;

public interface ITileObject {
    public void interact(IAction action);
    public boolean walkable();
}
