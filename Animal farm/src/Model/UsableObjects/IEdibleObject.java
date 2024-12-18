package Model.UsableObjects;
import Model.Player.Player;
import Model.Inventory.Inventory;


// Interface för både items och tools
public interface IEdibleObject {
    void use(Player Player);
    void pickUp(Inventory inventory);
}