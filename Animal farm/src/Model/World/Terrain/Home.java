package Model.World.Terrain;

import Model.Player.Player;
import Model.World.ITileAction;

public class Home extends ATerrain {

    public Home() {
        System.out.println("Honey, I am home!");
    }

    @Override
    public boolean walkable() {return false;}

    @Override
    public String tileTypeInteract(ITileAction action) {
        Player.getInstance().sleep(100);
        return "";
    }

    private String hoe(){
        return "Home";
    }
}
