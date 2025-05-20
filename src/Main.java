import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Sliding Window
//        UserBucket userBucket = new UserBucket(1,3,10); //5 request in 10 seconds
//        UserBucket userBucket1 = new UserBucket(2,4,1); //4 requests in 1 seconds
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for(int i=1;i<=15;++i){
//            executorService.execute(() -> userBucket.accessApplication(1));
//            executorService.execute(() -> userBucket1.accessApplication(2));
//        }
//        executorService.shutdown();


//        // Fixed Window
//        UserBucketFixedWindow userBucket = new UserBucketFixedWindow(9, System.currentTimeMillis(), 3, 10);
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 15; ++i) {
//            executorService.execute(() -> userBucket.grantAccess(9));
//
//        }
//        executorService.shutdown();
//    }

        UserBucketTokenBucket userBucket = new UserBucketTokenBucket(9,2,1,1000);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 15; ++i) {
            executorService.execute(() -> userBucket.grantAccess(9));
            Thread.sleep(3000);

        }

        executorService.shutdown();
    }
}

/*
* Why concurrent linked queue is used for rate limit?
* chieves thread safety using CAS (Compare-And-Swap) operations instead of traditional locks. This makes it a non-blocking data structure.
*
* */