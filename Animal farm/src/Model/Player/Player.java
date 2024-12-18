package Model.Player;

import java.awt.*;

import Model.Inventory.Inventory;
import Model.Inventory.IInventoryHolder;
import Model.World.IRandomTickListener;
import Model.World.RandomTickGenerator;

public class Player implements IStates, IPlayerPos, IRandomTickListener, IInventoryHolder {

    // player states
    private int hunger;
    private int thirst;
    private int energy;

    // constrains for state updates
    private static final int maxState = 100;
    private static final int minState = 0;
    private static final int hungerDecrease = 3;
    private static final int thirstDecrease = 4;
    private static final int energyDecrease = 2;
    private final PlayerMovementHandler playerHandler;
    private final Inventory inventory;

    private static Player player;


    //constructor
    private Player(){
        this.hunger = maxState;
        this.thirst = maxState;
        this.energy = maxState;

        this.inventory = new Inventory();

        this.playerHandler = new PlayerMovementHandler( 8, 6);

        RandomTickGenerator.getInstance().addListener(this);
    }

    public static Player getInstance() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    @Override
    public Inventory getInventory() {
                return this.inventory;
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
        inventory.selectItem(xCoord).ifPresent(item -> {
            System.out.println("Selected item: " + item.getName());
            // Perform item-related actions here
        });
    }
}