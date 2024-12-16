import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import World.IEntity;

public class Player implements IStates, IPlayerPos, IEntity {

    // player states
    private int hunger;
    private int thirst;
    private int energy;

    // player movement speed
    private static final int playerSpeed = 6;

    // constrains for state updates
    private static final int maxState = 100;
    private static final int minState = 0;
    private static final int hungerDecrease = 3;
    private static final int thirstDecrease = 4;
    private static final int energyDecrease = 2;
    public playerHandler playerHandler;
    //private GameScene gameScene;

    // temporary solution
    private static final int stateUpdateInterval = 30000; // 30 seconds
    private Timer stateTimer;
    public static Player player;


    //constructor
    private Player(){
        this.hunger = maxState;
        this.thirst = maxState;
        this.energy = maxState;

        this.playerHandler = new playerHandler();

        startStateTimer();
    }

    public static Player getInstance() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    // temporary solution with timer for updating states
    private void startStateTimer(){
        stateTimer = new Timer(true);
        stateTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateStates();
            }
        }, 0, stateUpdateInterval);
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
        x = x*playerSpeed;
        y = y*playerSpeed;
        this.playerHandler.move(x,y);
    }

    public Point getPos(){
        //System.out.println("playerPos.getPos().x");
        return (playerHandler.getPos());
    }



}
