package com.hunter.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/10/20 20:05
 */
public class AtomicIntegerExample1 {

    public static int clientTotal =100;

    public static int threadTotal = 50;

    public static AtomicInteger count = new AtomicInteger(0);
    
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i=0; i< clientTotal;i++ ) {
            executorService.execute(()-> {
                try{
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    System.out.println(e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(count.get());

    }

    private static void add() {
        count.incrementAndGet();
    }
}
