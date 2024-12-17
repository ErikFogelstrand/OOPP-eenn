package World;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RandomTickGenerator {
    private static final RandomTickGenerator instance = new RandomTickGenerator();

    private final Random rand = new Random();
    private final Timer tickTimer = new Timer();
    private final ArrayList<IRandomTickListener> randomTickListeners = new ArrayList<>();
    private final long maxTime = 10_000; // on average all listeners are sent a tick during this period in ms

    public static RandomTickGenerator getInstance() {return instance;}

    private RandomTickGenerator() {
        startTickTimer();
    }

    public void addListener(IRandomTickListener listener) {
        randomTickListeners.add(listener);
    }
    public void removeListener(IRandomTickListener listener) {
        randomTickListeners.remove(listener);
    }
    private void tick() {
        randomTickListeners.get(rand.nextInt(randomTickListeners.size())).tick();
    }

    // As the number of listeners grow the delay between ticks gets smaller
    private void startTickTimer() {
        long delay = maxTime;
        if (!randomTickListeners.isEmpty()) {
            delay = maxTime/randomTickListeners.size();
        }

        tickTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                tick();
                startTickTimer();
            }
        }, delay);
    }
}
