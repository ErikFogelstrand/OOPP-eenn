package Model.World.TileObjects;

import Model.UsableObjects.CarrotItem;
import Model.UsableObjects.FoodItem;
import Model.UsableObjects.Item;
import Model.World.RandomTickGenerator;
import Model.World.ITileAction;
import Model.World.IRandomTickListener;

public abstract class APlantableTileObject implements ITileObject, IRandomTickListener {
    private boolean watered;
    private int growthState;
    private final int maxGrowth;
    private final String type;
    protected APlantableTileObject(int maxGrowth, String type){
        RandomTickGenerator.getInstance().addListener(this);
        this.maxGrowth = maxGrowth;
        growthState = 0;
        this.type = type;
    }
    public int getGrowthState(){return growthState;}
    public boolean getWatered(){return watered;}

    @Override
    public boolean walkable(){return true;}

    @Override
    public Item interact(ITileAction action) {
        if(action.getType().equals("Hand")){
            action.use();
            return harvest();
        }
        else if(action.getType().equals("WateringCan")){
            water();
            action.use();
        }
        return null;
    }

    private Item harvest(){
        if (growthState < maxGrowth){
            return null;
        }
        RandomTickGenerator.getInstance().removeListener(this);
        return new CarrotItem(1);
    }

    private void water(){
        if(growthState >= maxGrowth){
            return;
        }
        watered = true;
    }

    @Override
    public void tick(){
        if(!watered || growthState >= maxGrowth){
            return;
        }
        watered = false;
        growthState++;
    }

    private String getType(){
        return type;
    }
}
