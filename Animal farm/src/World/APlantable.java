package World;

public abstract class APlantable implements ITileObject {

    public boolean walkable(){return true;}
    public void interact(IInteractionType interactionType) {
        if(interactionType.getClass() == Hand){

        }
    }
}
