package Jagbehöverettpaketförattnåklasserna;

import World.IRandomTickListener;

import java.util.ArrayList;
import java.util.Random;

public class RandomTickGenerator {
    private static final RandomTickGenerator instance = new RandomTickGenerator();

    private final Random rand = new Random();
    private final ArrayList<IRandomTickListener> randomTickListeners;

    public static RandomTickGenerator getInstance() {return instance;}

    public RandomTickGenerator() {
        randomTickListeners = new ArrayList<>();
    }

    public void addListener(IRandomTickListener listener) {
        randomTickListeners.add(listener);
    }
    public void removeListener(IRandomTickListener listener) {
        randomTickListeners.remove(listener);
    }
    public void tick() {
        randomTickListeners.get(rand.nextInt(randomTickListeners.size())).tick();
    }
}
