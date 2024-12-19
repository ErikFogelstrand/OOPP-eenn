package UsableObjects;
import Player.Player;

public class WaterItem extends Item implements IEdible {

    private final int amount;
    public WaterItem(String itemType, int quantity, String name, int amount) {
        super(name);
        this.amount = amount;
    }

    public int getWetness(){
        return amount;
    }
    @Override
    public void consume(Player player) {
        player.drink(amount);
    }
}

