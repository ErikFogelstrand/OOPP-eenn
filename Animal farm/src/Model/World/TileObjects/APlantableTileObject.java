package Model.World.TileObjects;

import Model.Items.CarrotItem;
import Model.Items.Item;
import Model.Items.SeedItem;
import Model.World.RandomTickGenerator;
import Model.World.ITileAction;
import Model.World.IRandomTickListener;

import java.util.ArrayList;
import java.util.List;

// Represent the core function of crops
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
    public List<Item> interact(ITileAction action) {
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

    private List<Item> harvest(){
        if (growthState < maxGrowth){
            return null;
        }
        RandomTickGenerator.getInstance().removeListener(this);
        List<Item> dropItems = new ArrayList<>();
        dropItems.add(new CarrotItem(1));
        dropItems.add(new SeedItem(getType(), 2));
        return dropItems;
    }

    // Needs to be watered to be able to grow
    private void water(){
        if(growthState >= maxGrowth){
            return;
        }
        watered = true;
    }

    // Is a listener to RandomTickGenerator to update its growthstate
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
