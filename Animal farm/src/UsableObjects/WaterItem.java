package UsableObjects;

public class WaterItem extends Item {

    private int wetness;
    public WaterItem(String itemType, int quantity, String name, int wetness) {
        super(itemType, quantity, name);
        this.wetness = wetness;
    }


    public void use() {
        // dricka
    }
    public void pickUp() {
    }
}


}
