package World;

public class Dirt implements ITileType{

    @Override
    public boolean walkable() {return true;}

    @Override
    public void interact(IAction action) {
        if(action.getType().equals("Hoe")){
            hoe();
        }
    }
    private void hoe(){
        //gör om till plantable dirt
    }
}
