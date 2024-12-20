package Model.Items;
import Model.Player.Player;

// implemented by Items that can be consumed by the player
public interface IEdible {
    public void consume(Player player);
}
