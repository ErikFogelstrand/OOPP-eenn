package World.TileObjects;

import Jagbehöverettpaketförattnåklasserna.RandomTickGenerator;
import World.IAction;
import World.IRandomTickListener;
import World.ITileObject;
import World.IWaterableTile;

public abstract class APlantable implements ITileObject, IRandomTickListener {
    private IWaterableTile waterableTile;
    private boolean watered;
    protected int growthState;
    public APlantable(){
        RandomTickGenerator.getInstance().addListener(this);
    }

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
