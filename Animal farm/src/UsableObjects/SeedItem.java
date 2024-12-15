package UsableObjects;
import Player.Player;
import World.IAction;


public class SeedItem extends Item {


    public String seedType;
    public SeedItem(String itemType, int quantity, String name, String seedType) {
        super(itemType, quantity,name);
        this.seedType = seedType;
    }
    public String getSeedType(){
        return seedType;
    }
    public void use() {
        // plantera
    }

}


