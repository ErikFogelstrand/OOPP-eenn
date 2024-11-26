package World;

public interface ITileObject {
    public void interact(IInteractionType interactionType);
    public boolean walkable();
}
