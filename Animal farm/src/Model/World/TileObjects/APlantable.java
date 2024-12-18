package Model.World.TileObjects;

import Model.World.RandomTickGenerator;
import Model.World.IAction;
import Model.World.IRandomTickListener;

public abstract class APlantable implements ITileObject, IRandomTickListener {
    private boolean watered;
    private int growthState;
    private int maxGrowth;
    protected APlantable(int maxGrowth){
        RandomTickGenerator.getInstance().addListener(this);
        this.maxGrowth = maxGrowth;
    }
    public int getGrowthState(){return growthState;}

    @Override
    public boolean walkable(){return true;}

    @Override
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
