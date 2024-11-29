package Tools;

import World.IAction;

public abstract class Tool implements IAction {
    protected String toolName;

    public String getType() {return toolName;}
    abstract public boolean use(); // returns true if the player is able to use the tool
}
