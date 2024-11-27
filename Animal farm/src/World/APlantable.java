package World;

import java.util.Objects;

public abstract class APlantable implements ITileObject {
    private WaterableTile waterableTile;

    public APlantable(WaterableTile waterableTile) {
    }

    public void setWaterableTile(WaterableTile waterableTile) {
        this.waterableTile = waterableTile;
    }

    public boolean walkable(){return true;}
    public void interact(IAction action) {
        if(action.getType().equals("Hand")){
            harvest();
        }
    }
    abstract void harvest();
}
