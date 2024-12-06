package UsableObjects;

public class WaterItem extends Item {

    private final int wetness;
    public WaterItem(String itemType, int quantity, String name, int wetness) {
        super(itemType, quantity, name);
        this.wetness = wetness;
    }

    public int getWetness(){
        return wetness;
    }
    @Override
    public void use() {
        // player.drink(wetness); måste slytta på player
    }
    @Override
    public void pickUp() {
        //lä till in inventory
    }
}

