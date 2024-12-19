package Model.UsableObjects;
import Model.Player.Player;

public class WaterItem extends StackableItem implements IEdible {

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

