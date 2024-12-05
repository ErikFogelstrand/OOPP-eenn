package World;

public interface ITileType {
    public String interact(IAction action); // return string if the tileType should be switched (e.g player uses hoe on dirt)
    public boolean walkable();
}
