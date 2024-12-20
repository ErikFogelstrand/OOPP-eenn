package Model.Items;
import Model.Player.Player;

public class WateringCan extends Tool implements IEdible {
    private int waterLevel;
    private final int maxWaterLevel = 5;

    public WateringCan() {
        super("WateringCan");
        this.waterLevel = maxWaterLevel;
    }

    @Override
    public void use() {
        waterLevel = Math.max(0, waterLevel-1);
    }

    public int getWaterLevel(){
        return waterLevel;
    }

    @Override
    public void consume(Player player) {
        player.drink(10);
    }

    // not used at the moment as there is no way to refill it
    @Override
    public boolean usable(){
        return waterLevel >= 1;
    }

}

