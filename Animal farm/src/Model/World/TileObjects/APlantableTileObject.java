package Model.World.TileObjects;

import Model.World.RandomTickGenerator;
import Model.World.ITileAction;
import Model.World.IRandomTickListener;

public abstract class APlantableTileObject implements ITileObject, IRandomTickListener {
    private boolean watered;
    private int growthState;
    private int maxGrowth;
    protected APlantableTileObject(int maxGrowth){
        RandomTickGenerator.getInstance().addListener(this);
        this.maxGrowth = maxGrowth;
        growthState = 0;
    }
    public int getGrowthState(){return growthState;}
    public boolean getWatered(){return watered;}

    @Override
    public boolean walkable(){return true;}

    @Override
    public void interact(ITileAction action) {
        if(action.getType().equals("Hand")){
            harvest();
            action.use();
        }
        else if(action.getType().equals("WateringCan")){
            water();
            action.use();
        }
    }

    private void harvest(){
        RandomTickGenerator.getInstance().removeListener(this);
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
}
