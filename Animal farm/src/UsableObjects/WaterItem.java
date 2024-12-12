package UsableObjects;

public class WaterItem extends Item {

    private final int amount;
    public WaterItem(String itemType, int quantity, String name, int amount) {
        super(itemType, quantity, name);
        this.amount = amount;
    }

    public int getWetness(){
        return amount;
    }
    @Override
    public void use() {
        player.drink(amount); //måste flytta på player
    }
}

