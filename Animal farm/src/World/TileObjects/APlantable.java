package World.TileObjects;

import World.IAction;
import World.IRandomTickListener;
import World.ITileObject;
import World.IWaterableTile;

public abstract class APlantable implements ITileObject, IRandomTickListener {
    private IWaterableTile waterableTile;
    private boolean watered;
    protected int growthState;


    public void setWaterableTile(IWaterableTile waterableTile) {
        this.waterableTile = waterableTile;
    }

    public boolean walkable(){return true;}
    public void interact(IAction action) {
        if(action.getType().equals("Hand")){
            harvest();
        }
        else if(action.getType().equals("Water")){
            water();
        }
    }
    protected void harvest(){
        setWaterableTile(null);
    }
    private void water(){
        watered = true;
    }
    public void tick(){
        if(watered){
            waterableTile.setWatered(false);
            watered = false;
            growthState--;
        }
    }
}