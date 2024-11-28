package Jagbehöverettpaketförattnåklasserna;

import World.IRandomTickListener;

import java.util.ArrayList;
import java.util.Random;

public class RandomTickGenerator {
    private final Random rand = new Random();
    private ArrayList<IRandomTickListener> randomTickListeners;

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
