package com.hunter.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/17 11:00
 */
public class RateLimiterTest {

    private final RateLimiter rateLimiter = RateLimiter.create(2.0);

    public static void main(String[] args) {

    }

    private void submitTasks(List<Runnable> tasks, Executor executor) {
        for (Runnable task : tasks) {
            rateLimiter.acquire();
            executor.execute(task);
        }
    }
}
