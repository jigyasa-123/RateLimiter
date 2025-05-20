import java.awt.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow {
     private int capacity;
     private int timeWindow;
     private Queue<Long> window;

     SlidingWindow(int capacity,int timeWindow){
         this.capacity = capacity;
         this.timeWindow = timeWindow;
         window = new ConcurrentLinkedQueue<>();
     }

     public Boolean grantAccess(){
         long currentTime = System.currentTimeMillis();
         checkAndUpdateWindow(currentTime);
         if(window.size()<capacity){
             window.offer(currentTime);
             return true;
         }
         return false;
     }

     void checkAndUpdateWindow(long currentTime){
         if(window.isEmpty()) return;
         long calculateTime = (currentTime - window.peek())/1000;
         while(calculateTime > timeWindow){
             window.poll();
             if(window.isEmpty()) break;
             calculateTime = (currentTime - window.peek())/1000;
         }

     }

}
