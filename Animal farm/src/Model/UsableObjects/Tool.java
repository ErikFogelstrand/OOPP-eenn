package Model.UsableObjects;
import Model.World.ITileAction;

public abstract class Tool extends StackableItem implements ITileAction {

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
