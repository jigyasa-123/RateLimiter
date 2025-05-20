import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

       UserBucket userBucket = new UserBucket(1,5,10);
       UserBucket userBucket1 = new UserBucket(2,4,1);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=1;i<=15;++i){
            executorService.execute(() -> userBucket.accessApplication(1));
            executorService.execute(() -> userBucket1.accessApplication(2));
        }
        executorService.shutdown();

    }
}