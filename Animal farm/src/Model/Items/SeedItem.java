package Model.Items;

import Model.World.ITileAction;


public class SeedItem extends StackableItem implements ITileAction {
    public String seedType;
    public SeedItem(String seedType, int quantity) {
        super("Seed", quantity);
        this.seedType = seedType;
    }

    @Override
    public boolean usable() {
        return true;
    }

    public String getSeedType(){
        return seedType;
    }

    @Override
    public void use() {
        changeQuantity(-1);
    }

}


