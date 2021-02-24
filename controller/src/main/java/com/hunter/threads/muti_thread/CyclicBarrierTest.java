package com.hunter.threads.muti_thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author hunter.yang
 * @version 1.0
 * @description JDK内置同步器
 * @date 2021/2/24 10:12
 */
public class CyclicBarrierTest {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("thread1 is waiting");
                cyclicBarrier.await();
                System.out.println("thread1 goes");
            } catch (InterruptedException | BrokenBarrierException e) {

            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("thread2 is waiting");
                cyclicBarrier.await();
                System.out.println("thread2 goes");
            } catch (InterruptedException | BrokenBarrierException e) {

            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(4000);
                System.out.println("thread3 is waiting");
                cyclicBarrier.await();
                System.out.println("thread3 goes");
            } catch (InterruptedException | BrokenBarrierException e) {

            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
