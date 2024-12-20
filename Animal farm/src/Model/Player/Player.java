package Model.Player;


import Model.Inventory.InventoryHandler;
import Model.Inventory.IInventoryHolder;
import Model.Items.IEdible;
import Model.Items.Item;
import Model.World.GameSceneManager;
import Model.World.IRandomTickListener;
import Model.World.ITileAction;
import Model.World.RandomTickGenerator;
import Model.World.Terrain.ATerrain;

import java.awt.Point;


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

    // components
    private final MovementHandler playerHandler;
    private final InventoryHandler inventoryHandler;

    // instance
    private static Player player;


    // singleton
    private Player(){
        this.hunger = maxState;
        this.thirst = maxState;
        this.energy = maxState;
        this.inventoryHandler = new InventoryHandler();
        inventoryHandler.moveSelection(0,0);
        this.playerHandler = new MovementHandler( 8, 6);

        RandomTickGenerator.getInstance().addListener(this);
    }

    // get the singleton instance
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

    // Simple method to drain the players states
    private void updateStates(){
        hunger = Math.max(minState, hunger - hungerDecrease);
        thirst = Math.max(minState, thirst - thirstDecrease);
        energy = Math.max(minState, energy - energyDecrease);
    }

    @Override
    public int getHunger(){
        return hunger;
    }

    @Override
    public int getThirst(){
        return thirst;
    }

    @Override
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

    // Delegates its movement to its movementHandler and checks if it is standing on any dropped items and pick them up
    @Override
    public void move(int x, int y ){
        this.playerHandler.move(x,y);
        ATerrain terrain = getTerrain(playerHandler.getPos());
        for (Item item : terrain.getDroppedItems()){
            inventoryHandler.addItem(item);
        }
        terrain.pickUp();

    }

    public Point getPos(){
        return (playerHandler.getPos());
    }

    // Listens to RandomTickGenerator to update its  states
    @Override
    public void tick(){
        updateStates();
    }

    // Delegates inventory management to inventoryHandler
    public void selectItem(int yCoord, int xCoord) {
        inventoryHandler.moveSelection(yCoord, xCoord);
    }

    // Checks if the currently selected item is an ITileAction and delegates it to its movementHandler. If the player is not holding an ITileAction it send a "Hand" action
    @Override
    public void tileInteract(int x, int y){
        Item currentItem = getInventory().getItem(0, getInventory().getSelectedItemInHotBar()); /////////
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
                public boolean usable() {
                    return true;
                }
            });
        }
    }

    // Interactions with the players states, kind of visitor pattern
    @Override
    public void playerInteract(){
        Item currentItem = getInventory().getItem(0, getInventory().getSelectedItemInHotBar());
        if (currentItem instanceof IEdible){
            ((IEdible)currentItem).consume(this);
        }
    }

    @Override
    public void setDirection(int x, int y) {
        playerHandler.setDirection(x, y);
    }

    // used to check for dropped items
    private ATerrain getTerrain(Point pos){
        return GameSceneManager.getInstance().getActiveGameScene().getTile(pos.x, pos.y).getTerrain();
    }
}
