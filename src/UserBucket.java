import java.util.HashMap;
import java.util.Map;

public class UserBucket {
    private Map<Integer,SlidingWindow> bucket;
    public UserBucket(int id,int capacity,int timeWindow){
        bucket = new HashMap<>();
        bucket.put(id,new SlidingWindow(capacity,timeWindow));
    }

    void accessApplication(int id){
        if(bucket.get(id).grantAccess()){
            System.out.println("User is allowed:"+id);
        }else{
            System.out.println("Too many requests");
        }
    }
}
