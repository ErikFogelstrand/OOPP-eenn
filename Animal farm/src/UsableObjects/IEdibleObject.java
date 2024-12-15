package UsableObjects;
import Player.Player;
import Inventory.Inventory;


// Interface för både items och tools
public interface IEdibleObject {
    void use(Player Player);
    void pickUp(Inventory inventory);
}