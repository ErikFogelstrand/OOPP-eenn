package Model.Player;

import java.awt.*;

import Model.Inventory.InventoryHandler;
import Model.Inventory.IInventoryHolder;
import Model.UsableObjects.Item;
import Model.UsableObjects.Shovel;
import Model.World.IRandomTickListener;
import Model.World.ITileAction;
import Model.World.RandomTickGenerator;

public class Player implements IPlayerStates, IMovementHandler, IRandomTickListener, IInventoryHolder {

    // player states
    private int hunger;
    private int thirst;
    private int energy;

    // constrains for state updates
    private static final int maxState = 100;
    private static final int minState = 0;
    private static final int hungerDecrease = 3;
    private static final int thirstDecrease = 4;
    private static final int energyDecrease = 1;
    private final MovementHandler playerHandler;
    private final InventoryHandler inventoryHandler;

    private static Player player;


    //constructor
    private Player(){
        this.hunger = maxState;
        this.thirst = maxState;
        this.energy = maxState;
        this.inventoryHandler = new InventoryHandler();
        inventoryHandler.selectItem(0);
        this.playerHandler = new MovementHandler( 8, 6);

        RandomTickGenerator.getInstance().addListener(this);
    }

    public static Player getInstance() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    @Override
    public InventoryHandler getInventory() {
                return this.inventoryHandler;
    }

    private void updateStates(){
        hunger = Math.max(minState, hunger - hungerDecrease);
        thirst = Math.max(minState, thirst - thirstDecrease);
        energy = Math.max(minState, energy - energyDecrease);
    }

    public int getHunger(){
        return hunger;
    }

    public int getThirst(){
        return thirst;
    }

    public int getSleep(){
        return energy;
    }

    public void eat(int foodAmount){
        hunger = Math.min(maxState, hunger + foodAmount); // instead of setters
    }

    public void drink(int waterAmount){
        thirst = Math.min(maxState, thirst + waterAmount);
    }

    public void sleep(int sleepAmount){
        energy = Math.min(maxState, energy + sleepAmount);
    }

    public void move(int x, int y ){
        this.playerHandler.move(x,y);
    }

    public Point getPos(){
        return (playerHandler.getPos());
    }

    @Override
    public void tick(){
        updateStates();
    }

    public void selectItem(int xCoord) {
        inventoryHandler.selectItem(xCoord);
    }

    @Override
    public void interact(int x, int y){

        Item currentItem = getInventory().getItem(0, getInventory().getSelectedItem());
        if (currentItem instanceof ITileAction){
            playerHandler.interact(x, y, (ITileAction) currentItem);
        } else{
            playerHandler.interact(x, y, new ITileAction() {
                @Override
                public String getType() {
                    return "Hand";
                }

                @Override
                public void use() {

                }

                @Override
                public boolean useable() {
                    return true;
                }
            });
        }
    }

    @Override
    public void setDirection(int x, int y) {
        playerHandler.setDirection(x, y);
    }
}
