import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FixedWindow {

    int capacity;
    int timeWindow;
    long startTime;
    Queue<Long> window;

    FixedWindow(int capacity,int timeWindow,long startTime){
        this.capacity  = capacity;
        this.timeWindow = timeWindow;
        this.startTime = startTime;
        window = new ConcurrentLinkedQueue<>();
    }

    Boolean grantAccess(){
        long currentTime = System.currentTimeMillis();
        if(window.isEmpty() || (currentTime - startTime)/1000 > timeWindow ){
            window = new ConcurrentLinkedQueue<>();
            window.offer(currentTime);
            return true;
        }
        if(window.size() < capacity){
            window.offer(currentTime);
            return true;
        }
        return false;
    }
}
