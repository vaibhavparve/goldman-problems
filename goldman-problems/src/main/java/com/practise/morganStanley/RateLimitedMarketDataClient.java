package com.practise.morganStanley;

import org.springframework.util.StringUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class RateLimitedMarketDataClient {
    private final Semaphore rateLimitSemaphore = new Semaphore(100); // 100 requests per second
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    public RateLimitedMarketDataClient() {
        // Replenish permits every second
        scheduler.scheduleAtFixedRate(() -> {
            int availablePermits = rateLimitSemaphore.availablePermits();
            int releasesNeeded = 100 - availablePermits;
            if (releasesNeeded > 0) {
                rateLimitSemaphore.release(releasesNeeded);
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
    
    public String fetchMarketData(String symbol) {
        try {
            rateLimitSemaphore.acquire(); // Will block if we've exceeded rate limit
            return ""; //callMarketDataApi(symbol);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for rate limit", e);
        }
    }
}