package UsableObjects;
import Inventory.Inventory;
import Player.Player;
import World.IAction;

public abstract class Tool implements IUsableObject {
    private String name;
    public Tool(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
    @Override
    public void pickUp(Inventory inventory) {
        boolean added = inventory.addItem(this);//kommer ej åt inventory
    }

    @Override
    public abstract void use(IAction action);
    **/
}
