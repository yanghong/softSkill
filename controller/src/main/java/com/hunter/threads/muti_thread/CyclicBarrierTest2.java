package com.hunter.threads.muti_thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/2/24 11:31
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            System.out.println("朋友到了，开始点餐");
        }
    });

    public static void main(String[] args) {
        Thread me = new Thread(() ->{
            try {
                System.out.println("我到达餐馆等女朋友");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {

            }
        });

        Thread girlfriend = new Thread(() ->{
            try {
                System.out.println("化妆半个小时");
                Thread.sleep(30);
                System.out.printf("到达参观");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {

            }
        });

        me.start();;
        girlfriend.start();
    }
}
