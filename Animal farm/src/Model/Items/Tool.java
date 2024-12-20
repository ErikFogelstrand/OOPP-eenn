package Model.Items;
import Model.World.ITileAction;

// Tools of the same type can't stack
public abstract class Tool extends Item implements ITileAction {
    public Tool(String type) {
        super(type);
    }

    @Override
    public abstract void use();

    @Override
    public boolean usable(){
        return true;
    }
}
