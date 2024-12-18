package World.TileObjects;

import World.RandomTickGenerator;
import World.IAction;
import World.IRandomTickListener;
import World.ITileObject;
import World.IWaterableTile;

public abstract class APlantable implements ITileObject, IRandomTickListener {
    private IWaterableTile waterableTile;
    private boolean watered;
    protected int growthState;
    protected int maxGrowth;
    protected APlantable(int maxGrowth){
        RandomTickGenerator.getInstance().addListener(this);
        this.maxGrowth = maxGrowth;
    }
    public int getGrowthState(){return growthState;}
    public void setWaterableTile(IWaterableTile waterableTile) {
        this.waterableTile = waterableTile;
    }

    public boolean walkable(){return true;}
    public void interact(IAction action) {
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
        setWaterableTile(null);
        RandomTickGenerator.getInstance().removeListener(this);
        
    }


    private void water(){
        if(growthState >= maxGrowth){
            return;
        }
        watered = true;
    }
    public void tick(){
        if(!watered || growthState >= maxGrowth){
            return;
        }
        waterableTile.setWatered(false);
        watered = false;
        growthState++;
    }
}
