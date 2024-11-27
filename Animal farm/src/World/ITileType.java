package World;

public interface ITileType {
    public void interact(IAction action);
    public boolean walkable();
}
