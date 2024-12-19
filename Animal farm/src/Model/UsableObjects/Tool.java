package Model.UsableObjects;
import Model.World.ITileAction;

public abstract class Tool extends StackableItem implements ITileAction {
    public Tool(String type) {
        super(type);
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public abstract void use();

    @Override
    public boolean useable(){
        return true;
    }
}
