package Model.UsableObjects;
import Model.Player.Player;
import Model.World.ITileAction;

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
        player.drink(waterLevel);
    }

    @Override
    public boolean useable(){
        return waterLevel >= 1;
    }

}

