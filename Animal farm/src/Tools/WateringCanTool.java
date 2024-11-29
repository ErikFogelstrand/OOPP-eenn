package Tools;

public class WateringCanTool extends Tool {
    private int waterLevel;

    private final int maxWaterLevel = 5;

    public void wateringCanTool() {
        toolName = "WateringCan";
        waterLevel = maxWaterLevel;
    }

    @Override
    public boolean use() {
        if(waterLevel > 0){
            waterLevel--;
            return true;
        }
        return false;
    }

    public void refill(){
        waterLevel = maxWaterLevel;
    }
}
