package UsableObjects;

public class SeedItem extends Item {

    private String seedType;
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

    public void pickUp() {
    }
}

