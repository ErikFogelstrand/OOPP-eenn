package World;

public class PlantableDirt implements ITileType, WaterableTile{
    private boolean watered;

    public PlantableDirt() {
        watered = false;
    }

    public boolean walkable() {return true;}

    public void interact(IAction action) {
        if(action.getType().equals("Seed")){
            plant();
        }
    }
    private void plant(){
        //hitta vad det är för seed och plantera
    }

    public boolean getWatered() {
        return watered;
    }
    public void setWatered(boolean watered) {
        this.watered = watered;
    }
}
