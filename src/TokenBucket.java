public class TokenBucket {

    int capacity;
    int refillRate;//tokens added per refill interval (100 tokens per sec)
    long refillInterval; // Time unit for refill rate (e.g., 1000ms for per second)
    long lastRefillTime;
    long currTokens;

    TokenBucket(int capacity,int refillRate,long refillInterval){
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.refillInterval = refillInterval;
        currTokens = capacity;
        lastRefillTime = System.currentTimeMillis();
    }

    public synchronized boolean grantAccess(){
        //refill tokens
        refillTokens();
        if(currTokens>=1){
            currTokens--;
            return true;
        }
        return false;
    }

    void refillTokens(){
        long currentTime = System.currentTimeMillis();
        long timeElapsed =  currentTime - lastRefillTime;
        if(timeElapsed < 0)return;
        long tokensToAdd = (timeElapsed/refillInterval) * refillRate;
        if(tokensToAdd > 0){
            currTokens = Math.min(capacity,currTokens + tokensToAdd);
            lastRefillTime = currentTime;
        }

    }
}
