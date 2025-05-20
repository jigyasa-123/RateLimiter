import java.util.HashMap;
import java.util.Map;

public class UserBucketTokenBucket {
    Map<Integer,TokenBucket> userBucketMap;

     public UserBucketTokenBucket(int id,int capacity,int refillRate,long refillInterval){
         this.userBucketMap = new HashMap<>();
         this.userBucketMap.put(id,new TokenBucket(capacity,refillRate,refillInterval));
    }

    public  void grantAccess(int id){
         if(userBucketMap.get(id).grantAccess()){
             System.out.println("User is allowed for fixed window:"+id);
         }else{
             System.out.println("Too many requests for fixed window");
         }
    }

}
