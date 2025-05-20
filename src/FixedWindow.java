import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FixedWindow {

    private int capacity;
    private int timeWindow;
    private long startTime;
    int count;

    final Object lock = new Object();

    FixedWindow(int capacity, int timeWindow, long startTime) {
        this.capacity = capacity;
        this.timeWindow = timeWindow;
        this.startTime = startTime;
        count = 0;
    }

    Boolean grantAccess() {
        long currentTime = System.currentTimeMillis();
        synchronized (lock) {
            if ((currentTime - startTime) / 1000 > timeWindow) {
                startTime = currentTime;
                count = 0;
            }
            if (count < capacity) {
                ++count;
                return true;
            }
        }
        return false;

    }
}
