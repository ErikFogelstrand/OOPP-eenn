package UsableObjects;
import Inventory.Inventory;
import World.IAction;

public abstract class Tool extends Storable implements IAction{

    public String type;
    public Tool(String name, String type) {
        super(name);
        this.type = type;
    }

    public String getType(){
        return type;
    }

    @Override
    public abstract void use();

    public boolean useable(){
        return true;
    }
}
