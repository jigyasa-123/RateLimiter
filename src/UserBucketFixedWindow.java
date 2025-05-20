import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserBucketFixedWindow {
    Map<Integer,FixedWindow> userBucketMap;

     public UserBucketFixedWindow(int id, long startTime,int capacity,int timeWindow){
         this.userBucketMap = new ConcurrentHashMap<>();
         this.userBucketMap.put(id,new FixedWindow(capacity,timeWindow,startTime));
    }

    public  void grantAccess(int id){
         if(userBucketMap.get(id).grantAccess()){
             System.out.println("User is allowed for fixed window:"+id);
         }else{
             System.out.println("Too many requests for fixed window");
         }
    }

}
