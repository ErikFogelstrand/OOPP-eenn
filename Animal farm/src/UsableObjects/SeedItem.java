package UsableObjects;
import Player.Player;
import World.IAction;


public class SeedItem extends Item implements IAction {
    public String seedType;
    public String type;
    public SeedItem(String itemType, String name, String seedType) {
        super(name);
        this.seedType = seedType;
    }

    @Override
    public boolean useable() {
        return true;
    }
    public String getType(){
        return type;
    }
    public String getSeedType(){
        return seedType;
    }
    public void use() {
        System.out.println("Planted " + seedType + " seed");
    }

}


