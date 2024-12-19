package Model.UsableObjects;

import Model.World.ITileAction;


public class SeedItem extends StackableItem implements ITileAction {
    public String seedType;
    public SeedItem(String type, String seedType) {
        super(type);
        this.seedType = seedType;
    }

    @Override
    public boolean useable() {
        return true;
    }

    @Override
    public String getType(){
        return type;
    }
    public String getSeedType(){
        return seedType;
    }

    @Override
    public void use() {
        System.out.println("Planted " + seedType + " seed");
    }

}


